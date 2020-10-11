package baeldung.concurrent.threadsafety;

import concurrent.threadsafety.callables.MessageServiceCallable;
import concurrent.threadsafety.services.MessageService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MessageServiceUnitTest {

    @Test
    public void whenCalledgetMessage_thenCorrect() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        MessageService messageService = new MessageService("Welcome to Baeldung!");
        Future<String> future1 = (Future<String>) executorService.submit(new MessageServiceCallable(messageService));
        Future<String> future2 = (Future<String>) executorService.submit(new MessageServiceCallable(messageService));

        Assertions.assertEquals(future1.get(), "Welcome to Baeldung!");
        Assertions.assertEquals(future2.get(), "Welcome to Baeldung!");
    }
}
