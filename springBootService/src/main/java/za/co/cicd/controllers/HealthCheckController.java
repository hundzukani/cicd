package za.co.cicd.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;


@RestController
@Slf4j
public class HealthCheckController {

    @GetMapping(value = "/healthcheck")
    public @ResponseBody
    ResponseEntity<HealthCheckDTO> healthCheck() {
        log.info("Health Check, I'm Alive!");
        return ResponseEntity.status(HttpStatus.OK).body(HealthCheckDTO.builder()
                .applicationName("SpringBootUpgrade")
                .localDateTime(LocalDateTime.now())
                .status("I'm Alive!")
                .build());
    }
}
