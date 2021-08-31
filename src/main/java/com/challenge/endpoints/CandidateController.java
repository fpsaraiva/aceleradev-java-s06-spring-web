package com.challenge.endpoints;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Candidate;
import com.challenge.service.impl.CandidateService;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
	
    @Autowired
    private CandidateService candidateService;

    @GetMapping("/{userId}/{accelerationId}/{companyId}")
    public Optional<Candidate> findById(@PathVariable("userId") Long userId,
                                        @PathVariable("accelerationId") Long accelerationId,
                                        @PathVariable("companyId") Long companyId) {
        return candidateService.findById(userId, companyId, accelerationId);
    }

    @GetMapping
    public Iterable<Candidate> findAll(@PathParam("companyId") Long companyId) {
        return candidateService.findByCompanyId(companyId);
    }
}