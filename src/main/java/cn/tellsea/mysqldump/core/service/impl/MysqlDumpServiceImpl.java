package cn.tellsea.mysqldump.core.service.impl;

import cn.tellsea.mysqldump.common.consts.MysqlDumpConst;
import cn.tellsea.mysqldump.common.entity.LayuiTable;
import cn.tellsea.mysqldump.common.util.FileUtils;
import cn.tellsea.mysqldump.core.entity.MysqlDump;
import cn.tellsea.mysqldump.core.mapper.MysqlDumpMapper;
import cn.tellsea.mysqldump.core.service.MysqlDumpService;
import cn.tellsea.mysqldump.core.util.MysqlUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * MysqlDump 接口层 实现类
 *
 * @author Tellsea
 * @date 2020-4-22
 */
@Slf4j
@Service
public class MysqlDumpServiceImpl extends ServiceImpl<MysqlDumpMapper, MysqlDump> implements MysqlDumpService {

    @Override
    public boolean backup(MysqlDump mysqlDump) {
        String datePath = FileUtils.getDatePath("default", FileUtils.DATE_TYPE_SLASH);
        mysqlDump.setFilePath(MysqlDumpConst.SAVE_POSITION + datePath);
        mysqlDump.setUuidName(String.valueOf(UUID.randomUUID()).replace("-", "_"));

        File saveFile = new File(mysqlDump.getFilePath());
        if (!saveFile.exists()) {
            saveFile.mkdirs();
        }
        if (!mysqlDump.getFilePath().endsWith(File.separator)) {
            mysqlDump.setFilePath(mysqlDump.getFilePath() + File.separator);
        }

        StringBuilder arg = new StringBuilder();
        arg.append(MysqlUtils.getCommandPrefix());
        arg.append(System.getProperty("user.dir") + File.separator + "mysqldump");
        arg.append(" -h").append(mysqlDump.getIp());
        arg.append(" -P").append(mysqlDump.getPort());
        arg.append(" -u").append(mysqlDump.getUserName());
        arg.append(" -p").append(mysqlDump.getPassword());
        if (StringUtils.isNotEmpty(mysqlDump.getDefaultCharacterSet())) {
            arg.append(" --default-character-set=").append(mysqlDump.getDefaultCharacterSet());
        }
        if (mysqlDump.getIsCompact() == 1) {
            arg.append(" --compact");
        }
        if (mysqlDump.getIsComments() == 1) {
            arg.append(" --comments");
        }
        if (mysqlDump.getIsCompleteInsert() == 1) {
            arg.append(" --complete-insert");
        }
        if (mysqlDump.getIsLockTables() == 1) {
            arg.append(" --lock-tables");
        }
        if (mysqlDump.getIsNoCreateDb() == 1) {
            arg.append(" --no-create-db");
        }
        if (mysqlDump.getIsForce() == 1) {
            arg.append(" --force");
        }
        if (mysqlDump.getIsAddDropDatabase() == 1) {
            arg.append(" --add-drop-database");
        }
        if (mysqlDump.getIsAddDropTable() == 1) {
            arg.append(" --add-drop-table");
        }
        arg.append(" --databases ").append(mysqlDump.getDatabaseName());
        // 最终文件保存路径
        String targetPath = mysqlDump.getFilePath() + mysqlDump.getUuidName() + ".sql";
        arg.append(" --result-file=").append(targetPath);

        Process process = null;
        try {
            log.info("-------------------------------");
            log.info("执行备份命令：{}", arg.toString());
            log.info("访问备份地址：{}", datePath + mysqlDump.getUuidName() + ".sql");
            process = Runtime.getRuntime().exec(arg.toString());
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getErrorStream(), "GBK"));
            String errorLine;
            while ((errorLine = br.readLine()) != null) {
                log.error(errorLine);
            }
            br.close();
            // 0 表示线程正常终止
            if (process.waitFor() == 0) {
                // 执行成功后，将相关信息存储到数据库
                mysqlDump.setFilePath(datePath + mysqlDump.getUuidName() + ".sql");
                mysqlDump.setCommand(arg.toString());
                this.getBaseMapper().insert(mysqlDump);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            process.destroy();
        }
        FileUtils.deleteDir(targetPath);
        log.error("备份失败，临时文件已删除");
        return false;
    }

    @Override
    public List<MysqlDump> listMysqlDumpAll() {
        LambdaQueryWrapper<MysqlDump> queryWrapper = new LambdaQueryWrapper<MysqlDump>()
                .eq(MysqlDump::getStatus, 1);
        return this.getBaseMapper().selectList(queryWrapper);
    }

    @Override
    public LayuiTable listMysqlDump(MysqlDump mysqlDump) {
        LambdaQueryWrapper<MysqlDump> queryWrapper = new LambdaQueryWrapper<MysqlDump>()
                .eq(MysqlDump::getStatus, 1).orderByDesc(MysqlDump::getCreateTime);
        Integer count = this.getBaseMapper().selectCount(queryWrapper);
        List<MysqlDump> list = null;
        if (count > 0) {
            list = this.getBaseMapper().selectList(queryWrapper);
        }
        return LayuiTable.build(count, list);
    }

    @Override
    public int deleteMysqlDump(MysqlDump mysqlDump) {
        return this.getBaseMapper().updateById(mysqlDump);
    }
}
