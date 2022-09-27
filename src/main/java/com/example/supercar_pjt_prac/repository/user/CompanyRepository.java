package com.example.supercar_pjt_prac.repository.user;

import com.example.supercar_pjt_prac.domain.user.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
