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
	public boolean include(double value, boolean minimumClosed) {
		return this.getValue() < value || this.getValue() == value && this.isClosed();
	}
	
	@Override
	public boolean exclude(Interval that) {
		return this.excludeLimitMinimum(that.getLimitMinimum().getMinimum(), that.getLimitMinimum().isMinimumClosed());
	}
	
	private boolean excludeLimitMinimum(double value, boolean minimumClosed) {
		return value < this.getValue() || this.getValue() == value && minimumClosed && !this.isClosed() ;
	}
	
	
	


}
