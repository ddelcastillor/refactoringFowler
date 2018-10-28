package es.escuelait.refactoring;

public abstract class EndPoint {
	
	private double point;
	
	private boolean closed;

	public EndPoint(double point, boolean closed) {
		this.point = point;
		this.closed = closed;
	}
	
	public double getPoint() {
		return point;
	}

	public boolean isClosed() {
		return closed;
	}

	public void shift(double value) {
		this.point += value;
	}
	
	public abstract boolean exclude(Interval that);
	
	public abstract boolean include(double value);
	
	public abstract boolean excludeEndPointValue(Interval that);
	
}
