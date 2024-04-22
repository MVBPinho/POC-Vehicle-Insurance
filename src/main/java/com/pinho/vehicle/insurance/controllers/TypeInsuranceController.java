package com.pinho.vehicle.insurance.controllers;

import com.pinho.vehicle.insurance.dto.TypeInsuranceDTO;
import com.pinho.vehicle.insurance.entities.TypeInsurance;
import com.pinho.vehicle.insurance.services.TypeInsuranceService;
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
@RequestMapping("/types/insurances")
@Tag(name = "Type_Insurance", description = "Endpoints for Managing Type Insurance")
public class TypeInsuranceController {

    @Autowired
    private TypeInsuranceService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON})
    @Operation(summary = "Finds all types insurances", description = "Finds all types insurances",
            tags = {"Type_Insurance"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = TypeInsurance.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<List<TypeInsuranceDTO>> findAll() {
        List<TypeInsuranceDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON})
    @Operation(summary = "Find a type insurance", description = "Find a type insurance",
            tags = {"Type_Insurance"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = TypeInsurance.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public  ResponseEntity<TypeInsuranceDTO> findById(@PathVariable(value = "id") Long id) {
        TypeInsuranceDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON})
    @Operation(summary = "Adds a new type insurance",
            description = "Adds a new type insurance by passing in a JSON representation of the type insurance!",
            tags = {"Type_Insurance"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = TypeInsurance.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<TypeInsuranceDTO> create(@RequestBody TypeInsuranceDTO insurance) {
        insurance = service.create(insurance);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(insurance.getId()).toUri();
        return ResponseEntity.created(uri).body(insurance);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})
    @Operation(summary = "Updates a type insurance",
            description = "Updates a new type insurance by passing in a JSON representation of the type insurance!",
            tags = {"Type_Insurance"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = TypeInsurance.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<TypeInsuranceDTO> update(@RequestBody TypeInsuranceDTO insurance) {
        TypeInsuranceDTO dto = service.update(insurance);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes a type insurances",
            description = "Deletes a new type insurance by passing in a JSON representation of the type insurance!",
            tags = {"Type_Insurance"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<TypeInsuranceDTO> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();

    }
}