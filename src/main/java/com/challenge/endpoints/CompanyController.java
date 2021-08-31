package com.challenge.endpoints;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;



@RestController
@RequestMapping("/company")
public class CompanyController {
	
    @Autowired
    private CompanyService companyService;

    @GetMapping("/{id}")
    public ResponseEntity<Company> findCompany(@PathVariable("id") Long id) {
        Optional<Company> company = this.companyService.findById(id);
        return company.isPresent() ? ResponseEntity.ok(company.get()) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Company> listByAccelerationIdOrUserId(
            @RequestParam(required = false) Long accelerationId,
            @RequestParam(required = false) Long userId
    ){
        if (accelerationId != null) return companyService.findByAccelerationId(accelerationId);
        if (userId != null) return companyService.findByUserId(userId);

        return Collections.emptyList();
    }
}
