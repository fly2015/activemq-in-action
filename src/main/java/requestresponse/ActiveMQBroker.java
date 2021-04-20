/*
 * ActiveMQBroker.java
 *
 * Copyright by CRIF AG
 * Zürich
 * All rights reserved.
 */
package requestresponse;

import java.util.concurrent.TimeUnit;

import org.apache.activemq.broker.BrokerService;

/**
 * 
 *
 * @author nhqhien
 * @version $Revision:  $
 */
public class ActiveMQBroker
{
    private BrokerService broker;

    public ActiveMQBroker()
    {

    }


    public void start() throws Exception
    {
        try
        {
            // This message broker is embedded
            broker = new BrokerService();
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


    public void stop() throws Exception
    {
        if (broker != null)
        {
            broker.stop();
            System.out.println("Broker are stopped !");
        }
    }
    
    public static void main(String[] args) throws Exception
    {
        ActiveMQBroker activeMQBroker = new ActiveMQBroker();
        while(true)
        {
            if(activeMQBroker.broker == null)
            {
                activeMQBroker.start();
            }
            TimeUnit.SECONDS.sleep(1000);
        }
        
       // broker.stop();
    }

}



/*
 * Changes:
 * $Log: $
 */