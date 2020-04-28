package cn.tellsea.mysqldump.backup.service;

import cn.tellsea.mysqldump.common.entity.LayuiTable;
import cn.tellsea.mysqldump.backup.entity.MysqlRecover;

/**
 * 恢复 接口层
 *
 * @author Tellsea
 * @date 2020-4-25
 */
public interface MysqlRecoverService {

    boolean recover(MysqlRecover mysqlRecover);

    LayuiTable listMysqlRecover(MysqlRecover mysqlRecover);

    int deleteMysqlRecover(MysqlRecover mysqlRecover);
}
