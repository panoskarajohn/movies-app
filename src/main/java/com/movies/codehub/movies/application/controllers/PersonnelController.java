package com.movies.codehub.movies.application.controllers;

import com.movies.codehub.movies.application.domain.Personnel;
import com.movies.codehub.movies.application.services.PersonnelService;
import com.movies.codehub.movies.application.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cast")
@RequiredArgsConstructor
public class PersonnelController {
    private final PersonnelService personnelService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Personnel>> GetPersonnel(@PathVariable("id") long id)
    {
        var personnel = personnelService.GetPersonnel(id);
        return ResponseEntity.ok(ApiResponse.<Personnel>builder().data(personnel).build());
    }
}
