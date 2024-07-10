package com.example.myFirstProject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LogController {

    //Using SL4J Logger
    Logger logger = LoggerFactory.getLogger(LogController.class);

    @RequestMapping("/log") public String log(){
        logger.trace("Log Level: TRACE");
        logger.info("This is info");
        logger.debug("This is debug");
        logger.error("This is error");
        logger.warn("This is warning");

        return "Logging finished";
    }
}
