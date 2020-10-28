package com.learning.ws.userserv;

import java.util.Collection;
import com.learning.ws.model.UpdateRequest;
import com.learning.ws.model.UserRecord;
import com.learning.ws.model.Request.UserRecordRequest;

public interface UserService {
	UserRecord CreateUser(UserRecordRequest ur);
	UserRecord UpdateUser(String userId,UpdateRequest updtRequest);
	UserRecord getSpecificUser(String userId);
	Collection<UserRecord> getAllUsers();
	UserRecord DeleteSpecificUser(String userId);
}
