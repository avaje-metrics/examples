package org.example.web.web;

import io.avaje.metrics.annotation.Timed;
import io.dinject.controller.Controller;
import io.dinject.controller.Get;
import io.dinject.controller.Path;
import io.dinject.controller.Produces;

@Timed(name = "my.thing.Here")
@Controller
@Path("/")
class HomeController {

  @Get
  @Produces("text/plain")
  String ack() {
    return "ok";
  }
}
