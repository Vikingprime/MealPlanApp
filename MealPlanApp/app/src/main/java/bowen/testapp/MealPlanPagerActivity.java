package bowen.testapp;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by bowen_000 on 4/8/2016.
 */
public class MealPlanPagerActivity extends FragmentActivity{
    private ViewPager mViewPager;
    private ArrayList<MealPlan> mMealPlans;
    private UUID mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mId = (UUID)getIntent().getSerializableExtra(MealPlanFragment.EXTRA_MEAL_PLAN_ID);
        mMealPlans = MealPlanList.get(this).getMealPlans();
        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.pagerId);
        setContentView(mViewPager);
        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                return MealPlanFragment.newInstance(mMealPlans.get(position).getId());
            }

            @Override
            public int getCount() {
                return mMealPlans.size();
            }
        });

        for(int i=0; i<mMealPlans.size(); i++){
            if(mMealPlans.get(i).getId().equals(mId)){
                mViewPager.setCurrentItem(i);
            }
        }
    }


}
