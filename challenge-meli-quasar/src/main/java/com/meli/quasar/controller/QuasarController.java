package com.meli.quasar.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.meli.quasar.dto.QuasarResult;
import com.meli.quasar.dto.Satellite;
import com.meli.quasar.dto.TopSecretRequest;
import com.meli.quasar.exception.QuasarException;
import com.meli.quasar.service.QuasarService;


/**
 * Controlador que provee servicios para el cumplimiento de la Operación fuego de Quasar
 * @author Dzapata
 */
@Api(value = "QuasarController: Controlador que provee servicios para el cumplimiento de la Operación fuego de Quasar" )
@Controller
@RequestMapping("/")
public class QuasarController {

    @Autowired
    QuasarService operationService;

    /**
     * Nivel 2 de la operación fuego de Quasar
     * @author Dzapata
     * @param request
     * @return
     */
    @ApiOperation(value = "Nivel 2 de la operación fuego de Quasar ", response = ResponseEntity.class, tags = "Nivel 2")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @PostMapping("/topsecret")
    public ResponseEntity<QuasarResult> topSecret(@RequestBody TopSecretRequest request) {
        try {
        	QuasarResult result = operationService.topSecret(request);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (QuasarException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    /**
     * Nivel 3 de la Operación fuego de Quasar, servicio POST
     * @author Dzapata
     * @param satelliteName
     * @param request
     * @return
     */
    @ApiOperation(value = "Nivel 3 de la Operación fuego de Quasar, servicio POST ", response = ResponseEntity.class, tags = "Nivel 3")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @PostMapping("/topsecret_split/{satellite_name}")
    public ResponseEntity<Satellite> topSecretSplit(@PathVariable("satellite_name") String satelliteName
            , @RequestBody Satellite request) {
        try {
            Satellite result = operationService.topSecretSplitPost(request, satelliteName);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (QuasarException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * Nivel 3 de la Operación fuego de Quasar, servicio GET
     * @author Dzapata
     * @return
     */
    @ApiOperation(value = "Nivel 3 de la Operación fuego de Quasar, servicio GET ", response = ResponseEntity.class, tags = "Nivel 3")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/topsecret_split")
    public ResponseEntity<QuasarResult> topSecretSplitGet() {
    	QuasarResult result;
        try {
            result = operationService.topSecretSplit();
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (QuasarException e) {
            result = new QuasarResult();
            result.setMessage("No hay suficiente información");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }

}
