package com.wefox.wefox.repository;

import com.wefox.wefox.model.Error;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorRepository extends JpaRepository<Error, String> {
}
