package app;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import dao.DepartmentDao;
import dao.EmployeeDao;
import dao.ProposalDao;
import dao.impl.DepartmentImpl;
import dao.impl.EmployeeImpl;
import dao.impl.ProposalImpl;




public class AppServer {
	public static void main(String[] args) {
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}

		try {
			DepartmentDao departmentDao = new DepartmentImpl();
			ProposalDao proposalDao = new ProposalImpl();
			EmployeeDao employeeDao = new EmployeeImpl();
			
			LocateRegistry.createRegistry(1090);
			Naming.bind("rmi://LAPTOP-ICFLNL48/departmentDao", departmentDao);
			Naming.bind("rmi://LAPTOP-ICFLNL48/proposalDao", proposalDao);
			Naming.bind("rmi://LAPTOP-ICFLNL48/employeeDao", employeeDao);
			
			System.out.println("Server start");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
