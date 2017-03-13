# boxfish-commons-web-model-paging

![Boxfish Logo](https://raw.github.com/bxfsh/boxfish-commons-web-model-paging/master/src/main/resources/boxfish-logo.jpg)

By [Boxfish](http://www.boxfish.com)

[![Build Status](https://travis-ci.org/bxfsh/boxfish-commons-web-model-paging.svg?branch=master)](https://travis-ci.org/bxfsh/boxfish-commons-web-model-paging)

Effortless paging for [Boxfish Model](https://github.com/bxfsh/boxfish-commons-web-model) + [Spring Data Paging](http://docs.spring.io/spring-data/jpa/docs/1.4.1.RELEASE/reference/html/jpa.repositories.html)

* Single command to extract a **Pageable** from a **Model**
* **Spring JPA Repository** compatible
* **PagedOutput** class to standardise your paged DTO

Depends on:

* https://github.com/bxfsh/boxfish-commons-web-model

## Why another paging library?
If you are using the [Boxfish Model](https://github.com/bxfsh/boxfish-commons-web-model) there will be the
time win which producing the Pageable object for your JPA Repositories (or any other Spring Data pagination system)
will become too repetitive.

This model sorts that problem out for you with a one-liner:

```java

	  // Controller.java
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> list(final @RequestParam Map query) {
        final Pageable paging = PagingInfo.from(query);
        final PagedOutput<Entity> wrapper = PagedOutput.wrap(repo.list(paging);
        return ResponseEntity.ok(wrapper);
    }

```
