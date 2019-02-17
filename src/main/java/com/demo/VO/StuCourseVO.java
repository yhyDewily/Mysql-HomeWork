package com.demo.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StuCourseVO {

    @JsonProperty("sno")
    private String sno;

    @JsonProperty("cno")
    private String cno;
}
