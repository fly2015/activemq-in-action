/*
 * ActiveMQBroker.java
 *
 * Copyright by CRIF AG
 * Zürich
 * All rights reserved.
 */
package requestresponse;

import org.apache.activemq.broker.BrokerService;

/**
 * 
 *
 * @author nhqhien
 * @version $Revision:  $
 */
public class ActiveMQBroker
{
    public ActiveMQBroker()
    {
        try
        {
            // This message broker is embedded
            BrokerService broker = new BrokerService();
            broker.setBrokerName("HNG-Broker-" + 1234);
            broker.setPersistent(false);
            broker.setUseJmx(false);
            broker.addConnector(Constant.messageBrokerUrl);
            broker.start();
            System.out.println("Broker are started !");
        }
        catch (Exception e)
        {
            System.out.println("Could not start Broker !");
        }
    }
    
    public static void main(String[] args)
    {
        new ActiveMQBroker();
    }

}



/*
 * Changes:
 * $Log: $
 */