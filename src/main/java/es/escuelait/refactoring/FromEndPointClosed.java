package es.escuelait.refactoring;

public class FromEndPointClosed extends FromEndPoint {

	public FromEndPointClosed(double point, boolean closed) {
		super(point, closed);
	}

	@Override
	public boolean exclude(Interval that) {
		return excludeEndPointValue(that);
	}

	@Override
	public boolean include(double value) {
		return this.getPoint() < value || this.getPoint() == value && this.isClosed();
	}
	
}
