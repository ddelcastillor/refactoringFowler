package es.escuelait.refactoring;

public class Interval {

	private double minimum;

	private boolean minimumClosed;

	private double maximum;

	private boolean maximumClosed;

	public Interval(double minimum, boolean minimumClosed, double maximum, boolean maximumClosed) {
		assert minimum < maximum || minimum == maximum && minimumClosed || !minimumClosed;
		this.minimum = minimum;
		this.minimumClosed = minimumClosed;
		this.maximum = maximum;
		this.maximumClosed = maximumClosed;
	}

	public void shift(double value) {
		this.minimum += value;
		this.maximum += value;
	}

	public double length() {
		return this.maximum - this.minimum;
	}
	
	public boolean includes(double value) {
		return includeLimitMinimum(value) && 
			includeLimitMaximum(value);
	}

	private boolean includeLimitMaximum(double value) {
		return value < this.maximum || this.maximum == value && this.maximumClosed;
	}

	private boolean includeLimitMinimum(double value) {
		return this.minimum < value || this.minimum == value && this.minimumClosed;
	}
	
	
	public boolean includes(Interval that) {
		if (that.minimum < this.minimum || this.minimum == that.minimum && that.minimumClosed && !this.minimumClosed) {
			return false;
		}
		
		if (that.maximum > this.maximum  || this.maximum == that.maximum && that.maximumClosed && !this.maximumClosed) {
			return false;
		}
		
		return true;
	}
	

	



}
