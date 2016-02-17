package com.wordpress.priyankvex.autohangarandroid.activities;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.wordpress.priyankvex.autohangarandroid.R;
import com.wordpress.priyankvex.autohangarandroid.adapters.ServiceProvidersListAdapter;
import com.wordpress.priyankvex.autohangarandroid.models.ServiceProvider;
import com.wordpress.priyankvex.autohangarandroid.seed.ServiceProviderSeed;

import java.util.ArrayList;

/**
 * Created by @priyankvex on 16/2/16.
 * Activity to search for service providers.
 */
public class SearchActivity extends AppCompatActivity{

    private SearchView searchView;
    private ListView listview;
    private ArrayList<ServiceProvider> mServiceProviders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mServiceProviders = ServiceProviderSeed.getServiceProviders();
        listview = (ListView) findViewById(R.id.listViewSearchResults);
        ServiceProvidersListAdapter adapter = new ServiceProvidersListAdapter(getApplicationContext(), mServiceProviders);
        listview.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        searchItem.expandActionView();
        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setIconified(false);
        initSearchView();
        return true;
    }

    private void initSearchView(){
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("test", query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

}
