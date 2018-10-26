package es.escuelait.refactoring;

public class LimitTypeOpenMaximum extends LimitType{
	
		
	public LimitTypeOpenMaximum(double maximum, boolean maximumClosed) {
		super(maximum,  maximumClosed);
	}
	
	@Override
	public boolean include(Limit that) {
		return that.getValue() < this.getValue();
	}
		
	@Override
	public boolean exclude(Limit that) {
		return this.getValue() == that.getValue() && that.isClosed() && !this.isClosed();
	}
	
}
