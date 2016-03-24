package com.ruben.perez;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ruben.perez on 23/3/16.
 */
@RestController
@RequestMapping(produces = "application/json; charset=utf8")
public class AnimalService {

  @RequestMapping(value = "/alligator", method = RequestMethod.GET)
  public ResponseEntity<Alligator> getAlligator() {
    return new ResponseEntity<Alligator>(new Alligator("My alligator"), HttpStatus.OK);
  }

}
