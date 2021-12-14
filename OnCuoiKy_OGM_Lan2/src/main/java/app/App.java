package app;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import dao.DepartmentDao;
import dao.EmployeeDao;
import dao.ProposalDao;
import dao.impl.DepartmentImpl;
import dao.impl.EmployeeImpl;
import dao.impl.ProposalImpl;
import entity.Department;
import entity.Employee;
import entity.Gender;
import entity.Proposal;

//import dao.EmployeeDao;
//import dao.impl.EmployeeImpl;

public class App {
	public static void main(String[] args) throws RemoteException {
		
		DepartmentDao departmentDao = new DepartmentImpl();
		ProposalDao proposalDao = new ProposalImpl();
		EmployeeDao employeeDao = new EmployeeImpl();
		
		Department department = new Department("2", "haha2", "haha2");

		Set<String> dsDienthoai = new TreeSet<String>();
		//dsDienthoai.add("1945334341");
		dsDienthoai.add("1914533434");	
		Employee employee = new Employee("Thai2", new Date(2000-1900, 12, 24), "thai2@gmail.com", "Thai2", "Le2", dsDienthoai, Gender.MALE);
		employee.setDepartment(new Department("1"));
		
//		departmentDao.themDepartment(department);
//		System.out.println(departmentDao.themDepartment(department));
//		
//		Proposal proposal = new Proposal("2", new Date(2021, 12, 24), "Thái","Lê");
//		proposal.setEmployee(employee);
//		
//		proposalDao.themProposal(proposal);
//		System.out.println(proposalDao.themProposal(proposal));
//		
//			
//		employeeDao.themEmployee(employee);
//		System.out.println(employeeDao.themEmployee(employee));		
		
		//2) Tìm danh sách các đề xuất ý tưởng của một nhân viên nào đó khi biết email của nhân viên.
		//+ getProposals (email: String) : List< Proposal>
//		proposalDao.getProposals("thai@gmail.com").forEach(p -> {
//			System.out.println(p);
//		});		
		
		
		//3) Tìm tất cả các nhân viên có nhiều đề xuất ý tưởng nhất.
		//+ getGoodEmployees () : List< Employee>
		employeeDao.getGoodEmployees().forEach(p -> {
			System.out.println(p);
		});
		
		
		
	}
}
