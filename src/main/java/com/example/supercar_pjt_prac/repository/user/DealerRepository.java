package com.example.supercar_pjt_prac.repository.user;

import com.example.supercar_pjt_prac.domain.user.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealerRepository extends JpaRepository<Dealer, Long> {
}
