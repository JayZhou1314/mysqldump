package cn.tellsea.mysqldump.core.controller;

import cn.tellsea.mysqldump.common.entity.LayuiTable;
import cn.tellsea.mysqldump.common.entity.ResponseResult;
import cn.tellsea.mysqldump.common.enums.CrudEnums;
import cn.tellsea.mysqldump.core.entity.MysqlDump;
import cn.tellsea.mysqldump.core.service.MysqlDumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Mysql 数据库备份 控制器
 *
 * @author Tellsea
 * @date 2020-4-22
 */
@Controller
@RequestMapping("/core/mysqlDump")
public class MysqlDumpController {

    @Autowired
    private MysqlDumpService mysqlDumpService;

    @GetMapping("index")
    public String index() {
        return "mysql_backup_add";
    }

    @PostMapping("backup")
    @ResponseBody
    public ResponseResult backup(MysqlDump mysqlDump) {
        return ResponseResult.verifyBoolean(mysqlDumpService.backup(mysqlDump));
    }

    @GetMapping("init")
    public String init() {
        return "mysql_backup_list";
    }

    @PostMapping("list")
    @ResponseBody
    public LayuiTable list(MysqlDump mysqlDump) {
        return mysqlDumpService.listMysqlDump(mysqlDump);
    }

    @PostMapping("delete")
    @ResponseBody
    public ResponseResult delete(MysqlDump mysqlDump) {
        return ResponseResult.verify(CrudEnums.DELETE, mysqlDumpService.deleteMysqlDump(mysqlDump));
    }
}
