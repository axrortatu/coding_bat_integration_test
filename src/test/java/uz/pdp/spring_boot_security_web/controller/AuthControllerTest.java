package uz.pdp.spring_boot_security_web.controller;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.testcontainers.lifecycle.Startables;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AuthControllerTest extends BaseTest {
    private final static String PATH_ADD = "/api/user/add";

    @BeforeAll
    static void beforeAll() {
        Startables.deepStart(postgres).join();
    }

    @AfterEach
    void afterAll() {
         userRepository.deleteAll();
    }

    @Test
    public void addUserShouldReturnOKStatus() throws Exception {
        callAdd().andExpect(status().isOk());

    }
    @Test
    public void addUserShouldThrowUserExist() throws Exception {
        callAdd();
        callAdd().andExpect(status().isBadRequest());
    }

    private ResultActions callAdd() throws Exception {

        final MockHttpServletRequestBuilder request =
                post(PATH_ADD)
                        .param("name", "Asror")
                        .param("username", "asror")
                        .param("password", "123");
        return mockMvc.perform(request);
    }

}