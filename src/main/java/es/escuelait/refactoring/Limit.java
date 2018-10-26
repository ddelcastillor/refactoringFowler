package es.escuelait.refactoring;

public abstract class Limit {
	private double value;
	private boolean closed;

	public Limit(double value, boolean closed) {
		this.value = value;
		this.closed = closed;
	}

	public double getValue() {
		return value;
	}

	public boolean isClosed() {
		return closed;
	}

	public void increase(double value) {
		this.value += value;
	}
	
	abstract public boolean exclude(Limit that);
	
	abstract public boolean include(Limit that);
	
	
	
	

}
