package cn.tellsea.mysqldump.backup.service;

import cn.tellsea.mysqldump.common.entity.LayuiTable;
import cn.tellsea.mysqldump.backup.entity.MysqlDump;

import java.util.List;

/**
 * 备份 接口层
 *
 * @author Tellsea
 * @date 2020-4-22
 */
public interface MysqlDumpService {

    boolean backup(MysqlDump mysqlDump);

    List<MysqlDump> listMysqlDumpAll();

    LayuiTable listMysqlDump(MysqlDump mysqlDump);

    int deleteMysqlDump(MysqlDump mysqlDump);
}
