package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;

@Slf4j
public class SwaggerUiTest extends AbstractSpringDocTest {
  @Test
  public void shouldDisplaySwaggerUiPage() throws Exception {
    MvcResult mvcResult =
        mockMvc.perform(get("/swagger-ui/index.html")).andExpect(status().isOk()).andReturn();
    String contentAsString = mvcResult.getResponse().getContentAsString();
    // log.info("contentAsString: {}", contentAsString);
    assertTrue(contentAsString.contains("Swagger UI"));
  }

  @Test
  public void shouldHaveDefaultContent() throws Exception {
    MvcResult mvcResult =
        mockMvc.perform(get("/swagger-ui/index.html")).andExpect(status().isOk()).andReturn();
    String transformedIndex = mvcResult.getResponse().getContentAsString();
    assertTrue(transformedIndex.contains("Swagger UI"));
    assertEquals(this.getExpectedResult("explore"), transformedIndex);
  }
}
