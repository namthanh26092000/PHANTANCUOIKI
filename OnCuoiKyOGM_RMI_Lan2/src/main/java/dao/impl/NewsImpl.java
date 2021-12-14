package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;

import dao.NewsDao;
import entity.News;
import util.HibernateUtil;

public class NewsImpl extends UnicastRemoteObject implements NewsDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7324737122461515489L;
	
	private EntityManager em;
	public NewsImpl() throws RemoteException {
		super();
		em = HibernateUtil.getInstance().getEntityManager();
	}
	
//	db.news.createIndex({tags:"text", newsCategories:"text"})
	@Override
	public List<News> getNewsByTagsOrCategoriesName(String value) throws RemoteException {
		OgmSession session = em.unwrap(OgmSession.class);
		List<News> listnews = new ArrayList<News>();
		Transaction tr = session.beginTransaction();

		try {
			String query = "db.news.find({'$text': {'$search': \""+value+"\"}})";
			List<?> list = session.createNativeQuery(query).getResultList();
			for(Object obj : list) {
				Object[] o = (Object[]) obj;
				Long newId = (long) o[0];
				News news = session.find(News.class, newId);
//				System.out.println(news);
				listnews.add(news);
			}			
			tr.commit();		
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return listnews;
	}
//	 db.User.aggregate([{$match:{$text:{$search:"thai4@gmail.com"}}},{$lookup:{from:'news',localField:'listOfComments.nw_id',foreignField:'_id',as:'rs'}},{$project:{rs:1,_id:0}},{$unwind:'$rs'},{$replaceRoot:{'newRoot':'$rs'}}])
	@Override
	public List<News> listNewsByUserEmail(String email) throws RemoteException {
		OgmSession session = em.unwrap(OgmSession.class);
		List<News> listnews = new ArrayList<News>();
		Transaction tr = session.beginTransaction();

		try {
			String query = "db.User.aggregate([{'$match':{'$text':{'$search':\""+email+"\"}}},{'$lookup':{from:'news',localField:'listOfComments.nw_id',foreignField:'_id',as:'rs'}},{'$project':{rs:1,_id:0}},{'$unwind':'$rs'},{'$replaceRoot':{'newRoot':'$rs'}}])";
			List<?> list = session.createNativeQuery(query).getResultList();
			for(Object obj : list) {
				Object[] o = (Object[]) obj;
				Long newId = (Long) o[0];
				News news = session.find(News.class, newId);
//				System.out.println(news);
				listnews.add(news);
			}			
			tr.commit();		
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return listnews;
	}

}
