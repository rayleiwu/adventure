package com.adventure.trafficlimiter.tokenbucket;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class RefillStrategyFixedInterval implements RefillStrategy {

    private long numTokens;
    private long interval;
    private AtomicLong nextRefillTime;
    
	public RefillStrategyFixedInterval(long numTokens, long interval, TimeUnit unit) {
        this.numTokens = numTokens;
        this.interval = unit.toMillis(interval);
        this.nextRefillTime = new AtomicLong(-1L);
    }

    public long refill() {
        final long now = System.currentTimeMillis();
        final long refillTime = nextRefillTime.get();
        
        if (now < refillTime) {
            return 0;
        }

        return nextRefillTime.compareAndSet(refillTime, now + interval) ? numTokens : 0;
    }

    public long getInterval() {
        return interval;
    }
}
