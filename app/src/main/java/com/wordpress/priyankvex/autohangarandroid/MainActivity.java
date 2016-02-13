package com.wordpress.priyankvex.autohangarandroid;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.felipecsl.quickreturn.library.QuickReturnAttacher;
import com.felipecsl.quickreturn.library.widget.AbsListViewScrollTarget;
import com.felipecsl.quickreturn.library.widget.QuickReturnAdapter;
import com.felipecsl.quickreturn.library.widget.QuickReturnTargetView;
import com.wordpress.priyankvex.autohangarandroid.adapters.CategoriesListAdapter;
import com.wordpress.priyankvex.autohangarandroid.models.ServiceCategory;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView topTextView;
    private QuickReturnTargetView topTargetView;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_logo);
        setSupportActionBar(toolbar);
        topTextView = (TextView) findViewById(R.id.quickReturnTopTarget);
        listView = (ListView) findViewById(R.id.listViewCategories);

        CategoriesListAdapter adapter = new CategoriesListAdapter(getApplicationContext(), getCategories());
        listView.setAdapter(new QuickReturnAdapter(adapter));
        QuickReturnAttacher quickReturnAttacher = QuickReturnAttacher.forView(listView);
        topTargetView = quickReturnAttacher.addTargetView(topTextView,
                AbsListViewScrollTarget.POSITION_TOP,
                dpToPx(this, 50));

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

        ServiceCategory category = new ServiceCategory();
        category.setServiceName("Oil Change");
        category.setSeriveImageId(R.drawable.oil);

        categories.add(category);
        categories.add(category);
        categories.add(category);
        categories.add(category);
        categories.add(category);
        categories.add(category);
        categories.add(category);
        categories.add(category);
        categories.add(category);
        categories.add(category);
        categories.add(category);
        categories.add(category);
        categories.add(category);

        return categories;
    }
}
