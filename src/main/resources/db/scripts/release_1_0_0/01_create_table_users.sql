--liquibase formatted sql

--changeset kalyashov-ga:create_table_users rollbackSplitStatements:true
--comment: Создание таблицы пользователей
CREATE TABLE USERS
(
    ID                VARCHAR(64) NOT NULL CONSTRAINT USER_ID PRIMARY KEY,
    CHAT_ID           VARCHAR(128),
    FIRST_NAME        VARCHAR(128),
    LAST_NAME         VARCHAR(128),
    USER_NAME         VARCHAR(128),
    LEARNING_PROCESS  JSONB,
    CREATED_AT        TIMESTAMP NOT NULL,
    UPDATED_AT        TIMESTAMP NOT NULL
);

COMMENT ON TABLE USERS IS 'Пользователи';
COMMENT ON COLUMN USERS.ID IS 'Идентификатор пользователя';
COMMENT ON COLUMN USERS.FIRST_NAME IS 'Имя';
COMMENT ON COLUMN USERS.LAST_NAME IS 'Фамилия';
COMMENT ON COLUMN USERS.USER_NAME IS 'Никнейм';
COMMENT ON COLUMN USERS.LEARNING_PROCESS IS 'Процесс обучения пользователя';
COMMENT ON COLUMN USERS.CREATED_AT IS 'Дата создания';
COMMENT ON COLUMN USERS.UPDATED_AT IS 'Дата обновления';

--rollback DROP TABLE USERS;