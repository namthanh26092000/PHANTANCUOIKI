package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import entity.User;

public interface UserDao extends Remote{
	public boolean adddUser(User u) throws RemoteException;
	public Map<User, Integer> getStatistics() throws RemoteException;
	public List<User> listUsers(String keyword) throws RemoteException;
}
