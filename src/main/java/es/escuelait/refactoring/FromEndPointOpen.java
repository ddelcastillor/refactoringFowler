package es.escuelait.refactoring;

public class FromEndPointOpen extends FromEndPoint{

	public FromEndPointOpen(double point, boolean close) {
		super(point, close);
	}

	@Override
	public boolean exclude(Interval that) {
		return excludeMinimum(that);
	}

	@Override
	public boolean include(double value) {
		return this.getPoint() < value;
	}
	
}
