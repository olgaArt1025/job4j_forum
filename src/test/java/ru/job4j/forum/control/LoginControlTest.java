package ru.job4j.forum.control;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class LoginControlTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageLoginPage() throws Exception {
        this.mockMvc.perform(get("/login"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    @WithMockUser
    public void shouldReturnErrorMessage() throws Exception {
        this.mockMvc.perform(get("/login")
                        .param("error", "true"))
                .andDo(print())
                .andExpect(model().attribute("errorMessge",
                        "Username or Password is incorrect !!"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    @WithMockUser
    public void shouldReturnMessageLoginPage() throws Exception {
        this.mockMvc.perform(get("/login")
                        .param("logout", "true"))
                .andDo(print())
                .andExpect(model().attribute("errorMessge",
                        "You have been successfully logged out !!"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    @WithMockUser
    public void shouldReturnRedirectLogoutMessage() throws Exception {
            this.mockMvc.perform(get("/logout"))
                    .andDo(print())
                    .andExpect(status().isFound())
                    .andExpect(redirectedUrl("/login?logout=true"));
        }
}