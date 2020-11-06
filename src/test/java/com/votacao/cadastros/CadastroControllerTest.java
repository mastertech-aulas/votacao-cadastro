package com.votacao.cadastros;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class CadastroControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private EleitorRepository repository;

    @Test
    public void deveCadastrarUmEleitor() throws Exception{
        var eleitor = new Eleitor();
        eleitor.setNome("José da Silva");
        eleitor.setCpf("123.123.123-12");
        eleitor.setInscricao("111222333");
        eleitor.setSecao("1234");
        eleitor.setZona("AB");

        String content = mapper.writeValueAsString(eleitor);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
        .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void deveGerarUmErroAoCadastrarUmEleitorSemAInscricao(){

    }

    @Test
    public void deveGerarUmErroAoCadastrarUmEleitorComCpfDuplicado(){

    }

    @Test
    public void deveConsultarTodosOsEleitores() throws Exception{
        var eleitor = new Eleitor();
        eleitor.setNome("José da Silva");
        eleitor.setCpf("123.123.123-12");
        eleitor.setInscricao("111222333");
        eleitor.setSecao("1234");
        eleitor.setZona("AB");

        repository.save(eleitor);

        String content = mapper.writeValueAsString(eleitor);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome", Matchers.contains("José da Silva") ));
    }

}
