package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.AcademicAdviser;
import ru.itis.models.MasterApplication;

public interface MasterApplicationsRepository extends JpaRepository<MasterApplication, Long> {
}
