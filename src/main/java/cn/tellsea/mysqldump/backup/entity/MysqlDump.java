package cn.tellsea.mysqldump.backup.entity;

import cn.tellsea.mysqldump.common.entity.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 备份相关信息
 *
 * @author Tellsea
 * @date 2020-4-25
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("mysql_dump")
public class MysqlDump extends BaseEntity {

    private int id;
    /**
     * ip地址，可以是本机也可以是远程
     */
    private String ip;
    /**
     * 数据库的端口
     */
    private int port;
    /**
     * 数据库的用户名
     */
    private String userName;
    /**
     * 数据库的密码
     */
    private String password;
    /**
     * 备份的相对路径
     */
    private String filePath;
    /**
     * 备份的文件名
     */
    private String fileName;
    private String uuidName;
    /**
     * 需要备份的数据库的名称
     */
    private String databaseName;
    /**
     * 字符编码
     */
    private String defaultCharacterSet;

    /**
     * 参数配置
     */

    /**
     * 是/否：压缩模式，产生更少的输出
     */
    private int isCompact;
    /**
     * 是/否：注释信息
     */
    private int isComments;
    /**
     * 是/否：使用完整的insert语句(包含列名称)
     */
    private int isCompleteInsert;
    /**
     * 是/否：备份前，锁定所有数据库表
     */
    private int isLockTables;
    /**
     * 是/否：禁止生成创建数据库语句
     */
    private int isNoCreateDb;
    /**
     * 是/否：当出现错误时仍然继续备份操作
     */
    private int isForce;
    /**
     * 是/否：每个数据库创建之前添加drop数据库语句
     */
    private int isAddDropDatabase;
    /**
     * 是/否：每个数据库创建之前添加drop数据库语句
     */
    private int isAddDropTable;


    /**
     * 是/否：指定备份表
     */
    private int isSpecifyTable;
    /**
     * 指定备份的表名
     */
    private String specifyTable;


    /**
     * 最终执行的命令
     */
    private String command;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 状态(1正常，2删除)
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer status;
}
