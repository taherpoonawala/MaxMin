package com.maxmin;

import java.util.LinkedList;

public class JobScheduler {
	
	private JobQueue jobQueue;
	
	public JobScheduler(JobQueue jobQueue)
	{
		this.jobQueue = jobQueue;
	}
	
	public void start()
	{
		int burstTime = jobQueue.systemBTCount + jobQueue.userBTCount;
		
		long allottedSystemBurstTime = (long) (burstTime * 0.6);
		long allottedUserBurstTime = burstTime - allottedSystemBurstTime;
		
		schduleJobsOnBuffer(jobQueue.systemBuffer,allottedSystemBurstTime);
		schduleJobsOnBuffer(jobQueue.userBuffer, allottedUserBurstTime);
		
		scheduleRemainingJobs(jobQueue.systemBuffer);
		scheduleRemainingJobs(jobQueue.userBuffer);
		
	}
	
	
	
	public void schduleJobsOnBuffer(LinkedList<Job> buffer,long  allottedBurstTime)
	{
		double consumedSystemBurstTime = 0;

		int index = buffer.size() - 1;
		
		while(consumedSystemBurstTime < allottedBurstTime
				&& index >= 0)
		{
			Job job = null;
			
			//Core scheduling business logic
			if(index >= 3)
			{
				job = buffer.get(2);
			}
			else
			{
				job = buffer.get(index);
			}
			
			schedule(job);	
			consumedSystemBurstTime += job.getCpuTime();
			index--;
		}
	}
	
	public void scheduleRemainingJobs(LinkedList<Job> buffer )
	{
		while(buffer.size()>0)
		{
			Job job = null;
			job = buffer.getLast();
			schedule(job);			
		}		
	}
	
	private void schedule(Job job)
	{
		System.out.println("Scheduled: " + job);
		jobQueue.remove(job);
	}
}