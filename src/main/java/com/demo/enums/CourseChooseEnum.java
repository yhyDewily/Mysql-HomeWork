package com.demo.enums;

import lombok.Getter;

@Getter
public enum CourseChooseEnum {

    ADD(1, "选课"),
    DEL(2, "退课"),
    ADD_SUCCESS(3, "选课成功"),
    ADD_FAIL(4, "选课失败"),
    DEL_SUCCESS(5, "退课成功"),
    DEL_FAIL(6, "退课失败")
    ;

    private Integer code;

    private String message;

    CourseChooseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
