package pl.zaoraj.infra;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RateLimitService {

    private ConcurrentHashMap<String, Instant> map = new ConcurrentHashMap<>();

    public boolean isRateExceeded(String ipAddress) {
        final var not_exceeded = map.get(ipAddress) == null ||
                map.get(ipAddress).isBefore(Instant.now().minus(24, ChronoUnit.HOURS));
        if (not_exceeded) {
            map.put(ipAddress, Instant.now());
            return false;
        }
        return true;
    }
}