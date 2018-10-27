package es.escuelait.refactoring;

public class Interval {
	
	private FromEndPoint fromEndPoint;
	
	private UntilEndPoint untilEndPoint;

	public Interval(double minimum, boolean minimumClosed, double maximum, boolean maximumClosed) {
		assert minimum < maximum || minimum == maximum && minimumClosed || !minimumClosed;
		this.fromEndPoint = new FromEndPoint(minimum,minimumClosed);
		this.untilEndPoint = new UntilEndPoint(maximum,maximumClosed);
	}

	public void shift(double value) {
		fromEndPoint.shift(value);
		untilEndPoint.shift(value);
	}

	public FromEndPoint getFromEndPoint() {
		return fromEndPoint;
	}

	public UntilEndPoint getUntilEndPoint() {
		return untilEndPoint;
	}

	public double length() {
		return this.untilEndPoint.getPoint() - this.fromEndPoint.getPoint();
	}
	
	public boolean includes(double value) {
		return fromEndPoint.include(value) && 
				untilEndPoint.include(value);
	}
	
	public boolean includes(Interval that) {
		if (fromEndPoint.exclude(that)) {
				return false;
			}
		if (untilEndPoint.exclude(that)) {
				return false;
		}
		return true;
	}	
}
