package es.escuelait.refactoring;

public class UntilEndPoint extends EndPoint {

	public UntilEndPoint(double point, boolean close) {
		super(point, close);
	}

	@Override
	public boolean exclude(Interval that) {
		return this.getPoint() < that.getUntilEndPoint().getPoint()
				|| this.getPoint() == that.getUntilEndPoint().getPoint() && !this.isClosed()
						&& that.getUntilEndPoint().isClosed();
	}

	@Override
	public boolean include(double value) {
		return value < this.getPoint() || this.getPoint() == value && this.isClosed();
	}

}
