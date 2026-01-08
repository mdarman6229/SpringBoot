package com.metroDriverManagmentSystem.MetroDriverServices;


import com.metroDriverManagmentSystem.metroDriverRequest.MetroDriverRequest;
import com.metroDriverManagmentSystem.metroDriverResponse.MetroDriverResponse;

import java.util.List;

public interface MetroDriverService {

    MetroDriverResponse addDriver(MetroDriverRequest metroDriverRequest);
    List<MetroDriverResponse> getAllDrivers();
    MetroDriverResponse getDriverById(long id);

}
