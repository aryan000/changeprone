/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import changeprone.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author aryan_000
 */


class TachAndChd
{
    
       int tach ;
       double chd;
       
    
    TachAndChd(int tach , double chd)
    {
        this.tach = tach;
        this.chd = chd;
    }
    
    int getTach()
    {
        return tach;
    }
    
    double getChd()
    {
        return chd;
    }
}

public class LcaAndLcd {
    
    /**
     *
     */
    public final static ArrayList<HashMap<String,TachAndChd>> lcaandlcd = new ArrayList<>();
        static int curr_version  = 0;
        
        

    
}

