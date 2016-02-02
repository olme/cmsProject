package se.ajaj.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.ajaj.cms.exception.CmsException;
import se.ajaj.cms.model.User;
import se.ajaj.cms.model.User.UserStatus;
import se.ajaj.cms.repository.TeamRepository;
import se.ajaj.cms.repository.UserRepository;
import se.ajaj.cms.validate.Validator;

@Service
public final class CmsService
{
	@Autowired
	UserRepository userRepository;
	TeamRepository teamRepository;

	@Autowired
	public CmsService(UserRepository userRepository, TeamRepository teamRepository)
	{
		this.userRepository = userRepository;
		this.teamRepository = teamRepository;
	}

	// -- User
	public User saveUser(User user) throws CmsException
	{
		if (Validator.isValid(user))
		{
			return userRepository.save(user);
		}
		else
		{
			throw new CmsException("Username must be at least 10 characters long.");
		}
	}

	public User updateUser(int userId, User inputUser)
	{
		User user = userRepository.findUserByUserId(userId);
		user.updateValues(inputUser);
		return userRepository.save(user);
	}

	public User updateUserStatus(int userId, UserStatus status)
	{
		User user = userRepository.findUserByUserId(userId);
		user.setUserStatus(status);
		return userRepository.save(user);
	}

	public User findUserByUserId(int userId)
	{
		return userRepository.findUserByUserId(userId);
	}

	public User findUserByUsername(String username)
	{
		return userRepository.findUserByUsername(username);
	}

	public User findUserByFirstName(String firstName, String lastName)
	{
		return userRepository.findUserByFirstNameOrLastName(firstName, lastName);
	}
}
