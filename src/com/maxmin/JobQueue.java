package com.maxmin;

import java.util.LinkedList;

public class JobQueue {
	LinkedList<Job> systemBuffer = new LinkedList<Job>();
	LinkedList<Job> userBuffer = new LinkedList<Job>();
	int systemBTCount = 0, userBTCount = 0;

	public int getJobCount() {
		return systemBuffer.size() + userBuffer.size();
	}

	public void Add(Job jb) {
		switch (jb.getCategory()) {
		case JobCategorySystem:
			Insert(systemBuffer, jb);
			systemBTCount += jb.getCpuTime();
			break;
		case JobCategoryUser:
			Insert(userBuffer, jb);
			userBTCount += jb.getCpuTime();
			break;
		}
	}

	private void Insert(LinkedList<Job> buffer, Job jb) {
		int index = 0;
		int finalCount = getJobCount();
		boolean dead = false;

		if (finalCount < Constant.maximumJobs) {
			while (index < buffer.size()) {
				if (buffer.get(index).getCpuTime() < jb.getCpuTime()) {
					buffer.add(index, jb);
					dead = true;
					break;
				}
				index++;
			}

			if (dead == false) {
				buffer.addLast(jb);
			}
		}
	}

	public void remove(Job jb) {
		switch (jb.getCategory()) {
		case JobCategorySystem:
			systemBTCount -= jb.getCpuTime();
			systemBuffer.remove(jb);
			break;
		case JobCategoryUser:
			userBTCount -= jb.getCpuTime();
			userBuffer.remove(jb);
			break;
		}
	}

	public void Update(Job jb, int consumedTime) {
		int cpuTime = jb.getCpuTime();

		switch (jb.getCategory()) {
		case JobCategorySystem:
			systemBTCount -= consumedTime;
			cpuTime -= consumedTime;
			break;
		case JobCategoryUser:
			userBTCount -= consumedTime;
			cpuTime -= consumedTime;
			break;
		}
		jb.setCpuTime(cpuTime);
	}

//	public static LinkedList<Job> getJobList() {
//		return systemBuffer;
//	}
}
