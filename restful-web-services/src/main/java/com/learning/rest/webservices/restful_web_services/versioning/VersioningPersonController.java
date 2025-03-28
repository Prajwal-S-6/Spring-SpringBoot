package com.learning.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public Personv1 getPersonV1() {
        return new Personv1("Prajwal S");
    }

    @GetMapping("/v2/person")
    public Personv2 getPersonV2() {
        return new Personv2(new Name("Prajwal", "S"));
    }

    @GetMapping(value = "person", params = "version=1")
    public Personv1 getFirstVersionPersonBasedOnRequestParamVersion() {
        return new Personv1("Prajwal S");
    }

    @GetMapping(value = "person", params = "version=2")
    public Personv2 getSecondVersionPersonBasedOnRequestParamVersion() {
        return new Personv2(new Name("Prajwal", "S"));
    }

    @GetMapping(value = "person/header", headers = "X-API-VERSION=1")
    public Personv1 getFirstVersionPersonBasedOnHeader() {
        return new Personv1("Prajwal S");
    }

    @GetMapping(value = "person/header", headers = "X-API-VERSION=2")
    public Personv2 getSecondVersionPersonBasedOnHeader() {
        return new Personv2(new Name("Prajwal", "S"));
    }

    @GetMapping(value = "person/mime", produces = "application/app-v1+json")
    public Personv1 getFirstVersionPersonBasedOnMimeType() {
        return new Personv1("Prajwal S");
    }


    @GetMapping(value = "person/mime", produces = "application/app-v2+json")
    public Personv2 getSecondVersionPersonBasedOnMime() {
        return new Personv2(new Name("Prajwal", "S"));
    }



}
