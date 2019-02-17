package com.demo.VO;

import com.demo.dataobject.Course;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ResultVO {

    private String cno;

    private Integer code;

    private String msg;

    @JsonProperty("course")
    Course course;
}
