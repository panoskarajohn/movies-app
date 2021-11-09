package com.movies.codehub.movies.application.controllers;

import com.movies.codehub.movies.application.domain.Personnel;
import com.movies.codehub.movies.application.dto.PersonnelDto;
import com.movies.codehub.movies.application.extensions.DtoToDomain;
import com.movies.codehub.movies.application.services.PersonnelService;
import com.movies.codehub.movies.application.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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

    @PostMapping
    public ResponseEntity AddPersonnel(@RequestBody PersonnelDto personnelDto)
    {
        var personnel = DtoToDomain.PersonnelDtoToDomain(personnelDto);
        var id = personnelService.RegisterPersonnel(personnel);
        val uri = UriComponentsBuilder.fromPath("cast/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity UpdatePersonnel(@RequestBody PersonnelDto personnelDto)
    {
        var personnel = DtoToDomain.PersonnelDtoToDomain(personnelDto);
        var id = personnelService.UpdatePersonnel(personnel);
        val uri = UriComponentsBuilder.fromPath("cast/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity DeletePersonnel(@PathVariable("id") long id)
    {
        personnelService.DeletePersonnel(id);
        return ResponseEntity.noContent().build();
    }
}
