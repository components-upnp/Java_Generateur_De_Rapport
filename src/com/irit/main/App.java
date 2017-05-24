package com.irit.main;

import com.irit.upnp.GenerateurDeRapportServer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new Thread(new GenerateurDeRapportServer()).run();
    }
}
