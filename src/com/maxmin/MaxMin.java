/*
 * 
 */
package com.maxmin;

/**
 * @author Taher
 *
 */
public class MaxMin {

	private static JobQueue jobQueue = new JobQueue();
	private static JobScheduler jobScheduler = new JobScheduler(jobQueue);
	
	
	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
	
		while(true)
		{
			if(jobQueue.getJobCount() == 0)
			{
				int jobCount = 0;
				while (jobCount < Constant.maximumJobs)
				{					
					jobQueue.Add(JobCreator.createJob());
					jobCount++;
				}
			}
			
			
			System.out.println("System Buffer " + jobQueue.systemBuffer);
		    System.out.println("User Buffer " + jobQueue.userBuffer);
		    
			jobScheduler.start();
			
			System.out.println();
		}
	}
	}
