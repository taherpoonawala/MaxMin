package com.maxmin;

public class Job {
	
	private Integer jobId; // job number
	private JobCategory category; // system or user job
	private int cpuTime; // burst time
	public int arrivalTime; // starting time of the jobs
	private int finish; // finished time of proposed algorithm
	private int tradFinish; // finished time of traditional algorithm

	public Job(Integer jobId, JobCategory jobCategory, int burstTime) {
		this.jobId = jobId;
		category = jobCategory;
		cpuTime = burstTime;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public JobCategory getCategory() {
		return category;
	}

	public void setCategory(JobCategory category) {
		this.category = category;
	}

	public int getCpuTime() {
		return cpuTime;
	}

	public void setCpuTime(int cpuTime) {
		this.cpuTime = cpuTime;
	}

	public int getArrivaltime() {
		return 0;
	}

	public int getFinish() {
		return finish;
	}

	public void setFinish(int finish) {
		this.finish = finish;
	}

	public int getTradFinish() {
		return tradFinish;
	}

	public void setTradFinish(int tradfinish) {
		this.tradFinish = tradfinish;
	}
	
	@Override
	public String toString() {

		return "JobId: " + getJobId() + " | JobCategory: " + getCategory() + " | CPUBurstTime: " + getCpuTime();
	}
}
