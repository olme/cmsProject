package se.ajaj.cms.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import se.ajaj.cms.model.Team;

public interface TeamRepository extends PagingAndSortingRepository<Team, Long>
{

}
