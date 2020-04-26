package cn.tellsea.mysqldump.common.consts;

/**
 * 文件路径常量
 *
 * @author Tellsea
 * @date 2020/4/11
 */
public interface MysqlDumpConst {

    String PROJECT_LOCATION = System.getProperty("user.dir");
    /**
     * 保存位置（当前项目运行的相对根路径）
     */
    String SAVE_POSITION = PROJECT_LOCATION.concat("/mysqldump-static");
}
