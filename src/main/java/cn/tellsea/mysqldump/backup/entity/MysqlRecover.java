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
 * 恢复相关信息
 *
 * @author Tellsea
 * @date 2020-4-25
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("mysql_recover")
public class MysqlRecover extends BaseEntity {

    private int id;
    /**
     * 备份id
     */
    private int dumpId;
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
     * 需要恢复的数据库的名称
     */
    private String databaseName;
    /**
     * 是/否：新建数据库
     */
    private int isCreateDb;


    /**
     * 最终执行的命令
     */
    private String command;
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


    @TableField(exist = false)
    private String fileName;
    @TableField(exist = false)
    private String filePath;
}
