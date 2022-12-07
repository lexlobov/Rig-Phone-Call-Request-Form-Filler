package com.issart.rig;

import com.google.gson.Gson;
import com.issart.rig.model.Driver;
import com.issart.rig.model.PaymentDetails;
import com.issart.rig.model.Vehicle;
import com.issart.rig.parser.LinkParser;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Main {

    public static void main(String[] args) {
        String argumentsErrorMessage = "Incorrect arguments. Start program with <\"driver\" \"phone_number\" \"longitude\" \"latitude\"> for filling info form \n " +
                "or with <\"payment\" \"phone_number\"> for filling payment info";
        String success = null;

        if (args.length<2){
            System.out.println(argumentsErrorMessage);
        } else {
            try {
                switch (args[0]){
                    case "driver": {
                        Gson gson = new Gson();
                        Vehicle vehicle = new Vehicle();
                        Driver driverModel = new Driver()
                                .withLongitude(args[2])
                                .withLatitude(args[3])
                                .withVehicle(vehicle);

                        DriverInfoFiller filler = new DriverInfoFiller(new LinkParser(args[1]).getLink());
                        success = filler.fillTheForm(driverModel);
                        Writer writer = new FileWriter("success.json");
                        writer.write(success);
                        writer.close();
                        Writer writer1 = new FileWriter("driver-data.json");
                        writer1.write(gson.toJson(driverModel));
                        writer1.close();
                    }
                    case "payment":{
                        PaymentDetails details = new PaymentDetails();

                    }
                    default:
                        System.out.println(argumentsErrorMessage);
                }
            } catch (IndexOutOfBoundsException e){
                System.out.println(argumentsErrorMessage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
