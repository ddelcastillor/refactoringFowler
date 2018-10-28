package es.escuelait.refactoring;

public class FromEndPoint extends EndPoint{

	public FromEndPoint(double point, boolean closed) {
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
	
	public static FromEndPoint create(double point, boolean closed) {
		if (closed) {
			return new FromEndPointClosed(point,closed);
		}else {
			return new FromEndPointOpen(point,closed);			
		}
	}
		
	public boolean excludeEndPointValue(Interval that) {
		final boolean isLessThanFromEndPointValue = this.getPoint() > that.getFromEndPointValue();
		return isLessThanFromEndPointValue || excludeEqualFromEndPointValue(that);
	}
	
	
	private boolean excludeEqualFromEndPointValue(Interval that) {
		return that.isEqualFromEndPointValue(this.getPoint()) && that.isDifferenteFromEndPointClosed(this.isClosed());
	}
}
