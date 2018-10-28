package es.escuelait.refactoring;

public class UntilEndPoint extends EndPoint {

	public UntilEndPoint(double point, boolean closed) {
		super(point, closed);
	}

	@Override
	public boolean exclude(Interval that) {
		return this.exclude(that);
	}

	@Override
	public boolean include(double value) {
		return this.include(value);
	}
	
	public static UntilEndPoint create(double point, boolean close) {
		if (close) {
			return new UntilEndPointClosed(point,close);
		}else {
			return new UntilEndPointOpen(point,close);			
		}
	}
	
	@Override
	public boolean excludeEndPointValue(Interval that) {
		final boolean isLessThanUntilEndPointValue = this.getPoint() < that.getUntilEndPointValue();
		return isLessThanUntilEndPointValue || excludeEqualUntilEndPointValue(that);
	}
	
	private boolean excludeEqualUntilEndPointValue(Interval that) {
		return that.isEqualUntilEndPointValue(this.getPoint()) && that.isDifferenteUntilEndPointClosed(this.isClosed());
	}
	
}
