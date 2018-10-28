package es.escuelait.refactoring;

public class Interval {
	
	private EndPoint fromEndPoint,untilEndPoint;
	
	public Interval(double minimum, boolean minimumClosed, double maximum, boolean maximumClosed) {
		assert minimum < maximum || minimum == maximum && minimumClosed || !minimumClosed;
		
		this.fromEndPoint =  FromEndPoint.create(minimum,minimumClosed);
		this.untilEndPoint = UntilEndPoint.create(maximum,maximumClosed);
	}

	public void shift(double value) {
		fromEndPoint.shift(value);
		untilEndPoint.shift(value);
	}

	public double getFromEndPointValue() {
		return fromEndPoint.getPoint();
	}

	public double getUntilEndPointValue() {
		return untilEndPoint.getPoint();
	}
	
	public boolean isFromEndPointClosed() {
		return fromEndPoint.isClosed();
	}

	public boolean isUntilEndPointClosed() {
		return untilEndPoint.isClosed();
	}

	public double length() {
		return this.untilEndPoint.getPoint() - this.fromEndPoint.getPoint();
	}
	
	public boolean includes(double value) {
		return fromEndPoint.include(value) && 
				untilEndPoint.include(value);
	}
	
	public boolean includes(Interval that) {
		return !fromEndPoint.exclude(that) && !untilEndPoint.exclude(that);
	}
	
}
