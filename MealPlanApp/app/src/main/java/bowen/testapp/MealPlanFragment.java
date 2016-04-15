package bowen.testapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by bowen_000 on 4/1/2016.
 */
public class MealPlanFragment extends android.support.v4.app.Fragment {

    public static final String EXTRA_MEAL_PLAN_ID = "meal_plan_id";

    private Button mBuyButton;
    private TextView mNameText;
    private TextView mPriceText;
    private CheckBox mCheckBox;
    private String returnMessage;
    private MealPlan mMealPlan;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        UUID mealPlanID = (UUID)getArguments().getSerializable(EXTRA_MEAL_PLAN_ID);
        mMealPlan = MealPlanList.get(getActivity()).getMealPlan(mealPlanID);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_meal_plan, container, false);
//        UUID mealPlanId = (UUID)getActivity().getIntent().getSerializableExtra(MealPlanFragment.EXTRA_MEAL_PLAN_ID);
//        MealPlan mMealPlan = MealPlanList.get(getActivity()).getMealPlan(mealPlanId);
        mNameText = (TextView)v.findViewById(R.id.fragment_meal_plan_name);
        mNameText.setText(mMealPlan.getName());
        mPriceText = (TextView)v.findViewById(R.id.fragment_meal_plan_price);
        mPriceText.setText("Price: "+ mMealPlan.getPrice());
        mBuyButton = (Button) v.findViewById(R.id.fragment_meal_plan_buy_button);
        mCheckBox = (CheckBox)v.findViewById(R.id.fragment_meal_plan_check_box);
        mCheckBox.setChecked(mMealPlan.getSomeBoolean());
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mMealPlan.setSomeBoolean(isChecked);
            }
        });
        mBuyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(getActivity(), MessageDisplayActivity.class);
//                String message = mEditText.getText().toString();
//                i.putExtra(MessageDisplayActivity.EXTRA_MESSAGE, message);
//                startActivityForResult(i, 0);
            }
        });
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(data == null){
            return;
        }
        returnMessage = data.getStringExtra(MessageDisplayActivity.EXTRA_RETURN);
//        mEditText.setText(returnMessage);
    }

    public static MealPlanFragment newInstance(UUID mealPlanId){
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_MEAL_PLAN_ID, mealPlanId);
        MealPlanFragment fragment = new MealPlanFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
