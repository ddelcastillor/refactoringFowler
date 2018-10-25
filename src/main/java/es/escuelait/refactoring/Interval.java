package es.escuelait.refactoring;

public class Interval {
		
	private LimitMaximum limitMaximum;
	
	private LimitMinimum limitMinimum;

	public Interval(double minimum, boolean minimumClosed, double maximum, boolean maximumClosed) {
		assert minimum < maximum || minimum == maximum && minimumClosed || !minimumClosed;
		limitMinimum = new LimitMinimum(minimum,minimumClosed);
		limitMaximum = new LimitMaximum(maximum,maximumClosed);
	}

	public void shift(double value) {
		limitMinimum.increase(value);
		limitMaximum.increase(value);
	}
	
	
	public LimitMaximum getLimitMaximum() {
		return limitMaximum;
	}

	public LimitMinimum getLimitMinimum() {
		return limitMinimum;
	}

	public double length() {
		return limitMaximum.getMaximum() - limitMinimum.getMinimum();
	}
	
	public boolean includes(double value) {
		return includeLimitMinimum(value,limitMinimum.isMinimumClosed()) && 
			includeLimitMaximum(value,limitMaximum.isMaximumClosed());
	}

	private boolean includeLimitMinimum(double value, boolean minimumClosed) {
		return limitMinimum.includeLimitMinimum(value, minimumClosed);
	}
	
	private boolean includeLimitMaximum(double value, boolean maximumClosed) {
		return limitMaximum.includeLimitMaximum(value, maximumClosed);
	}
	
	private boolean excludeLimitMinimum(double value, boolean minimumClosed) {
		return limitMinimum.excludeLimitMinimum(value, minimumClosed);
	}
	
	private boolean excludeLimitMaximum(double value, boolean maximumClosed) {
		return limitMaximum.excludeLimitMaximum(value, maximumClosed);
//		return value > limitMaximum.getMaximum()  || limitMaximum.getMaximum() == value && maximumClosed && !limitMaximum.isMaximumClosed();
	}
	
	public boolean includes(Interval that) {
		
		
		if (excludeLimitMinimum(that.getLimitMinimum().getMinimum(),that.getLimitMinimum().isMinimumClosed())) {
			return false;
		}
		
		if (excludeLimitMaximum(that.getLimitMaximum().getMaximum(),that.getLimitMaximum().isMaximumClosed())) {
			return false;
		}

		return true;
	}
	

	



}
