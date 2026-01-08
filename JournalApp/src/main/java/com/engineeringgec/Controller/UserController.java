package com.engineeringgec.Controller;

import com.engineeringgec.Entity.JournalEntry;
import com.engineeringgec.Entity.User;
import com.engineeringgec.Services.JournalEntryService;
import com.engineeringgec.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping("{userName}")
    public ResponseEntity<?> getAllJournalEntriesofUsers(@PathVariable String userName){
        User user=userService.findByUserName(userName);
           List<JournalEntry> all= user.getJournalEntries();
           if(all!=null && !all.isEmpty()){
               return new ResponseEntity<>(all,HttpStatus.OK);
           }else {
               return new ResponseEntity<>(all,HttpStatus.NO_CONTENT);
           }

    }

    @PostMapping("{userName}")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry,String userName){
        try {
            User user = userService.findByUserName(userName);
            journalEntryService.saveEntry(myEntry,userName);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(myEntry,HttpStatus.BAD_REQUEST);
        }


    }

    @PutMapping("/{userName}")
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable String userName){
        User userInDb=userService.findByUserName(userName);
        if(userInDb!=null){
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveEntry(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
    //Controller----->Service------>Repository



