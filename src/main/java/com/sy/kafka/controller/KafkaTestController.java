package com.sy.kafka.controller;

import com.sy.kafka.config.kafka.producer.Sender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 孙宇
 * @since 2021/7/23 17:51
 */
@RestController
@Slf4j
public class KafkaTestController {
    @Autowired
    private Sender sender;

    @PostMapping(value = "/send")
    public void exec(HttpServletRequest request, HttpServletResponse response, String data) throws IOException {
        this.sender.send("testtopic",data);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json");
        response.getWriter().write("success");
        response.getWriter().flush();
        response.getWriter().close();

    }
}
