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

	public double length() {
		return this.untilEndPoint.getPoint() - this.fromEndPoint.getPoint();
	}
	
	public boolean includes(double value) {
		return (this.fromEndPoint.getPoint() < value || this.fromEndPoint.getPoint() == value && this.fromEndPoint.isClosed()) && 
			(value < this.untilEndPoint.getPoint() || this.untilEndPoint.getPoint() == value && this.untilEndPoint.isClosed());
	}
	
	public boolean includes(Interval that) {
		if (this.fromEndPoint.getPoint() > that.fromEndPoint.getPoint() || this.fromEndPoint.getPoint() == that.fromEndPoint.getPoint() && !this.fromEndPoint.isClosed() && that.fromEndPoint.isClosed()) {
				return false;
			}
		if (this.untilEndPoint.getPoint() < that.untilEndPoint.getPoint() || this.untilEndPoint.getPoint() == that.untilEndPoint.getPoint() && !this.untilEndPoint.isClosed() && that.untilEndPoint.isClosed()) {
				return false;
		}
		return true;
	}

}
