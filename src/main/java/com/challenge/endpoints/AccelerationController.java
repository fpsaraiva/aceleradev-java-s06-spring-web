package com.challenge.endpoints;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

	@Autowired
    private AccelerationService accelerationService;
	
    @GetMapping("/{id}")
    public Optional<Acceleration> findById(@PathVariable("id") Long id) {
        return accelerationService.findById(id);
    }

    @GetMapping
    public Iterable<Acceleration> findAll(@PathParam("companyId") Long companyId) {
        return  accelerationService.findByCompanyId(companyId);
    }	
}