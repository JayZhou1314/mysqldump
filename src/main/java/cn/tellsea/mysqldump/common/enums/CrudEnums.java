package cn.tellsea.mysqldump.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * crud 类型枚举
 *
 * @author Tellsea
 * @date 2020/4/4
 */
@AllArgsConstructor
public enum CrudEnums {

    SAVE(1),
    DELETE(2),
    UPDATE(3),
    ;

    @Setter
    @Getter
    private int code;
}
