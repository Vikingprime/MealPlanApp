package bowen.testapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by bowen_000 on 4/2/2016.
 */
public class MealPlanListFragment extends ListFragment {
    private ArrayList<MealPlan> mMealPlans;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mMealPlans = MealPlanList.get(getActivity()).getMealPlans();
        MealPlanAdapter adapter = new MealPlanAdapter(mMealPlans);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        MealPlan d = (MealPlan)getListAdapter().getItem(position);
        Intent i = new Intent(getActivity(),MealPlanPagerActivity.class);
        i.putExtra(MealPlanFragment.EXTRA_MEAL_PLAN_ID, d.getId());
        startActivity(i);
    }

    @Override
    public void onResume(){
        super.onResume();
        ((MealPlanAdapter)getListAdapter()).notifyDataSetChanged();
    }

    private class MealPlanAdapter extends ArrayAdapter<MealPlan>{
        public MealPlanAdapter(ArrayList<MealPlan> mealPlans){
            super(getActivity(), 0, mealPlans);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_meal_plan, null);
            }
            final MealPlan m = getItem(position);
            TextView priceTextView = (TextView)convertView.findViewById(R.id.list_price);
            priceTextView.setText("Price: " + m.getPrice());
            TextView dateTextView = (TextView)convertView.findViewById(R.id.list_date);
            dateTextView.setText(m.getListingDate().toString());
            final CheckBox checkBox = (CheckBox)convertView.findViewById(R.id.list_check_box);
            checkBox.setChecked(m.getSomeBoolean());
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    m.setSomeBoolean(checkBox.isChecked());
                }
            });
            return convertView;
        }
    }
}
