package com.example.courses.models;

import com.example.common.utils.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "course_history")
public class CourseHistory extends BaseModel {

    @JsonProperty
    @Column(name = "course_id")
    private Long courseId;

    @JsonProperty
    @Column(name = "professor_id")
    private Long professorId;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @JsonProperty
    @Column
    private String section;
}
