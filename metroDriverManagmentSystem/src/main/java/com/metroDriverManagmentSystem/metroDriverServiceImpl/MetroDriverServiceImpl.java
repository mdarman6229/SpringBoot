package com.metroDriverManagmentSystem.metroDriverServiceImpl;

import com.metroDriverManagmentSystem.MetroDriverServices.MetroDriverService;
import com.metroDriverManagmentSystem.entities.MetroDriver;
import com.metroDriverManagmentSystem.metroDriverRequest.MetroDriverRequest;
import com.metroDriverManagmentSystem.metroDriverResponse.MetroDriverResponse;
import com.metroDriverManagmentSystem.repositories.MetroDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MetroDriverServiceImpl implements MetroDriverService {

    @Autowired
    private MetroDriverRepository metroDriverRepository;


    @Override
    public MetroDriverResponse addDriver(MetroDriverRequest metroDriverRequest) {

        MetroDriver metroDriver = new MetroDriver();

        metroDriver.setDriverName(metroDriverRequest.getDriverName());
        metroDriver.setMetroNo(metroDriverRequest.getMetroNo());
        metroDriver.setMetroCity(metroDriverRequest.getMetroCity());
        metroDriver.setRunningLastDate(metroDriverRequest.getMetroCity());


        MetroDriver saveDriver = metroDriverRepository.save(metroDriver);
        return mapToResponse(saveDriver);

    }


    private MetroDriverResponse mapToResponse(MetroDriver driver) {
        MetroDriverResponse response = new MetroDriverResponse();
        response.setId(driver.getId());
        response.setDriverName(driver.getDriverName());
        response.setMetroNo(driver.getMetroNo());
        response.setMetroCity(driver.getMetroCity());
        response.setRunningLastDate(driver.getRunningLastDate());
        return response;
    }
    //get all Drivers....
    @Override
    public List<MetroDriverResponse> getAllDrivers() {  // ✅ Implemented method
        List<MetroDriver> drivers = metroDriverRepository.findAll();
        return drivers.stream().map(this::mapToResponse).collect(Collectors.toList());
    }
    //get By single Driver...
    public MetroDriverResponse getDriverById(long id){
        Optional<MetroDriver> driver = metroDriverRepository.findById(id);
        return driver.map(this::mapToResponse).orElse(null);


    }




}
