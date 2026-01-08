package com.Test1;

import Entities.Jio;
import MobileImpl.Sim;

public class Mobile {
    public static void main(String[] args) {

        Sim sim=new Jio();
        sim.calling();
        sim.data();
    }
}
