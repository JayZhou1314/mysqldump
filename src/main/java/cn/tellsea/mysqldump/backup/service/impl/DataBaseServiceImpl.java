package cn.tellsea.mysqldump.backup.service.impl;

import cn.tellsea.mysqldump.backup.entity.MysqlDump;
import cn.tellsea.mysqldump.backup.service.DataBaseService;
import cn.tellsea.mysqldump.backup.util.MysqlUtils;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tellsea
 * @date 2020-4-27
 */
@Service
public class DataBaseServiceImpl implements DataBaseService {

    @Override
    public List<String> connection(MysqlDump mysqlDump) {
        String[] ignoreArr = new String[]{
                "information_schema",
                "performance_schema",
                "mysql",
                "sys"
        };
        List<String> list = new ArrayList<>();
        String url = "jdbc:mysql://" + mysqlDump.getIp() + ":" + mysqlDump.getPort();
        Connection conn = MysqlUtils.getConnection(url, mysqlDump.getUserName(), mysqlDump.getPassword());
        String sql = " show databases ";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                if (!Arrays.asList(ignoreArr).contains(rst.getString("Database"))) {
                    list.add(rst.getString("Database"));
                }
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<String> getTableList(MysqlDump mysqlDump) {
        List<String> list = new ArrayList<>();
        String url = "jdbc:mysql://" + mysqlDump.getIp() + ":" + mysqlDump.getPort();
        Connection conn = MysqlUtils.getConnection(url, mysqlDump.getUserName(), mysqlDump.getPassword());
        String sql = " select table_name from information_schema.tables where table_schema='" + mysqlDump.getDatabaseName() + "' and table_type='base table' ";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                list.add(rst.getString("table_name"));
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
