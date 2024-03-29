package se.ajaj.cms.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity
{
	@Id
	@GeneratedValue
	private Long id;

	public Long getId()
	{
		return id;
	}
}
