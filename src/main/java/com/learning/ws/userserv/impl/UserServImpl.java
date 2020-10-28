package com.learning.ws.userserv.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.learning.ws.exception.CustomServiceException;
import com.learning.ws.model.UpdateRequest;
import com.learning.ws.model.UserRecord;
import com.learning.ws.model.Request.UserRecordRequest;
import com.learning.ws.shared.Utils;
import com.learning.ws.userserv.UserService;


@Service
public class UserServImpl implements UserService{

	Map<String,UserRecord> userMap;
	Utils utl;
	public UserServImpl(){}
	
	//Autowired annotation is used so that 
	// it can be instantiated dynamically.
	//Constructor Based depandcy Injection.
	@Autowired
	public UserServImpl(Utils utils) {
		this.utl=utils;
	}
	
	@Override
	public UserRecord CreateUser(UserRecordRequest ur) {
		UserRecord resp = new UserRecord();
		resp.setEmail( ur.getEmail());
		resp.setName(ur.getFullName());
		String id = utl.generateUserId();
		ur.setId(id);
		resp.setId(id);
		if(userMap == null) 
			userMap = new HashMap<String,UserRecord>();
		userMap.put(id, resp);
		return resp;
	}
	
	@Override
	public UserRecord UpdateUser(String userId, UpdateRequest updtRequest) {
		UserRecord ur = null;
		if (userMap != null && userMap.containsKey(userId)) {
			ur = userMap.get(userId);
			if (updtRequest.getEmail() != null && updtRequest.getEmail().length() > 0)
				ur.setEmail(updtRequest.getEmail());
			if (updtRequest.getFullName() != null && updtRequest.getFullName().length() > 0)
				ur.setName(updtRequest.getFullName());
			userMap.put(userId, ur);

		}
		return ur;
	}

	@Override
	public UserRecord getSpecificUser(String userId) {
		UserRecord ur = null;
		if (userMap != null && userMap.containsKey(userId)) {
			ur = userMap.get(userId);
		}
		return ur;
	}

	@Override
	public Collection<UserRecord> getAllUsers() {
		//Uncomment below four lines to test Exception
//		int a[] = new int[] {1,2,3};
//		a[-1] = 0;
//		String str = null;
//		if(str.length()>0) {
//			System.out.println("NULL");
//		}
//		
		//if(true)
		//	throw new CustomServiceException("Its a Custom Service Exception");
		Collection<UserRecord> cur= null;
		if(userMap != null && !userMap.isEmpty()) {
			cur = userMap.values();
		}
		return cur;

	}


	@Override
	public UserRecord DeleteSpecificUser(String userId) {
		UserRecord ur = null;
		if (userMap != null && userMap.containsKey(userId)) {
			ur = userMap.get(userId);
			userMap.remove(userId);

		}
		return ur;
	}

}
