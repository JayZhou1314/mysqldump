package cn.tellsea.mysqldump.backup.util;

import cn.tellsea.mysqldump.common.exception.ConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Mysql 工具类
 *
 * @author Tellsea
 * @date 2020-4-25
 */
public class MysqlUtils {

    private static Connection conn = null;

    /**
     * 获得命令前缀
     *
     * @return
     */
    public static String getCommandPrefix() {
        String os = System.getProperties().getProperty("os.name");
        return os.startsWith("Win") ? "cmd /c " : "/bin/sh -c ";
    }

    /**
     * 获得数据库连接
     *
     * @param url
     * @param userName
     * @param passWord
     * @return
     */
    public static Connection getConnection(String url, String userName, String passWord) {
        if (null == conn) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, userName, passWord);
            } catch (Exception e) {
                throw new ConnectionException("连接数据库失败，请检查参数");
            }
        }
        return conn;
    }
}
