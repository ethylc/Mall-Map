package com.example.ethyl.mallmapproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ethyl on 2017-11-23.
 */

public class SearchActivity extends AppCompatActivity{
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Store> storeArrayList;
    StoreAdapter adapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            storeArrayList = null;
        } else {
            storeArrayList = extras.getParcelableArrayList("STORES");
        }
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new StoreAdapter();
        mRecyclerView.setAdapter(adapter);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_bar, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!searchView.isIconified()){
                    searchView.setIconified(true);
                }
                searchItem.collapseActionView();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                newText = newText.toLowerCase();
                final ArrayList<Store> filteredModeList = new ArrayList<>();
                for (Store model:storeArrayList){
                    final String text = model.getStore().toLowerCase();
                    if (text.startsWith(newText)){
                        filteredModeList.add(model);
                    }
                }
                adapter.setFilter(filteredModeList);
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    TaskStackBuilder.create(this).addNextIntentWithParentStack(upIntent).startActivities();
                } else {
                    upIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(upIntent);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class StoreAdapter extends RecyclerView.Adapter{
        private ArrayList<Store> listCopy = storeArrayList;
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_item,parent,false);
            return new Holderview(layout);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((Holderview) holder).setView(position);
        }

        @Override
        public int getItemCount() {
            return listCopy.size();
        }

        public void setFilter(List<Store> listItem){
            listCopy = new ArrayList<>();
            listCopy.addAll(listItem);
            notifyDataSetChanged();
        }
        private class Holderview extends RecyclerView.ViewHolder implements View.OnClickListener{
            private TextView mText;
            private int aPosition;

            public Holderview(View itemView) {
                super(itemView);
                mText = (TextView)itemView.findViewById(R.id.itemStore);
                itemView.setOnClickListener(this);
            }

            public void setView(int p){
                mText.setText(listCopy.get(p).getStore());
                aPosition = p;
            }
            public void onClick(View v){
                Intent intent = new Intent();
                intent.putExtra("STORE_NAME", listCopy.get(aPosition));
                setResult(RESULT_OK,intent);
                finish();
            }
        }
    }
}
