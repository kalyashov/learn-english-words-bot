package ru.telegram.learn.english.bot.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.telegram.learn.english.bot.entity.Word;

import java.util.List;

@Repository
public interface WordRepository extends CrudRepository<Word, String> {

    @Query("select id from english_words")
    List<String> getAllWordIds();

    @Query("select max(ID) from english_words")
    Integer getMaxWordId();
}
