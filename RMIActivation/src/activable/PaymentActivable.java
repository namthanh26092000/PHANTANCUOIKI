package activable;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PaymentActivable extends Remote {
    public double calculatePayment(double principal, double annualRate, int terms)
                    throws RemoteException;
}