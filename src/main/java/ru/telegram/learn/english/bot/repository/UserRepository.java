package ru.telegram.learn.english.bot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.telegram.learn.english.bot.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {}
