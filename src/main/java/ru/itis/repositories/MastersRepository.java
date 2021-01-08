package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Master;

public interface MastersRepository extends JpaRepository<Master, Long> {
}
