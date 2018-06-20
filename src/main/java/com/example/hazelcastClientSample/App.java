package com.example.hazelcastClientSample;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress("172.16.124.1:5701"); // your hazelcast node1 address
        //clientConfig.getNetworkConfig().addAddress(""); If you have two nodes , add the address of second node here
        clientConfig.getGroupConfig().setName("dev"); //username of cluster
        clientConfig.getGroupConfig().setPassword("dev-pass"); //password of cluster
        HazelcastInstance hazelcastInstance = HazelcastClient.newHazelcastClient(clientConfig); //create the connection
        IMap<String, String> imap = hazelcastInstance.getMap("test"); // get a handle to a map named test
        System.out.println(imap.get("abcd")); //printing value for a key named abcd in the map . If it is not there it will return null
        //More information about the HazelcastInstance can be found at http://docs.hazelcast.org/docs/3.8/javadoc/com/hazelcast/core/HazelcastInstance.html
    }
}
