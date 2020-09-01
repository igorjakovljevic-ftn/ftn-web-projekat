package faks.web.projekat.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import faks.web.projekat.entity.Roles;
import faks.web.projekat.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User,Long>{

	 User findByEmail(String email);
	 
	 List<User> findByRole(Roles role);

}
