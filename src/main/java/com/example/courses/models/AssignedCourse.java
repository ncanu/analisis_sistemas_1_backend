package com.example.courses.models;

import com.example.common.utils.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "assigned_course")
public class AssignedCourse extends BaseModel {

    @JsonProperty
    @Column(name = "course_history_id")
    private Long courseHistoryId;

    @JsonProperty
    @Column(name = "student_id")
    private Long studentId;
}
