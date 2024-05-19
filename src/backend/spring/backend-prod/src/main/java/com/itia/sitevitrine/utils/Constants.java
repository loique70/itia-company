package com.itia.sitevitrine.utils;

public class Constants {
	public static final short STATE_ACTIVATED = 0, STATE_DELETED = 2, STATE_ARCHIVE = 1, STATE_DEACTIVATED = 3;

	// Codes d'erreurs
	public static final String USER_NON_AUTHENTICATED = "401", CONNECTION_TIMEOUT = "402", ERROR_PAGE_NOT_FOUND = "404",
			NEWS_NOT_FOUND_CODE = "405", NEWS_ALREADY_FEATURED_CODE = "406", NEWS_ALREADY_NOT_FEATURED_CODE = "407",
			SERVER_ERROR = "500", SERVER_DENY_RESPONSE = "504", ITEM_NOT_FOUND = "403", ITEM_ALREADY_EXIST = "501",
			ITEM_ALREADY_DELETED = "502", ITEM_ALREADY_DEACTIVATED = "503", ITEM_IS_REQUIRED = "504",
			INVALID_INPUT = "506", FILE_NOT_READ = "507", FILE_NOT_DOWNLOAD = "508",
			MAIL_NOT_SEND = "509", NOT_ACTIVE_ITEM = "510", RUN_TIME = "511", NULL_POINTER = "512";

	// rôles par défaut
	public static final String USER = "USER", ADMIN = "ADMIN", JOBER = "JOBER", ENTERPRISE = "ENTERPRISE";
	public static final String N_A_CREATE = "CREATE", N_A_UPDATE = "UPDATE", N_A_CRON = "CRON";

	// message d'erreurs
	public static final String USER_NOT_FOUND = "User not found",
			CONTACT_NOT_FOUND = "Contact not found",
			PERMISSION_NOT_FOUND = "Permission not found",
			ROLE_NOT_FOUND = "Role not found",
			EMAIL_ALREADY_USED_CODE = "612",
			EMAIL_ALREADY_USED = "Email already used",
			USERNAME_ALREADY_USED_CODE = "613",
			USERNAME_AND_EMAIL_ARE_ALREADY_USED = "Username and email are already used",
			USERNAME_AND_EMAIL_ARE_ALREADY_USED_CODE = "614",
			USER_ALREADY_DELETED_CODE = "615",
			USER_ALREADY_DEACTIVATED_CODE = "616",
			USER_NOT_FOUND_CODE = "617",
			OLD_PASSWORD_NOT_MATCH_CODE = "618",
			USERNAME_ALREADY_USED = "Username already used",
			SETTING_NOT_FOUND = "Setting not found",
			USER_AND_ROLE_NOT_FOUND = "User and role not found",
			ROLE_AND_PERMISSION_NOT_FOUND = "role and permission not found",
			ROLE_PERMISSION_NOT_FOUND = "Role-permission not found",
			USER_ROLE_NOT_FOUND = "User-role not found",

			USERNAME_ALREADY_EXIST = "Username already exist",
			EMAIL_ALREADY_EXIST = "Email already exist",
			USERNAME_AND_EMAIL_ALREADY_EXIST = "Username and email already exist",
			EMAIL_IS_NOT_CORRECT = "Email is not correct",
			ROLE_NAME_ALREADY_EXIST = "Role name already exist",
			PERMISSION_NAME_ALREADY_EXIST = "Permission name already exist",

			USER_ALREADY_DELETED = "User already deleted",
			PERMISSION_ALREADY_DELETED = "Permission already deleted",
			ROLE_ALREADY_DELETED = "Role already deleted",
			SETTING_ALREADY_DELETED = "Setting already deleted",

			USER_ALREADY_DEACTIVATED = "User already deactivated",
			SPECIALIST_ALREADY_DEACTIVATED = "Specialist already deactivated",
			ROLE_ALREADY_DEACTIVATED = "Role already deactivated",
			PERMISSION_ALREADY_DEACTIVATED = "Permission already deactivated",

			TIME_NOT_FREE = "This slot time is not free",
			INVALID_INPUT_STRING = "Bad request",
			COULD_NOT_READ_FILE = "Could not read file",
			COULD_NOT_DELETE_FILE = "Could not process the deletion",
			COULD_NOT_DOWNLOAD_FILE = "Could not download file",
			COULD_NOT_SEND_MAIL = "Could not download file",

			NOT_ACTIVE_USERS = "There is not active user",
			SETTING_MUST_NOT_BE_NULL = "The setting must not be null or empty",
			SETTING_IS_NULL = "The setting is null",
			OLD_PASSWORD_NOT_MATCH = "Old password do not match",

			ROLE_PERMISSION_ALREADY_EXIST = "role-permission already exist",
			USER_ROLE_ALREADY_EXIST = "User-role already exist",

			RUN_TIME_EXCEPTION = "Malformed URL has occurred",

			USER_IS_NULL = "Value of user is null",
			ROLE_IS_NULL = "Value of role is null",
			PERMISSION_IS_NULL = "Value of permission is null",

			// client
			JOBER_NOT_FOUND = "Client not found",
			JOBER_NOT_FOUND_CODE = "619",
			UNIQUE_USER_JOBER = "A user is already associated with this client",
			UNIQUE_USER_JOBER_CODE = "620",

			// Project;
			PROJECT_NOT_FOUND = "Project not found",
			PROJECT_NOT_FOUND_CODE = "621",

			// engineer
			ENTERPRISE_NOT_FOUND = "Engineer not found",
			ENTERPRISE_NOT_FOUND_CODE = "622",
			UNIQUE_USER_ENTERPRISE = "A user is already associated with this engineer",
			UNIQUE_USER_ENTERPRISE_CODE = "623",

			// engineer project;
			ENTERPRISE_AND_PROJECT_NOT_FOUND = "Engineer and Project not found",
			ENTERPRISE_AND_PROJECT_NOT_FOUND_CODE = "624",
			PROJECT_PARTICIPATION_NOT_FOUND = "Project participation not found",
			PROJECT_PARTICIPATION_NOT_FOUND_CODE = "625",

			// projet step
			PROJECT_STEP_NOT_FOUND = "Project Step not found",
			PROJECT_STEP_NOT_FOUND_CODE = "626",

			// engineer project projectStep
			ENTERPRISE_AND_PROJECT_AND_PROJECT_STEP_NOT_FOUND = "Engineer and Project not found",
			ENTERPRISE_AND_PROJECT_AND_PROJECT_STEP_NOT_FOUND_CODE = "627",
			PROJECT_PARTICIPATION_STEP_NOT_FOUND = "Project participation step not found",
			PROJECT_PARTICIPATION_STEP_NOT_FOUND_CODE = "628",

			JOBER_REQUEST_ALREADY_APPROUVED_CODE = "629",
			JOBER_REQUEST_ALREADY_APPROUVED = "Client request already approuved",

			JOBER_REQUEST_ALREADY_REJECTED_CODE = "630",
			JOBER_REQUEST_ALREADY_REJECTED = "Client request already rejected",

			ENTERPRISE_REQUEST_ALREADY_APPROUVED_CODE = "631",
			ENTERPRISE_REQUEST_ALREADY_APPROUVED = "Engineer request already approuved",

			ENTERPRISE_REQUEST_ALREADY_REJECTED_CODE = "632",
			ENTERPRISE_REQUEST_ALREADY_REJECTED = "Engineer request already rejected",

			PROJECT_PARTICIPATION_ALREADY_EXIST = "Project participation already exist",
			PROJECT_PARTICIPATION_ALREADY_EXIST_CODE = "633",

			PROJECT_PARTICIPATION_STEP_ALREADY_EXIST = "Project participation step already exist",
			PROJECT_PARTICIPATION_STEP_ALREADY_EXIST_CODE = "634";

}
