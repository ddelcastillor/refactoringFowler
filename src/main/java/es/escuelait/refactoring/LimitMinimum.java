package es.escuelait.refactoring;

public class LimitMinimum {
	private double minimum;
	private boolean minimumClosed;
	
	
	
	public LimitMinimum(double minimum, boolean minimumClosed) {
		this.minimum = minimum;
		this.minimumClosed = minimumClosed;
	}

	public double getMinimum() {
		return minimum;
	}
	
	public void increase(double value) {
		this.minimum += value;
	}
	
	public boolean isMinimumClosed() {
		return minimumClosed;
	}


	public boolean includeLimitMinimum(double value, boolean minimumClosed) {
		return this.minimum < value || this.minimum == value && minimumClosed;
	}
	
	
	public boolean excludeLimitMinimum(double value, boolean minimumClosed) {
		return value < this.minimum || this.minimum == value && minimumClosed && !this.minimumClosed ;
	}
	


}
