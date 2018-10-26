package es.escuelait.refactoring;

public class LimitMaximum extends Limit {

	private LimitType type;

	public LimitMaximum(double maximum, boolean maximumClosed) {
		super(maximum, maximumClosed);
		if (maximumClosed)
			this.type = new LimitTypeCloseMaximum(maximum, maximumClosed);
		else
			this.type = new LimitTypeOpenMaximum(maximum, maximumClosed);
	}

	public double getMaximum() {
		return this.getValue();
	}

	public boolean isMaximumClosed() {
		return this.isClosed();
	}

	@Override
	public boolean include(Limit that) {
		return includeOpen(that) || includeClose(that);
	}

	@Override
	public boolean exclude(Limit that) {
		return excludeOpen(that) || excludeClose(that);
	}

	private boolean includeClose(Limit that) {
		return new LimitTypeCloseMaximum(this.getValue(), this.isClosed()).include(that);
	}

	private boolean excludeOpen(Limit that) {
		return new LimitTypeOpenMaximum(this.getValue(), this.isClosed()).exclude(that);

	}

	private boolean includeOpen(Limit that) {
		return new LimitTypeOpenMaximum(this.getValue(), this.isClosed()).include(that);
	}

	private boolean excludeClose(Limit that) {
		return new LimitTypeCloseMaximum(this.getValue(), this.isClosed()).exclude(that);
	}

}
