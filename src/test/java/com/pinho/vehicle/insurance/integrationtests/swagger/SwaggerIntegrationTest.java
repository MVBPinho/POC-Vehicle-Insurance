package com.pinho.vehicle.insurance.integrationtests.swagger;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,properties = {"server.port=8888"})
public class SwaggerIntegrationTest {

   private final String url = "/swagger-ui/index.html";


}
