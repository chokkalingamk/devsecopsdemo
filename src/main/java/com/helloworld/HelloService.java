package com.helloworld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

  @Value("${config.external.string}")
  private String config1;
  @Value("${config.external.number}")
  private Integer config2;
  @Value("${config.external.bool}")
  private Boolean config3;
  @Value("${config.local.application.properties}")
  private String config5;
  @Value("${secret.non.encoded}")
  private String config7;

  public String testConfig1Variable() {
    return config1;
  }

  public Integer testConfig2Variable() {
    return config2;
  }

  public Boolean testConfig3Variable() {
    return config3;
  }
  public String testConfig5Variable() {
    return config5;
  }

  public String testConfig7Variable() {
    return config7;
  }
}
