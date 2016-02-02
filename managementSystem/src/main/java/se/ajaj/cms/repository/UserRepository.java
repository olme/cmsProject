package se.ajaj.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import se.ajaj.cms.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>
{
	@Query("select u from User u where u.userId = :userId")
	public User findUserByUserId(@Param("userId") int userId);

	@Query("select u from User u where u.username = :username")
	public User findUserByUsername(@Param("username") String usernam);

	@Query("select u from User u where u.firstName = :firstName or u.lastName =:lastName")
	public User findUserByFirstNameOrLastName(@Param("firstName") String firstName,
			@Param("lastName") String lastName);

	@Query("select u from User u where u.team = :teamId")
	public List<User> users(@Param("teamId") Long id);
}
