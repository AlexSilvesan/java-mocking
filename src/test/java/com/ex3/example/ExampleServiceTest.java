package com.ex3.example;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

@ExtendWith(MockitoExtension.class)
class ExampleServiceTest
{
    @Mock
    private ExampleService exampleService;

    @Test
    void testConditionalMocking()
    {
        Mockito.when(exampleService.computeSomethingWithParam(24)).thenReturn(42);
        Mockito.when(exampleService.computeSomethingWithParam(100)).thenReturn(200);

        Assertions.assertEquals(42, exampleService.computeSomethingWithParam(24));
        Assertions.assertEquals(200, exampleService.computeSomethingWithParam(100));
    }

    @Test
    void testNumberOfInteractions()
    {
        System.out.println(exampleService.computeSomething());
        System.out.println(exampleService.computeSomething());
        System.out.println(exampleService.computeSomething());
        System.out.println(exampleService.computeSomething());

        Mockito.verify(exampleService, Mockito.times(4)).computeSomething();
    }

    @Test
    void testMockingVoidMethod()
    {
        Mockito.doAnswer((Answer<Object>) invocation -> {
            System.out.println("I am mocking a void method!");
            return null;
        }).when(exampleService).doSomethingVoid();

        exampleService.doSomethingVoid();
    }

    @Test
    void testCapturingArguments()
    {
        var argumentCaptor = ArgumentCaptor.forClass(Integer.class);

        exampleService.computeSomethingWithParam(10);
        exampleService.computeSomethingWithParam(20);
        exampleService.computeSomethingWithParam(80);

        Mockito.verify(exampleService, Mockito.times(3)).computeSomethingWithParam(argumentCaptor.capture());
        System.out.println(argumentCaptor.getAllValues());
    }

    @Test
    void testUsingCallArgumentsInMocking()
    {
        var argumentCaptor = ArgumentCaptor.forClass(Integer.class);

        Mockito.doAnswer((Answer<Object>) invocation -> {
            var params = invocation.getArguments();
            System.out.printf("I have been called with %d params: %s", params.length, Arrays.deepToString(params));
            int firstParam = (int) params[0];
            return firstParam * 2;
        }).when(exampleService).computeSomethingWithParam(argumentCaptor.capture());

        Assertions.assertEquals(60, exampleService.computeSomethingWithParam(30));
    }
}
