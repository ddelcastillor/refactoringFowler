package es.escuelait.refactoring;

public class Interval {

	private EndPoint fromEndPoint, untilEndPoint;

	public Interval(double minimum, boolean minimumClosed, double maximum, boolean maximumClosed) {
		assert minimum < maximum || minimum == maximum && minimumClosed || !minimumClosed;

		this.fromEndPoint = FromEndPoint.create(minimum, minimumClosed);
		this.untilEndPoint = UntilEndPoint.create(maximum, maximumClosed);
	}

	public void shift(double value) {
		fromEndPoint.shift(value);
		untilEndPoint.shift(value);
	}

	public double length() {
		return this.untilEndPoint.getPoint() - this.fromEndPoint.getPoint();
	}

	public boolean includes(double value) {
		return fromEndPoint.include(value) && untilEndPoint.include(value);
	}

	public boolean includes(Interval that) {
		return !fromEndPoint.exclude(that) && !untilEndPoint.exclude(that);
	}
	
	public boolean isDifferenteFromEndPointClosed(boolean close) {
		return fromEndPoint.isClosed() && !close;
	}
	
	public boolean isDifferenteUntilEndPointClosed(boolean close) {
		return untilEndPoint.isClosed() && !close;
	}
	
	public boolean isEqualFromEndPointValue(double point) {
		return fromEndPoint.getPoint() == point;
	}
	
	public boolean isEqualUntilEndPointValue(double point) {
		return untilEndPoint.getPoint() == point;
	}

	public double getFromEndPointValue() {
		return fromEndPoint.getPoint();
	}
	
	public double getUntilEndPointValue() {
		return untilEndPoint.getPoint();
	}	
}
