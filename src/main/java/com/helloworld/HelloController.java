package com.helloworld;

import io.micrometer.core.annotation.Timed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@RestController
@Timed
public class HelloController {
    HelloService helloService;
    private static final Logger LOG = LogManager.getLogger(HelloController.class);

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/stringconfig")
    public ResponseEntity<String> config1() {
        String config1 = helloService.testConfig1Variable();
        return ResponseEntity.ok(config1);
    }

    @GetMapping("/intconfig")
    public ResponseEntity<Integer> config2() {
        Integer config2 = helloService.testConfig2Variable();
        return ResponseEntity.ok(config2);
    }

    @GetMapping("/boolconfig")
    public ResponseEntity<Boolean> config3() {
      Boolean config3 = helloService.testConfig3Variable();
      return ResponseEntity.ok(config3);
    }

    @GetMapping("/internalconfig")
    public ResponseEntity<String> config5() {
        String config5 = helloService.testConfig5Variable();
        return ResponseEntity.ok(config5);
    }

    @GetMapping("/nonencsecret")
    public ResponseEntity<String> config7() {
        String config7 = helloService.testConfig7Variable();
        return ResponseEntity.ok(config7);
    }

    // Do not remove this method since it is being used to simulate logs in test automation framework
    @GetMapping("/main/automation-test")
    public ResponseEntity<HttpStatus> addLog() {
      LOG.info("************ This is an info log");
      return ResponseEntity.ok(HttpStatus.OK);
    }
}
