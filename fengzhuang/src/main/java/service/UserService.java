package service;


import entity.User;

public interface UserService extends basicService<User>{
	public  User login(User u);
}
