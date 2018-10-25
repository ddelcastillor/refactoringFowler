package es.escuelait.refactoring;

public class LimitMaximum {
	
	private double maximum;
	private boolean maximumClosed;

	public LimitMaximum(double maximum, boolean maximumClosed) {
		this.maximum = maximum;
		this.maximumClosed = maximumClosed;
	}
	
	public double getMaximum() {
		return maximum;
	}
	
	public boolean isMaximumClosed() {
		return maximumClosed;
	}
	
	public void increase(double value) {
		this.maximum += value;
	}

	public boolean includeLimitMaximum(double value, boolean maximumClosed) {
		return value < this.maximum || this.maximum == value && maximumClosed;
	}
		
	public boolean excludeLimitMaximum(double value, boolean maximumClosed) {
		return value > this.maximum  || this.maximum == value && maximumClosed && !this.maximumClosed;
	}

	public boolean excludeLimitMaximum(Interval that) {
		return this.excludeLimitMaximum(that.getLimitMaximum().getMaximum(), that.getLimitMaximum().isMaximumClosed());
	}

}
