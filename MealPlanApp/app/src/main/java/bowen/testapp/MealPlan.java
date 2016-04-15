package bowen.testapp;

import java.util.Date;
import java.util.UUID;

/**
 * Created by bowen_000 on 4/2/2016.
 */
public class MealPlan {
    private UUID id;
    private String name;
    private Date listingDate;
    private boolean someBoolean;
    private double price;

    MealPlan(){
        name = "Name";
        listingDate = new Date();
        double price = 8.00;
        someBoolean = true;
        id = UUID.randomUUID();
    }

    public UUID getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    public Date getListingDate(){
        return listingDate;
    }

    public void setSomeBoolean(boolean b){
        someBoolean = b;
    }

    public boolean getSomeBoolean(){
        return someBoolean;
    }

    public void setPrice(double d){
        double val = d;
        val = val * 100;
        val = Math.round(val);
        val = val / 100;
        price = val;
    }

    public double getPrice(){
        return price;
    }

    @Override
    public String toString(){
        return "Price: " + getPrice() + " Boolean: " + getSomeBoolean();
    }
}
