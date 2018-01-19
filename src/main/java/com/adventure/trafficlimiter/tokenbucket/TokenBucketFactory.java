package com.adventure.trafficlimiter.tokenbucket;

import java.util.concurrent.TimeUnit;

// TokenBucket bucket = TokenBucketFactory.create(1024 * 10, speedLimitKBps, 1, TimeUnit.SECONDS); 
public final class TokenBucketFactory {

	public static TokenBucket create(long capacityTokens, long refillTokens, long interval, TimeUnit unit)
    {
        RefillStrategy strategy = new RefillStrategyFixedInterval(refillTokens, interval, unit);
        
        return new TokenBucket(capacityTokens, strategy);
    }
	
}
