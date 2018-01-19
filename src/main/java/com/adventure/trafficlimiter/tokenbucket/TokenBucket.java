package com.adventure.trafficlimiter.tokenbucket;

import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket {
	
	private long capacity = 1024 * 10;
	private RefillStrategy refillStrategy = null;
	private AtomicLong size;
	
	public TokenBucket(long capacity, RefillStrategy refillStrategy) {
		this.capacity = capacity;
		this.refillStrategy = refillStrategy;
		this.size = new AtomicLong(0L);
	}
	
	public void consume(long numTokens) throws InterruptedException {
		if(numTokens < 0 || numTokens >= this.capacity) throw new RuntimeException("Invalid paramemter!");
		
		long newTokens = Math.max(0, refillStrategy.refill());
		
		while(!Thread.currentThread().isInterrupted()) {
			long existingSize = size.get();
			long newValue = Math.max(0, Math.min(existingSize + newTokens, capacity));
			
			if (numTokens <= newValue) {
                newValue -= numTokens;
                if (size.compareAndSet(existingSize, newValue)) break;
            } else {
                Thread.sleep(refillStrategy.getInterval());
                newTokens = Math.max(0, refillStrategy.refill());
            }
		}
	}

	@Override
	public String toString() {
		return String.format("Capacity: %d, Size: %s", this.capacity, this.size.toString());
	}
}
