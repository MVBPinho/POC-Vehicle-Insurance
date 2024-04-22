package com.pinho.vehicle.insurance.controllers;

import com.pinho.vehicle.insurance.dto.InsuranceDTO;
import com.pinho.vehicle.insurance.entities.Insurance;
import com.pinho.vehicle.insurance.services.InsuranceService;
import com.pinho.vehicle.insurance.utils.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/insurances")
@Tag(name = "Insurance", description = "Endpoints for Managing Insurance")
public class InsuranceController {

    @Autowired
    private InsuranceService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON})
    @Operation(summary = "Finds all Insurance", description = "Finds all insurance",
            tags = {"Insurance"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = Insurance.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<List<InsuranceDTO>> findAll() {
        List<InsuranceDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON})
    @Operation(summary = "Finds a Insurance", description = "Finds a Insurance",
            tags = {"Insurance"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Insurance.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public  ResponseEntity<InsuranceDTO> findById(@PathVariable(value = "id") Long id) {
        InsuranceDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON})
    @Operation(summary = "Adds a new Insurance",
            description = "Adds a new Insurance by passing in a JSON representation of the insurance!",
            tags = {"Insurance"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Insurance.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<InsuranceDTO> create(@RequestBody InsuranceDTO insurance) {
        insurance = service.create(insurance);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(insurance.getId()).toUri();
        return ResponseEntity.created(uri).body(insurance);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})
    @Operation(summary = "Updates a Insurance",
            description = "Updates a new Insurance by passing in a JSON representation of the insurance!",
            tags = {"Insurance"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Insurance.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<InsuranceDTO> update(@RequestBody InsuranceDTO insurance) {
        InsuranceDTO dto = service.update(insurance);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes a Insurances",
            description = "Deletes a new Insurance by passing in a JSON representation of the insurance!",
            tags = {"Insurance"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<InsuranceDTO> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();

    }
}