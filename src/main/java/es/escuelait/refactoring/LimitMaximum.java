package es.escuelait.refactoring;

public class LimitMaximum extends Limit {

	public LimitMaximum(double maximum, boolean maximumClosed) {
		super(maximum, maximumClosed);
	}

	public double getMaximum() {
		return this.getValue();
	}

	public boolean isMaximumClosed() {
		return this.isClosed();
	}

	@Override
	public boolean include(Limit that) {
		return open.includeMaximum(that)|| close.includeMaximum(that);
	}

	@Override
	public boolean exclude(Limit that) {
		return open.excludeMaximum(that) || close.excludeMaximum(that);
	}

}
