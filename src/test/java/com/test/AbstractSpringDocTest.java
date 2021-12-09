package com.test;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class AbstractSpringDocTest extends AbstractCommonTest {

  protected String getExpectedResult(String name) {
    return getContent("results/" + name);
  }
}
