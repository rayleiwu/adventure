package com.adventure.multithreading;

public class ThreadDemo extends Thread {
	   private Thread t;
	   private String threadName;
	   PrintDemo  PD;

	   public ThreadDemo( String name,  PrintDemo pd){
	       threadName = name;
	        PD = pd;
	   }
	   
	   public void run() {
		 synchronized(PD) {   // This is where you make sure the threads call this method one by one...otherwise they might call the method at the same time!
			PD.printCount();
		 
	     
	     System.out.println("Thread " +  threadName + " exiting.");
		 }
	   }

//	   public void start ()
//	   {
//	      System.out.println("Starting " +  threadName );
//	      if (t == null)
//	      {
//	         t = new Thread (this, threadName);
//	         t.start ();
//	      }
//	   }

}
