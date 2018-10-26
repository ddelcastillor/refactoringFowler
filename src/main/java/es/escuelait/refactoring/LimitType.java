package es.escuelait.refactoring;

public abstract class LimitType {
	private double value;
	private boolean closed;

	public LimitType(double value, boolean closed) {
		this.value = value;
		this.closed = closed;
	}

	public double getValue() {
		return value;
	}

	public boolean isClosed() {
		return closed;
	}

	
	abstract public boolean exclude(Limit that);
	
	abstract public boolean include(Limit that);
	
	
	
	

}
