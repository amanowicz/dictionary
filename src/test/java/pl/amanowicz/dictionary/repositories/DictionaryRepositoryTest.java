package pl.amanowicz.dictionary.repositories;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import pl.amanowicz.dictionary.entities.Dictionary;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Sql(value = "classpath:data.sql")
class DictionaryRepositoryTest {

    @Autowired
    private DictionaryRepository repository;

    @Test
    public void shouldFindDictionaryByPolishWord(){
        String polishWord = "pies";

        Optional<Dictionary> result = repository.findByPolishWord(polishWord);

        assertThat(result.get()).extracting(
                Dictionary::getId,
                Dictionary::getPolishWord,
                Dictionary::getEnglishWord
        ).contains(2L, "pies", "dog");

    }
}