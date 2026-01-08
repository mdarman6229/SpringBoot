package com.metroDriverManagmentSystem.metroDriverController;

import com.metroDriverManagmentSystem.MetroDriverServices.MetroDriverService;
import com.metroDriverManagmentSystem.entities.MetroDriver;
import com.metroDriverManagmentSystem.metroDriverRequest.MetroDriverRequest;
import com.metroDriverManagmentSystem.metroDriverResponse.MetroDriverResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class AddDriverController {


    @Autowired
    private MetroDriverService metroDriverService;


    @PostMapping("/addDriver")
    public MetroDriverResponse addDriver(@RequestBody MetroDriverRequest metroDriverRequest){
        return metroDriverService.addDriver(metroDriverRequest);

    }
    @GetMapping("/getAllDrivers")
    public List<MetroDriverResponse> getAllDrivers(){
        return metroDriverService.getAllDrivers();
    }
    //by single id...
    @GetMapping("/getSingleDriver")
    public MetroDriverResponse getResponseById(@RequestParam("id") Long id){
        return this.metroDriverService.getDriverById(id);
    }

    //update


    // delete

    



}
