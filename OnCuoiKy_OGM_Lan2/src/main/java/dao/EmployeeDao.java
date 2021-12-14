package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Employee;
import entity.Proposal;

public interface EmployeeDao extends Remote{
	public boolean themEmployee(Employee employee)  throws RemoteException;
	
	//3) Tìm tất cả các nhân viên có nhiều đề xuất ý tưởng nhất.
	//+ getGoodEmployees () : List< Employee>
	public List<Employee> getGoodEmployees()  throws RemoteException;
}
