package bowen.testapp;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by bowen_000 on 4/2/2016.
 */
public abstract class SingleFragmentActivity extends FragmentActivity implements SellMealFragment.OnFragmentInteractionListener{
    protected abstract Fragment createFragment();
    private Button mSellButton, mBuyButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment myFrag = fragmentManager.findFragmentById(R.id.fragment_container);


        setContentView(R.layout.activity_single_fragment);
        mSellButton = (Button) findViewById(R.id.sellButton);
        mBuyButton = (Button) findViewById(R.id.buyButton);

        mSellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment myFrag = new SellMealFragment();
                fragmentTransaction.add(R.id.fragment_container, myFrag);
                fragmentTransaction.commit();
            }
        });
        if(myFrag == null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            myFrag = createFragment();
            fragmentTransaction.add(R.id.fragment_container, myFrag);
            fragmentTransaction.commit();
        }
    }
}
