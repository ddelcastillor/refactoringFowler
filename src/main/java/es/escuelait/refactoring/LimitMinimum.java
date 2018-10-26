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
	public boolean include(Limit that) {
		return includeOpen(that) || includeClose(that);
	}

	private boolean includeClose(Limit that) {
		return this.getValue() == that.getValue() && this.isClosed();
	}

	private boolean includeOpen(Limit that) {
		return this.getValue() < that.getValue();
	}
	
	@Override
	public boolean exclude(Limit that) {
		return excludeOpen(that) || excludeClose(that) ;
	}

	private boolean excludeClose(Limit that) {
		return this.getValue() == that.getValue() && that.isClosed() && !this.isClosed();
	}

	private boolean excludeOpen(Limit that) {
		return that.getValue() < this.getValue();
	}
	

	
	
	


}
