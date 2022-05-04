package OneToOne.example.onetoone_task.repository;

import OneToOne.example.onetoone_task.model.Mobil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobilRepository extends JpaRepository<Mobil, Long> {
/*
* SELECT*FROM Mobil
* WHERE is_deleted=false
* */
@Query("SELECT m FROM Mobil m WHERE m.isDeleted = false")
List<Mobil> findAllNotDeleted();

}
