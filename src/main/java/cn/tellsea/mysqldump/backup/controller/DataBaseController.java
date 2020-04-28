package cn.tellsea.mysqldump.backup.controller;

import cn.tellsea.mysqldump.backup.entity.MysqlDump;
import cn.tellsea.mysqldump.backup.service.DataBaseService;
import cn.tellsea.mysqldump.common.entity.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tellsea
 * @date 2020-4-27
 */
@RestController
@RequestMapping("/backup/dataBase")
public class DataBaseController {

    @Autowired
    private DataBaseService dataBaseService;

    @PostMapping("connection")
    @ResponseBody
    public ResponseResult connection(MysqlDump mysqlDump) {
        return ResponseResult.success(dataBaseService.connection(mysqlDump));
    }

    @PostMapping("getTableList")
    @ResponseBody
    public ResponseResult getTableList(MysqlDump mysqlDump) {
        return ResponseResult.success(dataBaseService.getTableList(mysqlDump));
    }
}
