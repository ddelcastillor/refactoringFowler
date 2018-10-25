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
		return limitMinimum.includeLimitMinimum(value, limitMinimum.isMinimumClosed())
				 && 
			   limitMaximum.includeLimitMaximum(value, limitMaximum.isMaximumClosed());
	}

				
	public boolean includes(Interval that) {
		
		return !(limitMinimum.excludeLimitMinimum(that) || limitMaximum.excludeLimitMaximum(that)) ;
				
	}
	

	

	



}
