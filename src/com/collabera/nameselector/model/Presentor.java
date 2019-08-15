package com.collabera.nameselector.model;

public class Presentor {
	private static int idCounter = 1;
	private int id;
	private String name;
	private int timesCalled;
	private boolean absent;

	public Presentor() {
		this.id = -1;
		this.name = "";
		this.timesCalled = -1;
		this.absent = true;
	}

	public Presentor(String name, int timesCalled, boolean absent) {
		super();
		this.id = idCounter++;
		this.name = name;
		this.timesCalled = timesCalled;
		this.absent = absent;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTimesCalled() {
		return timesCalled;
	}

	public void setTimesCalled(int timesCalled) {
		this.timesCalled = timesCalled;
	}

	public boolean isAbsent() {
		return absent;
	}

	public void setAbsent(boolean absent) {
		this.absent = absent;
	}

	@Override
	public String toString() {
		return "Presentor [id=" + id + ", name=" + name + ", timesCalled=" + timesCalled + ", absent=" + absent + "]";
	}

}
