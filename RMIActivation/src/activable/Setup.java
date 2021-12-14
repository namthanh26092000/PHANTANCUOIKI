package activable; 

import java.rmi.MarshalledObject;
import java.rmi.Naming;
import java.rmi.activation.Activatable;
import java.rmi.activation.ActivationDesc;
import java.rmi.activation.ActivationGroup;
import java.rmi.activation.ActivationGroupDesc;
import java.rmi.activation.ActivationGroupID;
import java.util.Properties;

public class Setup {

	public static void main(String[] args) throws Exception {

		System.setSecurityManager(new SecurityManager());

		Properties props = new Properties(); 
		props.put("java.security.policy", "myrmi/myrmi.policy");

		ActivationGroupDesc.CommandEnvironment ace = null; 
		ActivationGroupDesc exampleGroup = new ActivationGroupDesc(props, ace);

		ActivationGroupID agi = 
				ActivationGroup.getSystem().registerGroup(exampleGroup);

		String location = "file:myrmi/";

		MarshalledObject data = null;

		ActivationDesc desc = new ActivationDesc 
				(agi, "activable.PaymentActivableImpl",location, data);

		PaymentActivable mort = (PaymentActivable)Activatable.register(desc);
		System.out.println("Got the stub for PaymentActivableImpl");

		Naming.rebind("Mortgage", mort);
		System.out.println("Exported from registration");

		System.exit(0);
	}

}