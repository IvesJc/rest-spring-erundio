package br.com.erudio.controller;

import br.com.erudio.dto.v1.PersonDTOv1;
import br.com.erudio.dto.v2.PersonDTOv2;
import br.com.erudio.services.PersonService;
import br.com.erudio.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/person/v1")
@Tag(name = "People", description = "Endpoints for Managing people")
public class PersonController {

    @Autowired
    private PersonService personServices;

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON,
                        MediaType.APPLICATION_XML,
                        MediaType.APPLICATION_YAML
            })
    @Operation(
            summary = "Finds all people",
            description = "Finds all people",
            tags = {"People"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation =
                                                    PersonDTOv1.class))
                                    )
                            }),
                    @ApiResponse(
                            description = "Bad Request",
                            responseCode = "400",
                            content = @Content),
                    @ApiResponse(
                            description = "Unauthorized",
                            responseCode = "401",
                            content = @Content),
                    @ApiResponse(
                            description = "Not found",
                            responseCode = "404",
                            content = @Content),
                    @ApiResponse(
                            description = "Internal Server Error",
                            responseCode = "500",
                            content = @Content),
            })
    public List<PersonDTOv1> findAll(){
        return personServices.findAll();
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON,
                        MediaType.APPLICATION_XML,
                        MediaType.APPLICATION_YAML
            })
    @Operation(
            summary = "Finds a person",
            description = "Finds a person",
            tags = {"People"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content =
                                    @Content(
                                            schema = @Schema(implementation =
                                                    PersonDTOv1.class))
                    ),
                    @ApiResponse(
                            description = "No Content",
                            responseCode = "204",
                            content = @Content),
                    @ApiResponse(
                            description = "Bad Request",
                            responseCode = "400",
                            content = @Content),
                    @ApiResponse(
                            description = "Unauthorized",
                            responseCode = "401",
                            content = @Content),
                    @ApiResponse(
                            description = "Not found",
                            responseCode = "404",
                            content = @Content),
                    @ApiResponse(
                            description = "Internal Server Error",
                            responseCode = "500",
                            content = @Content),
            })
    public PersonDTOv1 findById(@PathVariable(value = "id") Long id){
        return personServices.findById(id);
    }

    @PostMapping(
            produces = {MediaType.APPLICATION_JSON,
                        MediaType.APPLICATION_XML,
                        MediaType.APPLICATION_YAML
            })
    @Operation(
            summary = "Add a new person",
            description = "Add a new person by passing in a JSON, XML or YML representation of the person",
            tags = {"People"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content =
                            @Content(
                                    schema = @Schema(implementation =
                                            PersonDTOv1.class))
                    ),
                    @ApiResponse(
                            description = "Bad Request",
                            responseCode = "400",
                            content = @Content),
                    @ApiResponse(
                            description = "Unauthorized",
                            responseCode = "401",
                            content = @Content),
                    @ApiResponse(
                            description = "Internal Server Error",
                            responseCode = "500",
                            content = @Content),
            })
    public PersonDTOv1 create(@RequestBody PersonDTOv1 person){
        return personServices.create(person);
    }

    // V2 with new attribute
    @PostMapping(
            value = "/v2",
            produces = {MediaType.APPLICATION_JSON,
                        MediaType.APPLICATION_XML,
                        MediaType.APPLICATION_YAML
            })
    @Operation(
            summary = "Add a new person",
            description = "Add a new person by passing in a JSON, XML or YML representation of the person",
            tags = {"People"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content =
                            @Content(
                                    schema = @Schema(implementation =
                                            PersonDTOv1.class))
                    ),
                    @ApiResponse(
                            description = "Bad Request",
                            responseCode = "400",
                            content = @Content),
                    @ApiResponse(
                            description = "Unauthorized",
                            responseCode = "401",
                            content = @Content),
                    @ApiResponse(
                            description = "Internal Server Error",
                            responseCode = "500",
                            content = @Content),
            })
    public PersonDTOv2 createV2(@RequestBody PersonDTOv2 person){
        return personServices.createV2(person);
    }

    @PutMapping(
            produces = {MediaType.APPLICATION_JSON,
                        MediaType.APPLICATION_XML,
                        MediaType.APPLICATION_YAML
            })
    @Operation(
            summary = "Updates a person",
            description = "Updates a person by passing in a JSON, XML or YML representation of the " +
                    "person",
            tags = {"People"},
            responses = {
                    @ApiResponse(
                            description = "Updated",
                            responseCode = "200",
                            content =
                            @Content(
                                    schema = @Schema(implementation =
                                            PersonDTOv1.class))
                    ),
                    @ApiResponse(
                            description = "Bad Request",
                            responseCode = "400",
                            content = @Content),
                    @ApiResponse(
                            description = "Unauthorized",
                            responseCode = "401",
                            content = @Content),
                    @ApiResponse(
                            description = "Not Found",
                            responseCode = "404",
                            content = @Content),
                    @ApiResponse(
                            description = "Internal Server Error",
                            responseCode = "500",
                            content = @Content),
            })
    public PersonDTOv1 update(@RequestBody PersonDTOv1 person){
        return personServices.update(person);
    }

    @DeleteMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON,
                        MediaType.APPLICATION_XML,
                        MediaType.APPLICATION_YAML
            })
    @Operation(
            summary = "Delete a person",
            description = "Delete a person by passing the ID",
            tags = {"People"},
            responses = {
                    @ApiResponse(
                            description = "No Content",
                            responseCode = "204",
                            content =
                            @Content
                        ),
                    @ApiResponse(
                            description = "Bad Request",
                            responseCode = "400",
                            content = @Content),
                    @ApiResponse(
                            description = "Unauthorized",
                            responseCode = "401",
                            content = @Content),
                    @ApiResponse(
                            description = "Not Found",
                            responseCode = "404",
                            content = @Content),
                    @ApiResponse(
                            description = "Internal Server Error",
                            responseCode = "500",
                            content = @Content),
            })
    public ResponseEntity<?> deleteById(@PathVariable(value = "id") Long id){
        personServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
