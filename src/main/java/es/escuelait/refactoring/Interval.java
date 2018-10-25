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
		return includeLimitMinimum(value,this.minimumClosed) && 
			includeLimitMaximum(value,this.maximumClosed);
	}

	public boolean includeLimitMinimum(double value, boolean minimumClosed) {
		return this.minimum < value || this.minimum == value && minimumClosed;
	}
	
	private boolean includeLimitMaximum(double value, boolean maximumClosed) {
		return value < this.maximum || this.maximum == value && maximumClosed;
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
