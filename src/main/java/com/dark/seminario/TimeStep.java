package com.dark.seminario;

/**
 *
 * @author rmichel
 */
public class TimeStep {
    int count = 0;
    double power = 0;
    
    public void newStep(double power){
        count++;
        this.power += power;
    }
    
    public double getMean(){
        return power / count;
    }
}
