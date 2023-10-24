package com.picpaysimplificado.picpaysimplificado.doMain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {


    Optional<User> findByIdDocument(String document);

    Optional<User> findById(Long aLong);
}
