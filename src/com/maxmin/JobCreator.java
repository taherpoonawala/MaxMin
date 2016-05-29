package com.maxmin;

import java.util.Random;

public class JobCreator {
	
	private static int jobId = 0;
	
	public static Job createJob()
	{
		Random ran = new Random();
		int burstTime = ran.nextInt(Constant.maxBurstTime + 1 - Constant.minBurstTime) + Constant.minBurstTime;
		int temp = ran.nextInt(20 - 10) + 10;
		JobCategory jobCat;
		
		if(temp % 2 == 0)
			jobCat = JobCategory.JobCategorySystem;
		else
			jobCat = JobCategory.JobCategoryUser;
		
		return new Job(jobId++, jobCat, burstTime);
	}
}
