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
	public boolean include(Limit that) {
		return includeOpen(that) || includeClode(that);
	}

	private boolean includeClode(Limit that) {
		return this.getValue() == that.getValue() && this.isClosed();
	}

	private boolean includeOpen(Limit that) {
		return that.getValue() < this.getValue();
	}
		
	@Override
	public boolean exclude(Limit that) {
		return excludeOpen(that) || excludeClose(that);
	}

	private boolean excludeClose(Limit that) {
		return this.getValue() == that.getValue() && that.isClosed() && !this.isClosed();
	}

	private boolean excludeOpen(Limit that) {
		return that.getValue() > this.getValue();
	}
	
}
