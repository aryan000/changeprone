/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changeprone;

/**
 *
 * @author aryan_000
 */
public class PatternMatch {
    
    public static void main(String s[])
    {
        System.out.println("herllo world");
        
        String str = "digital.my.world";
        String pattern = "rld";
        
        System.out.println( str.matches(".*"+pattern));
        
        
        String s1  = "retrofit.client.ApacheClient.GenericHttpRequest";
        String s2 = "retrofit.client.Request";
        String p = "Request";
        
        System.out.println(s1.matches(".*.\\."+p));
        System.out.println(s2.matches(".*.\\."+p));
        
        

        
    }
}
