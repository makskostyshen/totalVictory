package com.makskostyshen;

import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import jakarta.inject.Singleton;

import java.io.*;
import java.util.Scanner;

@Singleton
public class OnEventListener {

    @EventListener
    void onStartup(ServerStartupEvent event) {
        try {
            File myObj = new File("username.csv");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter("username.csv", true));
            writer.write("\nsmith79;5079;Jamie;Smith");
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
