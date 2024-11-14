package com.api.learning_track.controller;

import com.api.learning_track.model.Track;
import com.api.learning_track.service.TrackService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.net.URI;
import java.util.List;  
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/tracks")
@Tag(name = "Tracks controller", description = "API de trilha de aprendizado")
public record TrackController(TrackService trackService) {

    
    @GetMapping
    @Operation(summary = "All tracks", description = "retorna todas as trilhas")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "requsicao bem sucedida")
    })
    public List<Track> findAll(){
        return trackService.findAll();
    }


    @GetMapping("/{id}")
    @Operation(summary = "get one track", description = "retorna uma trilha com base no id")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "operação realizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "trilha nao encontrada")
    })
    public Track findById(@PathVariable("id")Long id){
        return trackService.findById(id);
    }

    @PostMapping
    @Operation(summary = "new track", description = "cria uma nova trilha")
    @ApiResponse(responseCode = "201", description = "trilha criada com sucesso")
    public ResponseEntity<Track> create(@RequestBody final Track newTrack){
        
        var track = trackService.create(newTrack);
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(track.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "new track", description = "atualiza trilha")
    @ApiResponse(responseCode = "200", description = "trilha atualizada com sucesso")
    public ResponseEntity<Track> update(@PathVariable Long id, @RequestBody Track trackToUpdate){

        var track = trackService.update(id, trackToUpdate);

        return ResponseEntity.ok(track);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete track", description = "apaga uma trilha")
    @ApiResponse(responseCode = "204", description = "trilha deletada com sucesso")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        trackService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
