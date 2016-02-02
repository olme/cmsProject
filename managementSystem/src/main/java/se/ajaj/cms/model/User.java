package se.ajaj.cms.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

	@ManyToOne
	private Team team;
	@OneToMany
	private Set<WorkItem> workItem;

	@Enumerated(EnumType.STRING)
	private UserStatus userStatus;

	public enum UserStatus
	{
		ACTIVE, ON_VACATION, SICK, INACTIVATED;
	}

	protected User()
	{
	}

	public User(String username, int userId, String firstName, String lastName, UserStatus userStatus)
	{
		this.username = username;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userStatus = userStatus;
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

	public UserStatus getUserStatus()
	{
		return userStatus;
	}

	public void setUserStatus(final UserStatus userStatus)
	{
		this.userStatus = userStatus;
	}

	public void updateValues(final User user)
	{
		this.username = user.username;
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.userStatus = user.userStatus;
	}

	@Override
	public int hashCode()
	{
		int result = 11;
		result += 37 * this.username.hashCode();
		result += 37 * this.userId;
		result += 37 * this.firstName.hashCode();
		result += 37 * this.lastName.hashCode();
		result += 37 * this.userStatus.hashCode();

		return result;
	}

	@Override
	public boolean equals(Object other)
	{
		if (this == other)
		{
			return true;
		}
		if (other instanceof User)
		{
			User otherUser = (User) other;
			return this.username.equals(otherUser.username) && this.firstName.equals(otherUser.firstName) &&
					this.lastName.equals(otherUser.lastName) && this.userId == otherUser.userId && this.userStatus.equals(otherUser.userStatus);
		}
		return false;
	}

	@Override
	public String toString()
	{
		return getId() + " " + this.username + " " + " " + this.firstName + " " +this.lastName + " " + this.userId + " " + getUserStatus();
	}
}
