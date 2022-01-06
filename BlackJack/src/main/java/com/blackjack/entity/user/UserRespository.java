package com.blackjack.entity.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRespository extends JpaRepository<User, Integer> {
	 @Query("select u from User u where u.userName = ?1 and u.password = ?2")
	   User getUser(String user_name, String password);
}
