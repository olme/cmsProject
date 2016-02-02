package se.ajaj.cms.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Team extends AbstractEntity
{
	private String teamName;
	@OneToMany
	private Set<User> users;
	private int maxUsers;
	@OneToMany
	private Set<WorkItem> workItem;

	protected Team()
	{}

	public Team(String teamName)
	{
		this.teamName = teamName;
	}

	public String getTeamName()
	{
		return teamName;
	}

	public Set<User> getUsers()
	{
		return users;
	}

	public int getMaxUsers()
	{
		return maxUsers;
	}
}
