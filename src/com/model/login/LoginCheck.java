package com.model.login;
import com.model.beans.*;

public class LoginCheck {

	
		public boolean checkLogin(User usr) {
			if(usr.getUser().equals("admin") && usr.getPassword().equals("admin") ) {
				return true;
			}
			else return false;
		}

	
}
