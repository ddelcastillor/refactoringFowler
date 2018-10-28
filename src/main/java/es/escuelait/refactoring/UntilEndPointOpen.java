package es.escuelait.refactoring;

public class UntilEndPointOpen extends UntilEndPoint{

	public UntilEndPointOpen(double point, boolean closed) {
		super(point, closed);
	}
	
	@Override
	public boolean include(double value) {
		return value < this.getPoint();
	}
	
	@Override
	public boolean exclude(Interval that) {
		return this.excludeEndPointValue(that);
	}
	
}
