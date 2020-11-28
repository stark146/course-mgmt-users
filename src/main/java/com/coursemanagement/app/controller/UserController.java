package com.coursemanagement.app.controller;

import com.coursemanagement.app.model.Role;
import com.coursemanagement.app.model.Users;
import com.coursemanagement.app.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/registration")
    public ResponseEntity<?> saveUsers(@RequestBody Users users){
        if(usersService.findByUserName(users.getUsername()) != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        //Default Role - User
        users.setRole(Role.USER);
        return new ResponseEntity<>(usersService.saveUser(users), HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity<?> getUser(Principal principal){
       // Principal principal = request.getUserPrincipal();
        if(principal == null || principal.getName() == null){
            //This means logout will be successful. login?logout
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return ResponseEntity.ok(usersService.findByUserName(principal.getName()));
    }

    @PostMapping("/names")
    public ResponseEntity<?> getNamesOfUsers(@RequestBody List<Long> idList){
        return ResponseEntity.ok(usersService.findUserNamesByIdList(idList));
    }

    @GetMapping("/test")
    public ResponseEntity<?> test(){
        return ResponseEntity.ok("test url");
    }
}
