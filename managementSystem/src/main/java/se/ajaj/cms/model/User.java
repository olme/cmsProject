package se.ajaj.cms.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class User extends AbstractEntity
{
	@Column(nullable = false)
	private String username;
	@Column(unique = true)
	private int userId;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;

	public User(String username, int userId, String firstName, String lastName)
	{
		this.username = username;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getUsername()
	{
		return username;
	}

	public int getUserId()
	{
		return userId;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}
}
