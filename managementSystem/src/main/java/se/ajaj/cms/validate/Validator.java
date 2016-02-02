package se.ajaj.cms.validate;

import se.ajaj.cms.model.User;

public final class Validator
{
	public static boolean isValid(User user)
	{
		return (!userNameIsShorterThan10Chars(user.getUsername()));
	}

	private static boolean userNameIsShorterThan10Chars(String username)
	{
		return username.trim().length() < 10;
	}
}
