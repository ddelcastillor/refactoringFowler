package es.escuelait.refactoring;

public class LimitMinimum {	
	private Limit minimum;
		
	public LimitMinimum(double minimum, boolean minimumClosed) {

		this.minimum = new Limit(minimum,  minimumClosed);
	}

	public double getMinimum() {
		return minimum.getValue();
	}
	
	public void increase(double value) {
		minimum.increase(value);
	}
	
	public boolean isMinimumClosed() {
		return minimum.isClosed();
	}


	public boolean include(double value, boolean minimumClosed) {
		return minimum.getValue() < value || minimum.getValue() == value && minimum.isClosed();
	}
	
	
	public boolean excludeLimitMinimum(double value, boolean minimumClosed) {
		return value < minimum.getValue() || minimum.getValue() == value && minimumClosed && !minimum.isClosed() ;
	}

	
	public boolean exclude(Interval that) {
		return this.excludeLimitMinimum(that.getLimitMinimum().getMinimum(), that.getLimitMinimum().isMinimumClosed());
	}
	
	
	


}
