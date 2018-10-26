package es.escuelait.refactoring;

public class LimitMinimum extends Limit{	
	
	public LimitMinimum(double minimum, boolean minimumClosed) {
		super(minimum, minimumClosed);
	}

	public double getMinimum() {
		return this.getValue();
	}
	
	public boolean isMinimumClosed() {
		return this.isClosed();
	}
		
	@Override
	public boolean include(Limit that) {
		return open.includeMinimum(that) || close.includeMinimum(that);
	}

	
	@Override
	public boolean exclude(Limit that) {
		return close.excludeMinimum(that) || open.excludeMinimum(that) ;
	}

	
}
