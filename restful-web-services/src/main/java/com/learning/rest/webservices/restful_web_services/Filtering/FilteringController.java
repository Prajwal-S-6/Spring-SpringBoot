package com.learning.rest.webservices.restful_web_services.Filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("filtering")
    public MappingJacksonValue filtering() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter filter =  SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");                            ;
        FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @GetMapping("filtering-list")
    public MappingJacksonValue filteringList() {
        List<SomeBean> someBeansList = List.of(new SomeBean("value1", "value2", "value3"), new SomeBean("value4", "value5", "value6"));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBeansList);
        SimpleBeanPropertyFilter filter =  SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");                            ;
        FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}
