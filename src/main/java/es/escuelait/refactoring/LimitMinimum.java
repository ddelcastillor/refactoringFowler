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
		return this.getValue() < that.getValue() || this.getValue() == that.getValue() && this.isClosed();
	}
	
	@Override
	public boolean exclude(Limit that) {
		return that.getValue() < this.getValue() || this.getValue() == that.getValue() && that.isClosed() && !this.isClosed() ;
	}
	

	
	
	


}
