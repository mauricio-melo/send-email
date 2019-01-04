package io.sysmap.m2m.sendmail.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.sysmap.m2m.sendmail.domain.Email;
import io.sysmap.m2m.sendmail.domain.Response;
import io.sysmap.m2m.sendmail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/email")
@Api(value = "Email", description = "Operations available for email.")
public class EmailResource {

    @Autowired
    private EmailService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Creating a new resource", responseReference = "New resource created.")
    public ResponseEntity<Void> create(@Valid @RequestBody final Email email) {

        try {
            service.serviceSendMail(email);
        } catch (MessagingException ex) {

        }


        return ResponseEntity.ok().build();
    }

}
