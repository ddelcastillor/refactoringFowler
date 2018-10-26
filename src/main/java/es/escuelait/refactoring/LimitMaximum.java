package es.escuelait.refactoring;

public class LimitMaximum extends Limit {

	public LimitMaximum(double maximum, boolean maximumClosed) {
		super(maximum, maximumClosed);
		loadMaximumLimitTypes();
	}

	public double getMaximum() {
		return this.getValue();
	}

	public boolean isMaximumClosed() {
		return this.isClosed();
	}

	@Override
	public boolean include(Limit that) {
		return open.include(that)|| close.include(that);
	}

	@Override
	public boolean exclude(Limit that) {
		return open.exclude(that) || close.exclude(that);
	}

	
	@Override
	public void increase(double value) {
		super.increase(value);
		loadMaximumLimitTypes();
	}


	private void loadMaximumLimitTypes() {
		open = new LimitTypeOpenMaximum(this.getValue(), this.isClosed());
		close = new LimitTypeCloseMaximum(this.getValue(), this.isClosed());
	}

}
