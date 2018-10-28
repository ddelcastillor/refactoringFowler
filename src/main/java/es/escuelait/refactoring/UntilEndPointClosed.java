package es.escuelait.refactoring;

public class UntilEndPointClosed extends UntilEndPoint {

	public UntilEndPointClosed(double point, boolean close) {
		super(point, close);
	}

	@Override
	public boolean exclude(Interval that) {		
		return this.getPoint() < that.getFromEndPointValue();
	}
	
	@Override
	public boolean include(double value) {
		return value < this.getPoint() || this.getPoint() == value && this.isClosed();
	}
	
}
