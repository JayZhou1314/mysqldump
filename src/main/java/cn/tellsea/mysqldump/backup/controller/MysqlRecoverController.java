package cn.tellsea.mysqldump.backup.controller;

import cn.tellsea.mysqldump.common.entity.LayuiTable;
import cn.tellsea.mysqldump.common.entity.ResponseResult;
import cn.tellsea.mysqldump.common.enums.CrudEnums;
import cn.tellsea.mysqldump.backup.entity.MysqlRecover;
import cn.tellsea.mysqldump.backup.service.MysqlDumpService;
import cn.tellsea.mysqldump.backup.service.MysqlRecoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Tellsea
 * @date 2020-4-25
 */
@Controller
@RequestMapping("/backup/mysqlRecover")
public class MysqlRecoverController {

    @Autowired
    private MysqlRecoverService mysqlRecoverService;
    @Autowired
    private MysqlDumpService mysqlDumpService;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("mysqlDumpList", mysqlDumpService.listMysqlDumpAll());
        return "mysql_recover_add";
    }

    @PostMapping("recover")
    @ResponseBody
    public ResponseResult recover(MysqlRecover mysqlRecover) {
        return ResponseResult.verifyBoolean(mysqlRecoverService.recover(mysqlRecover));
    }

    @GetMapping("init")
    public String init() {
        return "mysql_recover_list";
    }

    @PostMapping("list")
    @ResponseBody
    public LayuiTable list(MysqlRecover mysqlRecover) {
        return mysqlRecoverService.listMysqlRecover(mysqlRecover);
    }

    @PostMapping("delete")
    @ResponseBody
    public ResponseResult delete(MysqlRecover mysqlRecover) {
        return ResponseResult.verify(CrudEnums.DELETE, mysqlRecoverService.deleteMysqlRecover(mysqlRecover));
    }
}
