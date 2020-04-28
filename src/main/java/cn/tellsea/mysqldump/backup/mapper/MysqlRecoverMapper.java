package cn.tellsea.mysqldump.backup.mapper;

import cn.tellsea.mysqldump.backup.entity.MysqlRecover;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Tellsea
 * @date 2020-4-25
 */
public interface MysqlRecoverMapper extends BaseMapper<MysqlRecover> {

    int countMysqlRecover(@Param("entity")MysqlRecover mysqlRecover);

    List<MysqlRecover> listMysqlRecover(@Param("entity") MysqlRecover mysqlRecover);
}
