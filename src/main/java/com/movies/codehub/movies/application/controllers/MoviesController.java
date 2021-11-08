package com.movies.codehub.movies.application.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MoviesController {

    @GetMapping("AboutMe")
    public String GetMe()
    {
        return "Hello from Movies";
    }
}
