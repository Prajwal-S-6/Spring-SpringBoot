package com.example.mockito.demo_mockito.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.xml.crypto.Data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplTestUsingMock {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl businessImpl;


    @Test
    void shouldFindLargestElementFromAllData() {
//        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25, 66, 85});
//        SomeBusinessImpl business = new SomeBusinessImpl(dataServiceMock);
        assertEquals(85, businessImpl.findLargestFromAllData());
    }

    @Test
    void shouldFindLargestElementFromSingleData() {
        DataService dataServiceMock = mock(DataService.class);  //OR
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25});
        SomeBusinessImpl business = new SomeBusinessImpl(dataServiceMock);
        assertEquals(25, business.findLargestFromAllData());
    }

    @Test
    void shouldFindLargestElementFromEmptyData() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(Integer.MIN_VALUE, businessImpl.findLargestFromAllData());
    }

}
