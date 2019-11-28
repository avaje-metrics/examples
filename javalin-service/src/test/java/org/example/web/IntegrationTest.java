package org.example.web;

import io.javalin.Javalin;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.example.web.api.Foo;
import org.example.web.api.ListResponse;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest {

  @Test
  public void GET_home() {

    Javalin app = Application.start(9091);
    try {
      final HttpResponse<String> res0 = Unirest.get("http://localhost:9091")
        .header("Content-Type", "application/json")
        .asString();

      assertThat(res0.getStatus()).isEqualTo(200);
      assertThat(res0.getBody()).isEqualTo("ok");


      final HttpResponse<ListResponse<Foo>> res1 = Unirest.get("http://localhost:9091/api/foo")
        .header("Content-Type", "application/json")
        .asObject(new GenericType<ListResponse<Foo>>() {
        });

      assertThat(res1.getStatus()).isEqualTo(200);
      final ListResponse<Foo> body = res1.getBody();
      final List<Foo> list = body.getList();
      assertThat(list).isNotNull();
      assertThat(list).hasSize(2);

    } finally {
      app.stop();
    }
  }

}
