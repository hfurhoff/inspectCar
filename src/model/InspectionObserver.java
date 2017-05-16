/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * An interface for observer classes observing the inspectionclass.
 * @author Coyote
 */
public interface InspectionObserver {
    
    /**
     * A method to notify the observer that a new result is in.
     * @param passed The result of the inspection.
     */
    public void newResult(boolean passed);
}
