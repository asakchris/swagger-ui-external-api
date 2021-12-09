package com.test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import nonapi.io.github.classgraph.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@ActiveProfiles("test")
public abstract class AbstractCommonTest {
  @Autowired protected MockMvc mockMvc;

  protected String getContent(String fileName) {
    try {
      Path path = Paths.get(FileUtils.class.getClassLoader().getResource(fileName).toURI());
      byte[] fileBytes = Files.readAllBytes(path);
      return new String(fileBytes, StandardCharsets.UTF_8);
    } catch (Exception e) {
      throw new RuntimeException("Failed to read file: " + fileName, e);
    }
  }
}
