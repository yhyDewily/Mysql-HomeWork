package com.demo.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CourseVO {

    @JsonProperty("cno")
    private String cno;

    @JsonProperty("cname")
    private String cname;
}

