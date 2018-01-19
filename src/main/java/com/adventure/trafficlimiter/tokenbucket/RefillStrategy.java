package com.adventure.trafficlimiter.tokenbucket;

public interface RefillStrategy {
	public long refill();
	public long getInterval(); // in milliseconds
}
