package com.dfn.crudapp.repository;

import com.dfn.crudapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "select * from `user` order by `id` desc limit 5 ",nativeQuery = true)
    List<User> findLast5Users();
}
