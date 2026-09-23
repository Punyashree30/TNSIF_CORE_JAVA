package com.admin.AdminModule;

import java.util.List;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AdminService 
{
    @Autowired
    private AdminRepository repo;

    public List<Admin> listAll() 
    {
        return repo.findAll();
    }

    public Admin save(Admin admin) 
    {
        return repo.save(admin);
    }

    public Admin get(Integer id) 
    {
        return repo.findById(id).get();
    }

    public Admin delete(Integer id) 
    {
        Admin admin = repo.findById(id).get();
        repo.deleteById(id);
        return admin;
    }
}