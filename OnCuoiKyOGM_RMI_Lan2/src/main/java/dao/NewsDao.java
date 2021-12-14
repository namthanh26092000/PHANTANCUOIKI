package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.News;

public interface NewsDao extends Remote{
	public List<News>  getNewsByTagsOrCategoriesName(String value) throws RemoteException;
	
	public List<News> listNewsByUserEmail(String email) throws RemoteException;
	
}
