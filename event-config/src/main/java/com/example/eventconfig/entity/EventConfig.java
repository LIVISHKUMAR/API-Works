package com.example.eventconfig.entity;

import com.example.eventconfig.enums.EventCategory;
import com.example.eventconfig.enums.EventCriticality;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String domain;
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private EventCategory category;

    private String status;
    private String type;

    private String preConditionsExpression;
    private String preConditionsQuery;
    private String conditionsExpression;
    private String conditionsQuery;
    private String postConditionsExpression;
    private String postConditionsQuery;

    private String message;
    private String normalMessage;

    @Enumerated(EnumType.STRING)
    private EventCriticality criticality;

    private long timeBeforeRaising;
    private long autoNormalAfter;
}
