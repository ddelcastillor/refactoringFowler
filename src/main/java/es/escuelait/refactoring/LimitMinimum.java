package es.escuelait.refactoring;

public class LimitMinimum extends Limit{	
	
	public LimitMinimum(double minimum, boolean minimumClosed) {
		super(minimum, minimumClosed);
		loadMinimumLimitTypes();
	}

	public double getMinimum() {
		return this.getValue();
	}
	
	public boolean isMinimumClosed() {
		return this.isClosed();
	}
	
	@Override
	public void increase(double value) {
		super.increase(value);
		loadMinimumLimitTypes();
	}
	
	@Override
	public boolean include(Limit that) {
		return open.include(that) || close.include(that);
	}

	
	@Override
	public boolean exclude(Limit that) {
		return close.exclude(that) || open.exclude(that) ;
	}

	
	private void loadMinimumLimitTypes() {
		open = new LimitTypeOpenMinimum(this.getValue(), this.isClosed());
		close = new LimitTypeCloseMinimum(this.getValue(),this.isClosed());
	}

}
