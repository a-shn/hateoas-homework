package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.College;

public interface CollegesRepository extends JpaRepository<College, Long> {
}
