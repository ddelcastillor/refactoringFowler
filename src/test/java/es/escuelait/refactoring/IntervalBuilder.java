package es.escuelait.refactoring;

public class IntervalBuilder {

	private double minimum;

	private boolean minimumClosed;

	private double maximum;

	private boolean maximumClosed;

	private IntervalBuilderState intervalBuilderState;

	public IntervalBuilder() {
		this.intervalBuilderState = null;
	}

	public IntervalBuilder open(double value) {
		assert intervalBuilderState != IntervalBuilderState.MAXIMUM_SETTED;
		if (intervalBuilderState == null) {
			this.minimum = value;
			this.minimumClosed = false;
			intervalBuilderState = IntervalBuilderState.MINIMUM_SETTED;
		} else {
			this.maximum = value;
			this.maximumClosed = false;
			intervalBuilderState = IntervalBuilderState.MAXIMUM_SETTED;
		}
		return this;
	}

	public IntervalBuilder closed(double value) {
		assert intervalBuilderState != IntervalBuilderState.MAXIMUM_SETTED;
		if (intervalBuilderState == null) {
			this.minimum = value;
			this.minimumClosed = true;
			intervalBuilderState = IntervalBuilderState.MINIMUM_SETTED;
		} else {
			this.maximum = value;
			this.maximumClosed = true;
			intervalBuilderState = IntervalBuilderState.MAXIMUM_SETTED;
		}
		return this;
	}

	public Interval build() {
		return new Interval(this.minimum, this.minimumClosed, this.maximum, this.maximumClosed);
	}
}
