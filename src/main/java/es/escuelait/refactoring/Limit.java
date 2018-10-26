package es.escuelait.refactoring;

public abstract class Limit {
	private double value;
	private boolean closed;
	protected LimitType close,open;

	public Limit(double value, boolean closed) {
		this.value = value;
		this.closed = closed;
		loadLimitTypes();
	}

	public double getValue() {
		return value;
	}

	public boolean isClosed() {
		return closed;
	}

	public void increase(double value) {
		this.value += value;
		loadLimitTypes();
	}
	
	abstract public boolean exclude(Limit that);
	
	abstract public boolean include(Limit that);
	
	protected void loadLimitTypes() {
		open = new LimitTypeOpen(this.getValue(), this.isClosed());
		close = new LimitTypeClose(this.getValue(), this.isClosed());
	}
	
	
	
	

}
