package baeldung.concurrent.threadsafety;

import concurrent.threadsafety.callables.ReentrantLockCounterCallable;
import concurrent.threadsafety.services.ReentrantLockCounter;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReentrantLockCounterUnitTest {

    @Test
    public void whenCalledIncrementCounter_thenCorrect() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ReentrantLockCounter counter = new ReentrantLockCounter();
        Future<Integer> future1 = (Future<Integer>) executorService.submit(new ReentrantLockCounterCallable(counter));
        Future<Integer> future2 = (Future<Integer>) executorService.submit(new ReentrantLockCounterCallable(counter));

        // Just to make sure both are completed
        future1.get();
        future2.get();

        Assertions.assertEquals(counter.getCounter(), 2);
    }
}
