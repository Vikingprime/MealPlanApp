package bowen.testapp;


import android.net.Uri;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class MealPlanActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        UUID mealPlanId = (UUID)getIntent().getSerializableExtra(MealPlanFragment.EXTRA_MEAL_PLAN_ID);
        return MealPlanFragment.newInstance(mealPlanId);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
