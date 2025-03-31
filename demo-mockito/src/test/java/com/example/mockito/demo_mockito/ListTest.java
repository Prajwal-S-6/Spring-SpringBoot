package com.example.mockito.demo_mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListTest {

    @Test
    public void test() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(1).thenReturn(2);
        assertEquals(1, listMock.size());
        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size());

    }

    @Test
    public void parameters() {
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("Zero");
        assertEquals("Zero", listMock.get(0));
    }

    @Test
    public void genericparameters() {
        List listMock = mock(List.class);
        when(listMock.get(Mockito.anyInt())).thenReturn("Zero");
        assertEquals("Zero", listMock.get(1));
    }
}
