package pl.amanowicz.dictionary.controllers;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.amanowicz.dictionary.model.TranslatedWord;
import pl.amanowicz.dictionary.services.TranslationService;
import pl.amanowicz.dictionary.utils.Language;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static pl.amanowicz.dictionary.utils.TestUtils.readValue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class TranslationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TranslationService service;

    @Before
    public void setup() {
        mockMvc = standaloneSetup(new TranslationController(service)).build();
    }

    @Test
    public void shouldReturnTranslatedWord() throws Exception {
        String word = "kot";
        Language language = Language.EN;
        TranslatedWord expectedWord = new TranslatedWord("cat", language);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/translations")
                .param("word", word)
                .param("translationLanguage", language.toString()))
                .andExpect(status().isOk())
                .andReturn();

        TranslatedWord actualResult = readValue(result, TranslatedWord.class);
        assertThat(actualResult).isEqualTo(expectedWord);
    }
}