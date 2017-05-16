/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import dto.VehicleDTO;

/**
 * This exception is thrown when the inspector has tried to enter an illegal registration number.
 * @author Coyote
 */
public class NonValidRegistrationNumberException extends RuntimeException {

    private final VehicleDTO vehicleWithIllegalRegNo;
    
    /**
     * Creates an exception with information about what vehicle caused it and a message.
     * @param vehicle The vehicle that was the reason for the exception to be thrown.
     */
    public NonValidRegistrationNumberException(VehicleDTO vehicle) {
        super("The registraion number " + vehicle.getRegNo() + " is invalid.");
        this.vehicleWithIllegalRegNo = vehicle;
    }
    
}
