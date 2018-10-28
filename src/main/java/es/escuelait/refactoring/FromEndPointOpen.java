package es.escuelait.refactoring;

public class FromEndPointOpen extends FromEndPoint{

	public FromEndPointOpen(double point, boolean closed) {
		super(point, closed);
	}

	@Override
	public boolean exclude(Interval that) {
		return excludeEndPointValue(that);
	}

	@Override
	public boolean include(double value) {
		return this.getPoint() < value;
	}
	
}
