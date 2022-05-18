package za.co.cicd.controllers;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Data
public class HealthCheckDTO implements Serializable {

    private String applicationName;
    private String status;
    private LocalDateTime localDateTime;
}
