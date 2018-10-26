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

	
	abstract public boolean excludeMinimum(Limit that);
	
	abstract public boolean includeMinimum(Limit that);
	
	abstract public boolean excludeMaximum(Limit that);
	
	abstract public boolean includeMaximum(Limit that);
	
	
	
	

}
