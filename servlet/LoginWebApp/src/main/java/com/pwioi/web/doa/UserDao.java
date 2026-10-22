package com.pwioi.web.doa;

//data access layer dao interface
// focuses on crud operations
public interface UserDao {
	int insert(LoginModel user) throws SQlException;
	int update(LoginModel user)throws SQlException;
	int delete(LoginModel user)throws SQlException;
	LoginModel select(String username);

}
