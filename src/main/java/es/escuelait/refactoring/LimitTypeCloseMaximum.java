package es.escuelait.refactoring;

public class LimitTypeCloseMaximum extends LimitType{
	
	
	public LimitTypeCloseMaximum(double maximum, boolean maximumClosed) {
		super(maximum,  maximumClosed);
	}
		
	@Override
	public boolean include(Limit that) {
		return this.getValue() == that.getValue() && this.isClosed();
	}
		
	@Override
	public boolean exclude(Limit that) {
		return that.getValue() > this.getValue();
	}
	
}
