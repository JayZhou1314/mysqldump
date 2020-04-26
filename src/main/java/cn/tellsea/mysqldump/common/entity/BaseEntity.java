package cn.tellsea.mysqldump.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 基类 实体类
 *
 * @author Tellsea
 * @date 2020/3/16
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class BaseEntity implements Serializable {

    @TableField(exist = false)
    private int page;
    @TableField(exist = false)
    private int offset;
    @TableField(exist = false)
    private int limit;

    public int getOffset() {
        return (page - 1) * limit;
    }
}
