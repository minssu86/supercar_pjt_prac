package com.example.supercar_pjt_prac.repository.user;

import com.example.supercar_pjt_prac.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
