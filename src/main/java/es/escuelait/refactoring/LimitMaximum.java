package es.escuelait.refactoring;

public class LimitMaximum {
	
	
	private Limit maximum;

	public LimitMaximum(double maximum, boolean maximumClosed) {
		this.maximum = new Limit(maximum,  maximumClosed);
	}
	
	public double getMaximum() {
		return maximum.getValue();
	}
	
	public boolean isMaximumClosed() {
		return maximum.isClosed();
	}
	
	public void increase(double value) {
		maximum.increase(value);
	}

	public boolean include(double value, boolean maximumClosed) {
		return value < maximum.getValue() || maximum.getValue() == value && maximumClosed;
	}
		
	public boolean excludeLimitMaximum(double value, boolean maximumClosed) {
		return value > maximum.getValue() || maximum.getValue() == value && maximumClosed && !maximum.isClosed();
	}

	public boolean exclude(Interval that) {
		return this.excludeLimitMaximum(that.getLimitMaximum().getMaximum(), that.getLimitMaximum().isMaximumClosed());
	}

}
