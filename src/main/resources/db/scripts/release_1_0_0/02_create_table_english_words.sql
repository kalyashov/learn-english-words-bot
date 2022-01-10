--liquibase formatted sql

--changeset kalyashov-ga:create_table_english_words rollbackSplitStatements:true
--comment: Создание таблицы английских слов
CREATE TABLE ENGLISH_WORDS
(
    ID              VARCHAR(64) NOT NULL CONSTRAINT ENGLISH_WORD_ID PRIMARY KEY,
    WORD            VARCHAR(128),
    TRANSLATION     VARCHAR(128),
    LEVEL           VARCHAR(8),
    PART_OF_SPEECH  VARCHAR(24),
    EMOJI           VARCHAR(24),
    AUDIO           JSON,
    CREATED_AT      TIMESTAMP NOT NULL,
    UPDATED_AT      TIMESTAMP NOT NULL
);

COMMENT ON TABLE ENGLISH_WORDS IS 'Английские слова';
COMMENT ON COLUMN ENGLISH_WORDS.ID IS 'Идентификатор слова';
COMMENT ON COLUMN ENGLISH_WORDS.WORD IS 'Английское слово';
COMMENT ON COLUMN ENGLISH_WORDS.TRANSLATION IS 'Перевод';
COMMENT ON COLUMN ENGLISH_WORDS.LEVEL IS 'Уровень знанания английского';
COMMENT ON COLUMN ENGLISH_WORDS.PART_OF_SPEECH IS 'Часть речи';
COMMENT ON COLUMN ENGLISH_WORDS.EMOJI IS 'Эмоджи';
COMMENT ON COLUMN ENGLISH_WORDS.AUDIO IS 'Данные аудио с произношеним слова';
COMMENT ON COLUMN ENGLISH_WORDS.CREATED_AT IS 'Дата создания';
COMMENT ON COLUMN ENGLISH_WORDS.UPDATED_AT IS 'Дата обновления';

--rollback DROP TABLE ENGLISH_WORDS;