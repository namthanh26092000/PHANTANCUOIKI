package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Department;
import entity.Proposal;

public interface ProposalDao extends Remote{
	public boolean themProposal(Proposal dp) throws RemoteException;
	
	
	//2) Tìm danh sách các đề xuất ý tưởng của một nhân viên nào đó khi biết email của nhân viên.
	//+ getProposals (email: String) : List< Proposal>
	public List<Proposal> getProposals(String email) throws RemoteException;
}
