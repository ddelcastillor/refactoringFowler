package es.escuelait.refactoring;

public class UntilEndPointClosed extends UntilEndPoint {

	public UntilEndPointClosed(double point, boolean closed) {
		super(point, closed);
	}

	@Override
	public boolean exclude(Interval that) {		
		return this.getPoint() < that.getUntilEndPointValue();
	}
	
	@Override
	public boolean include(double value) {
		return value < this.getPoint() || this.getPoint() == value && this.isClosed();
	}
	
}
