package com.admin.AdminModule;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController 
{
    @Autowired
    private AdminService service;

    @GetMapping("/admins")
    public List<Admin> list() 
    {
        return service.listAll();
    }

    @GetMapping("/admins/{id}")
    public ResponseEntity<Admin> get(@PathVariable Integer id) 
    {
        try
        {
            Admin admin = service.get(id);
            return new ResponseEntity<Admin>(admin, HttpStatus.OK);
        } 
        catch (NoSuchElementException e) 
        {
            return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
        } 
    }

    @PostMapping("/admins")
    public ResponseEntity<Admin> add(@RequestBody Admin admin) 
    {
        Admin saved = service.save(admin);
        return new ResponseEntity<Admin>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/admins/{id}")
    public ResponseEntity<Admin> update(@RequestBody Admin admin, @PathVariable Integer id) 
    {
        try
        {
            Admin existAdmin = service.get(id);
            admin.setId(id);
            Admin updated = service.save(admin);
            return new ResponseEntity<Admin>(updated, HttpStatus.OK);
        } 
        catch (NoSuchElementException e) 
        {
            return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
        } 
    }

    @DeleteMapping("/admins/{id}")
    public ResponseEntity<Admin> delete(@PathVariable Integer id) 
    {
        try
        {
            Admin deleted = service.delete(id);
            return new ResponseEntity<Admin>(deleted, HttpStatus.OK);
        } 
        catch (NoSuchElementException e) 
        {
            return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
        } 
    }
}