package com.issart.rig;

import com.google.gson.Gson;
import com.issart.rig.formfillers.DriverInfoFiller;
import com.issart.rig.formfillers.PaymentFormFiller;
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

        try {
            switch (args[0]){
                case "driver": {
                    Gson gson = new Gson();
                    Vehicle vehicle = new Vehicle();
                    Driver driverModel = new Driver()
                            .withAddress(args[2])
                            .withVehicle(vehicle);
                    System.out.println(args[2]);
                    DriverInfoFiller filler = new DriverInfoFiller(new LinkParser(args[1]).getLink("info"));
                    success = filler.fillTheForm(driverModel);
                    Writer writer = new FileWriter("success.json");
                    if(success.equals("{"+
                            "\"success\": true"+
                            "}")) System.out.println("Success!");
                    writer.write(success);
                    writer.close();
                    Writer writer1 = new FileWriter("driver-data.json");
                    writer1.write(gson.toJson(driverModel));
                    writer1.close();
                    break;
                }
                case "payment":{
                    PaymentDetails details = new PaymentDetails();
                    PaymentFormFiller filler = new PaymentFormFiller(new LinkParser(args[1]).getLink("payment"));
                    success = filler.fillTheForm(details);
                    Writer writer = new FileWriter("success.json");
                    if(success.equals("{"+
                            "\"success\": true"+
                            "}")) System.out.println("Success!");
                    writer.write(success);
                    writer.close();
                    break;
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
