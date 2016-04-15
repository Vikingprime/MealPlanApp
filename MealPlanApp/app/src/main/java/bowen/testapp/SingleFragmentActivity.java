package bowen.testapp;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by bowen_000 on 4/2/2016.
 */
public abstract class SingleFragmentActivity extends FragmentActivity{
    protected abstract Fragment createFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment myFrag = fragmentManager.findFragmentById(R.id.fragment_container);
        if(myFrag == null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            myFrag = createFragment();
            fragmentTransaction.add(R.id.fragment_container, myFrag);
            fragmentTransaction.commit();
        }
    }
}
