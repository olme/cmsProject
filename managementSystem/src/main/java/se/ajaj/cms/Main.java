package se.ajaj.cms;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import se.ajaj.cms.exception.CmsException;
import se.ajaj.cms.model.User;
import se.ajaj.cms.model.User.UserStatus;
import se.ajaj.cms.service.CmsService;

public final class Main
{
	public static void main(String[] args) throws CmsException
	{
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext())
		{
			context.scan("se.ajaj.cms");
			context.refresh();

			CmsService cmsService = context.getBean(CmsService.class);

//			User user = new User("Kattmamman007", 1001, "Jane", "Doe", UserStatus.INACTIVATED);
//
//			cmsService.saveUser(user);
		}

	}
}
