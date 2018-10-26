package es.escuelait.refactoring;

public class LimitMaximum extends Limit{
	
	
	public LimitMaximum(double maximum, boolean maximumClosed) {
		super(maximum,  maximumClosed);
	}
	
	public double getMaximum() {
		return this.getValue();
	}
	
	public boolean isMaximumClosed() {
		return this.isClosed();
	}
	
	@Override
	public boolean include(double value, boolean maximumClosed) {
		return value < this.getValue() || this.getValue() == value && this.isClosed();
	}
		
	@Override
	public boolean exclude(Interval that) {
		return this.excludeLimitMaximum(that.getLimitMaximum().getMaximum(), that.getLimitMaximum().isMaximumClosed());
	}
	
	private boolean excludeLimitMaximum(double value, boolean maximumClosed) {
		return value > this.getValue() || this.getValue() == value && maximumClosed && !this.isClosed();
	}

}
