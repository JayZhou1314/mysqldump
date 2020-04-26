package cn.tellsea.mysqldump.core.service;

import cn.tellsea.mysqldump.common.entity.LayuiTable;
import cn.tellsea.mysqldump.core.entity.MysqlRecover;

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
