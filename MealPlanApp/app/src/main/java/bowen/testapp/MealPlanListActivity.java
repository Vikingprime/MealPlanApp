package bowen.testapp;

import android.support.v4.app.Fragment;

/**
 * Created by bowen_000 on 4/2/2016.
 */
public class MealPlanListActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment(){
        return new MealPlanListFragment();
    }
}
