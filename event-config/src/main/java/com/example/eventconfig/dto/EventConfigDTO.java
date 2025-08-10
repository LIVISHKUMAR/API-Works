package com.example.eventconfig.dto;

import com.example.eventconfig.enums.EventCategory;
import com.example.eventconfig.enums.EventCriticality;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventConfigDTO {
    private String domain;
    private String name;
    private String description;
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
    private EventCriticality criticality;
    private long timeBeforeRaising;
    private long autoNormalAfter;
}
