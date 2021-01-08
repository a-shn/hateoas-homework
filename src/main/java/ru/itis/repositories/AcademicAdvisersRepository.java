package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.AcademicAdviser;

public interface AcademicAdvisersRepository extends JpaRepository<AcademicAdviser, Long> {
}
