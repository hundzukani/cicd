package za.co.cicd.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GreetController {

    @GetMapping(value = "/greet/{name}")
    public @ResponseBody
    ResponseEntity<String> greet(@PathVariable("name") String name) {
        log.info("Hello {}", name);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Hello %s", name));
    }
}
