package com.adventure.howto.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

public class DataAccess {
	
	private static ZooKeeper zoo;
	private static final CountDownLatch connectedSignal = new CountDownLatch(1);

	public static void Test() {
		try {
			connect("localhost");
			
			get_set();
			
			close();
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static void get_set() {
		  final CountDownLatch connectedSignal = new CountDownLatch(1);
		  String path = "/my_znode";
			
		  try {
              byte[] bn = zoo.getData(path, false, null);
              String data = new String(bn, "UTF-8");
              Integer value = Integer.valueOf(data);
              value++;
              
              System.out.println(value);
              
              zoo.setData(path, value.toString().getBytes(), zoo.exists(path,true).getVersion());
              
              connectedSignal.countDown();
	         } catch(Exception ex) {
              System.out.println(ex.getMessage());
           }
	}
	
	
	
	// Method to connect zookeeper ensemble.
	private static ZooKeeper connect(String host) throws IOException, InterruptedException {
		
	      zoo = new ZooKeeper(host, 5000, new Watcher() {
			
	         public void process(WatchedEvent we) {
	
	            if (we.getState() == KeeperState.SyncConnected) {
	               connectedSignal.countDown();
	            }
	         }
	      });
			
	      connectedSignal.await();
	      return zoo;
	}
	
	// Method to disconnect from zookeeper server
	private static void close() throws InterruptedException {
	      zoo.close();
	}
	
}
