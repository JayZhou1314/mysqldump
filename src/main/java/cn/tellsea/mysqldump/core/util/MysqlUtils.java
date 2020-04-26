package cn.tellsea.mysqldump.core.util;

/**
 * Mysql 工具类
 *
 * @author Tellsea
 * @date 2020-4-25
 */
public class MysqlUtils {

    /**
     * 获得命令前缀
     *
     * @return
     */
    public static String getCommandPrefix() {
        String os = System.getProperties().getProperty("os.name");
        return os.startsWith("Win") ? "cmd /c " : "/bin/sh -c ";
    }
}
