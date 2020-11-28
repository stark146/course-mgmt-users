package com.coursemanagement.app.repository;

import com.coursemanagement.app.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    public Optional<Users> findByUsername(String username);

    @Query("select max(id) from Users")
    public Long findMaxId();

    @Query("select u.name from User u where u.id in (:pIdList)")
    public List<String> findByIdList(@Param("pIdList") List<Long> idList);

    @Modifying
    @Query("delete from User u where u.name = :name")
    public void deleteCustomName(@Param("name") String name);
}
