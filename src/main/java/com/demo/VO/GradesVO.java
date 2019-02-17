package com.demo.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GradesVO {

    @JsonProperty("cno")
    private String cno;

    @JsonProperty("cname")
    private String cname;

    @JsonProperty("credit")
    private int credit;

    @JsonProperty("grade")
    private int grade;

}
