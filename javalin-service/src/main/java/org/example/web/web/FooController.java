package org.example.web.web;

import io.dinject.controller.Controller;
import io.dinject.controller.Form;
import io.dinject.controller.Get;
import io.dinject.controller.Path;
import io.dinject.controller.Post;
import org.example.web.api.Foo;
import org.example.web.api.ListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Controller
@Path("/api/foo")
class FooController {

  private static final Logger log = LoggerFactory.getLogger(FooController.class);

  @Get("/:name")
  Foo getByName(String name) {
    return new Foo(name);
  }

  @Get
  ListResponse<Foo> getAll() {

    List<Foo> list = new ArrayList<>();
    list.add(new Foo("hi"));
    list.add(new Foo("there"));
    return new ListResponse<>(list);
  }

  @Post
  @Form
  void post(String name) {
    log.info("posted foo {}", name);
  }
}
