package cn.tellsea.mysqldump.common.entity;

import cn.tellsea.mysqldump.common.enums.StatusEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * layui 数据表格
 *
 * @author Tellsea
 * @date 2020-4-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LayuiTable implements Serializable {

    /**
     * 为0,则表示成功
     */
    private int code;

    /**
     * 提示消息
     */
    private String msg;

    /**
     * 总条数,用于分页
     */
    private int count;

    /**
     * 分页后的数据
     */
    private Object data;

    public static LayuiTable build(int count, Object data) {
        LayuiTable layuiTable = new LayuiTable();
        layuiTable.code = StatusEnums.LAYUI_SUCCESS.getCode();
        layuiTable.msg = StatusEnums.LAYUI_SUCCESS.getInfo();
        layuiTable.count = count;
        layuiTable.data = data;
        return layuiTable;
    }
}
