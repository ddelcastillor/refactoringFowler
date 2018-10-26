package es.escuelait.refactoring;

public class LimitTypeOpen extends LimitType{
	
		
	public LimitTypeOpen(double value, boolean close) {
		super(value,  close);
	}

	@Override
	public boolean excludeMinimum(Limit that) {
		return sameValueDifferentType(that);
	}

	@Override
	public boolean includeMinimum(Limit that) {
		return this.getValue() < that.getValue();
	}

	@Override
	public boolean excludeMaximum(Limit that) {
		return sameValueDifferentType(that);
	}

	@Override
	public boolean includeMaximum(Limit that) {
		return that.getValue() < this.getValue();
	}
	
	private boolean sameValueDifferentType(Limit that) {
		return this.getValue() == that.getValue() && !this.isClosed() && that.isClosed();
	}
		
}
