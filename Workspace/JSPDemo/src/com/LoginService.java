package com;

public class LoginService {

	//Business Logic 
	public boolean checkUser(Login ll) {
		LoginDao ld = new LoginDao();
		return ld.checkUserDetails(ll);
	}
}
