package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import dao.DepartmentDao;
import entity.Department;
import util.HibernateUtil;

public class DepartmentImpl extends UnicastRemoteObject implements DepartmentDao{
	private EntityManager em;

	public DepartmentImpl() throws RemoteException{
		em = HibernateUtil.getInstance().getEntityManager();
	}
	
	@Override
	public boolean themDepartment(Department dp) throws RemoteException{
		OgmSession session = em.unwrap(OgmSession.class);
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			session.save(dp);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
}
