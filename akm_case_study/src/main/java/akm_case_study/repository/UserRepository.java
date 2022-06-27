package akm_case_study.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import akm_case_study.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);

	@Query(value = "SELECT * FROM user WHERE user.user_id = '1'",
	       nativeQuery = true)
	    List<User> findFirstRegisteredUser();
	
}
