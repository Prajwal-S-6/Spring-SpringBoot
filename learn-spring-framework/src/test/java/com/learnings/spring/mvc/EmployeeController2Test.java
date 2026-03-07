package com.learnings.spring.mvc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql({"/schema.sql", "/data.sql"})
@ComponentScan(basePackages = "com.learnings.spring.mvc")
class EmployeeController2Test {

    @LocalServerPort
    private Integer port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String url;

    @BeforeEach
    void setUp() {
        url = String.format("http://localhost:%d", port);
    }

    @Test
    public void shouldFetchAllEmployees() throws Exception {
        ResponseEntity<List<Employee>> response = restTemplate
                .withBasicAuth("user", "password")
                .exchange(url + "/api/employee", HttpMethod.GET,null,
                new ParameterizedTypeReference<List<Employee>>() {});
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().size()).isEqualTo(2);
        assertThat(response.getBody().stream().map(Employee::getName).toList())
                .isEqualTo(List.of("e1", "e2"));
    }

    @Test
    public void shouldThrowEmployeeNotFoundWhenDeletingInvalidEmployee() {
        ResponseEntity<Void> response = restTemplate.withBasicAuth("admin", "password")
                .exchange(url + "/api/employee?id=6", HttpMethod.DELETE, null,
                        Void.class);
        assertThat(response.getStatusCode()).isEqualTo(BAD_REQUEST);
    }


}