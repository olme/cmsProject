package se.ajaj.cms.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
public class WorkItem extends AbstractEntity
{
	private String workItem;
	private String issue;
	@Enumerated(EnumType.STRING)
	private WorkItemStatus workItemStatus;
	@ManyToOne
	private Team team;
	@ManyToOne
	private User user;

	public enum WorkItemStatus
	{
		DONE, STARTED, UNSTARTED
	}

	protected WorkItem()
	{
	}

	public WorkItem(String workItem)
	{
		this.workItem = workItem;
		this.workItemStatus = WorkItemStatus.UNSTARTED;
	}

	public String getWorkItem()
	{
		return workItem;
	}

	public String getIssue()
	{
		return issue;
	}

	public WorkItemStatus getWorkItemStatus()
	{
		return workItemStatus;
	}

	public void setIssue(String issue)
	{
		this.issue = issue;
	}

	public void setWorkItemStatus(WorkItemStatus workItemStatus)
	{
		this.workItemStatus = workItemStatus;
	}

}
