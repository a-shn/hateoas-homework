package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.AcademicAdviserApplication;
import ru.itis.models.MasterApplication;

public interface AcademicAdviserApplicationsRepository extends JpaRepository<AcademicAdviserApplication, Long> {
}
