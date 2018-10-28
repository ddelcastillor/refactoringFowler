package es.escuelait.refactoring;

public class UntilEndPointOpen extends UntilEndPoint{

	public UntilEndPointOpen(double point, boolean close) {
		super(point, close);
	}
	
	@Override
	public boolean include(double value) {
		return value < this.getPoint();
	}
	
	@Override
	public boolean exclude(Interval that) {
		return isGreaterThanMaximum(that) || excludeEqualMaximum(that);
	}
	
	private boolean isGreaterThanMaximum(Interval that) {
		return this.getPoint() < that.getUntilEndPointValue() ;
	}
	
	private boolean excludeEqualMaximum(Interval that) {
		return isEqualThanMaximum(that) && differentClosedThatMaximumInterval(that);
	}

	private boolean isEqualThanMaximum(Interval that) {
		return this.getPoint() == that.getUntilEndPointValue();
	}

	private boolean differentClosedThatMaximumInterval(Interval that) {
		return !this.isClosed()
				&& that.isUntilEndPointClosed();

	}
	
	
}
