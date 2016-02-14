package com.wordpress.priyankvex.autohangarandroid.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.felipecsl.quickreturn.library.QuickReturnAttacher;
import com.felipecsl.quickreturn.library.widget.AbsListViewScrollTarget;
import com.felipecsl.quickreturn.library.widget.QuickReturnAdapter;
import com.felipecsl.quickreturn.library.widget.QuickReturnTargetView;
import com.wordpress.priyankvex.autohangarandroid.R;
import com.wordpress.priyankvex.autohangarandroid.adapters.CategoriesListAdapter;
import com.wordpress.priyankvex.autohangarandroid.models.ServiceCategory;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewGroup quickHeaderView;
    private QuickReturnTargetView topTargetView;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public static int dpToPx(Context context, float dp) {
        // Took from http://stackoverflow.com/questions/8309354/formula-px-to-dp-dp-to-px-android
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((dp * scale) + 0.5f);
    }

    private ArrayList<ServiceCategory> getCategories(){
        ArrayList<ServiceCategory> categories = new ArrayList<>();

        ServiceCategory categoryOil = new ServiceCategory();
        categoryOil.setServiceName("Oil Change");
        categoryOil.setSeriveImageId(R.drawable.oil);
        ServiceCategory categoryTyres = new ServiceCategory();
        categoryTyres.setServiceName("Tyres");
        categoryTyres.setSeriveImageId(R.drawable.tyres);
        ServiceCategory categoryBrakes = new ServiceCategory();
        categoryBrakes.setServiceName("Brakes");
        categoryBrakes.setSeriveImageId(R.drawable.brakes);
        ServiceCategory categoryEngine = new ServiceCategory();
        categoryEngine.setServiceName("Engine");
        categoryEngine.setSeriveImageId(R.drawable.engine);
        ServiceCategory categoryWash= new ServiceCategory();
        categoryWash.setServiceName("Car Wash");
        categoryWash.setSeriveImageId(R.drawable.wash);
        ServiceCategory categoryMaintenance = new ServiceCategory();
        categoryMaintenance.setServiceName("Car Maintenance");
        categoryMaintenance.setSeriveImageId(R.drawable.maintenance);

        categories.add(categoryOil);
        categories.add(categoryTyres);
        categories.add(categoryBrakes);
        categories.add(categoryEngine);
        categories.add(categoryMaintenance);
        categories.add(categoryWash);

        return categories;
    }

    private void init(){
        quickHeaderView = (ViewGroup) findViewById(R.id.quickReturnTopTarget);
        listView = (ListView) findViewById(R.id.listViewCategories);
        CategoriesListAdapter adapter = new CategoriesListAdapter(getApplicationContext(), getCategories());
        listView.setAdapter(new QuickReturnAdapter(adapter));
        QuickReturnAttacher quickReturnAttacher = QuickReturnAttacher.forView(listView);
        topTargetView = quickReturnAttacher.addTargetView(quickHeaderView,
                AbsListViewScrollTarget.POSITION_TOP,
                dpToPx(this, 80));
        quickHeaderView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), position + " Category", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
