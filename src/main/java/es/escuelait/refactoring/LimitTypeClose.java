package es.escuelait.refactoring;

public class LimitTypeClose extends LimitType{
	
	
	public LimitTypeClose(double value, boolean close) {
		super(value,  close);
	}

	@Override
	public boolean excludeMinimum(Limit that) {
		return that.getValue() < this.getValue();
	}

	@Override
	public boolean includeMinimum(Limit that) {
		return sameValueClosed(that);
	}

	@Override
	public boolean excludeMaximum(Limit that) {
		return that.getValue() > this.getValue();
	}

	@Override
	public boolean includeMaximum(Limit that) {
		return sameValueClosed(that);
	}

	private boolean sameValueClosed(Limit that) {
		return this.getValue() == that.getValue() && this.isClosed();
	}
			
}
