package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;

import dao.UserDao;
import entity.News;
import entity.User;
import util.HibernateUtil;

public class UserImpl extends UnicastRemoteObject implements UserDao{

	private EntityManager em;
	public UserImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		em = HibernateUtil.getInstance().getEntityManager();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -5275289061231081308L;

	@Override
	public boolean adddUser(User u) throws RemoteException {
		OgmSession session = em.unwrap(OgmSession.class);
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			session.save(u);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public Map<User, Integer> getStatistics() throws RemoteException {
		Map<User, Integer> map = new HashMap<User, Integer>();
//		db.User.aggregate([{$project:{_id:1, listOfComments:1, num:{$size:{"$ifNull":["$listOfComments",[]]}}}},{$match:{num:{$gte:3}}}])
		OgmSession session = em.unwrap(OgmSession.class);
		Transaction tr = session.beginTransaction();

		try {
			String query = "db.User.aggregate([{'$project':{_id:1, listOfComments:1, num:{'$size':{\"$ifNull\":[\"$listOfComments\",[]]}}}},{'$match':{num:{$gte:0}}}])";
			List<?> list = em.createNativeQuery(query).getResultList();
			for(Object obj : list) {
				Object[] o = (Object[]) obj;
				Long newId = (Long) o[0];
				Integer count = (Integer) o[2];
				User user = em.find(User.class, newId);
//				
				map.put(user, count);
			}			
			tr.commit();		
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return map;
	}

	@Override
	public List<User> listUsers(String keyword) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
