INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	('my-trusted-client', 'secret', 'trust,read,write',
	'password,authorization_code,refresh_token,implicit', null, null, 3600, null, null, 'true');
	

	

