package pl.zaoraj.infra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class RateLimitServiceTest {

    @Test
    void should_return_true_when_exceeded_limit() {
        final var rateLimitService = new RateLimitService();
        final var ip = generateIp();
        Assertions.assertFalse(rateLimitService.isRateExceeded(ip));

        Assertions.assertTrue(rateLimitService.isRateExceeded(ip));
    }

    private static String generateIp() {
        Random r = new Random();
        return r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256);
    }

}