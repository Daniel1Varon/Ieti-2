package ieti2.controller;

import ieti2.dto.UserDto;
import ieti2.repository.UserDocument;
import ieti2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/user" )
public class UserController {
    private final UserService userService;

    public UserController( @Autowired UserService userService )
    {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<List<UserDocument>> all()
    {
        return ResponseEntity.ok( userService.all() );
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<UserDocument> findById( @PathVariable String id )
    {
        return ResponseEntity.ok( userService.findById( id ) );
    }


    @PostMapping
    public ResponseEntity<UserDocument> create( @RequestBody UserDto userDto )
    {
        return ResponseEntity.ok( userService.create( new UserDocument( userDto ) ) );
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<UserDocument> update( @RequestBody UserDto userDto, @PathVariable String id )
    {
        return ResponseEntity.ok( userService.update( userDto, id ) );
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id )
    {
        return ResponseEntity.ok( userService.deleteById( id ) );
    }
}
