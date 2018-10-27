package es.escuelait.refactoring;

public class FromEndPoint extends EndPoint{

	public FromEndPoint(double point, boolean close) {
		super(point, close);
	}

	@Override
	public boolean exclude(Interval that) {
		return this.getPoint() > that.getFromEndPoint().getPoint() || this.getPoint() == that.getFromEndPoint().getPoint() && !this.isClosed() && that.getFromEndPoint().isClosed();
	}

	@Override
	public boolean include(double value) {
		return this.getPoint() < value || this.getPoint() == value && this.isClosed();
	}



}
