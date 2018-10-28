package es.escuelait.refactoring;

public class FromEndPoint extends EndPoint{

	public FromEndPoint(double point, boolean close) {
		super(point, close);
	}

	@Override
	public boolean exclude(Interval that) {
		return this.exclude(that);
	}

	@Override
	public boolean include(double value) {
		return this.include(value);
	}
	
	public static FromEndPoint create(double point, boolean close) {
		if (close) {
			return new FromEndPointClosed(point,close);
		}else {
			return new FromEndPointOpen(point,close);			
		}
	}
	
	protected boolean excludeMinimum(Interval that) {
		return isLessThanMinimum(that) || 
				excludeEqualMinimum(that);
	}
	
	private boolean isLessThanMinimum(Interval that) {
		return this.getPoint() > that.getFromEndPointValue();
	}
			
	private boolean excludeEqualMinimum(Interval that) {
		return isEqualThanMinimum(that) && diffentClosedThatMinimumInterval(that);

	}

	private boolean isEqualThanMinimum(Interval that) {
		return this.getPoint() == that.getFromEndPointValue();
	}
	
	private boolean diffentClosedThatMinimumInterval(Interval that) {
		return !this.isClosed()
				&& that.isFromEndPointClosed();
	}
			
}
