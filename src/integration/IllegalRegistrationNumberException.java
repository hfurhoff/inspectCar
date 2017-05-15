/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import dto.VehicleDTO;

/**
 *
 * @author Coyote
 */
public class IllegalRegistrationNumberException extends RuntimeException {

    private final VehicleDTO vehicleWithIllegalRegNo;
    
    public IllegalRegistrationNumberException(VehicleDTO vehicle) {
        super("The registraion number " + vehicle.getRegNo() + " is invalid.");
        this.vehicleWithIllegalRegNo = vehicle;
    }
    
}
