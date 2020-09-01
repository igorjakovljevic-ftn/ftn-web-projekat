package faks.web.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import faks.web.projekat.entity.Room;
@Repository
public interface RoomRepo extends JpaRepository<Room,Long>{
	@Modifying
	@Query("update Room set mark = :mark, capacity=:capacity WHERE id = :Id")
    void updateRoom(@Param("Id") Long id, @Param("capacity") Long capacity,@Param("mark") String mark);
}
