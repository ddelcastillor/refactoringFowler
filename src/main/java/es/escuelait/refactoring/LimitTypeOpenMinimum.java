package es.escuelait.refactoring;

public class LimitTypeOpenMinimum extends LimitType{
	
		
	public LimitTypeOpenMinimum(double maximum, boolean maximumClosed) {
		super(maximum,  maximumClosed);
	}
	
	@Override
	public boolean include(Limit that) {
		return this.getValue() < that.getValue();
	}
		
	@Override
	public boolean exclude(Limit that) {
		return this.getValue() == that.getValue() && that.isClosed() && !this.isClosed();
	}
	
}
