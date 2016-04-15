package bowen.testapp;

import android.content.Context;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by bowen_000 on 4/2/2016.
 */
public class MealPlanList {
    private ArrayList<MealPlan> mMealPlans;
    private static MealPlanList sMealPlanList;
    private Context mAppContext;

    private MealPlanList(Context appContext){
        mAppContext = appContext;
        mMealPlans = new ArrayList<MealPlan>();
        for(int i=0; i<100; i++) {
            MealPlan d = new MealPlan();
            d.setPrice(Math.random() * 3 + 5);
            d.setSomeBoolean((i%2) == 0);
            mMealPlans.add(d);
        }
    }

    public static MealPlanList get(Context c){
        if(sMealPlanList == null){
            sMealPlanList = new MealPlanList(c.getApplicationContext());
        }
        return sMealPlanList;
    }

    public MealPlan getMealPlan(UUID id){
        for(MealPlan m: mMealPlans){
            if(m.getId().equals(id)){
                return m;
            }
        }
        return null;
    }

    public ArrayList<MealPlan> getMealPlans(){
        return mMealPlans;
    }
}
