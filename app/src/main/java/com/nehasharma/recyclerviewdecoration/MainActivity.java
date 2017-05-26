package com.nehasharma.recyclerviewdecoration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recview;
    private adapter rvadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recview = (RecyclerView)findViewById(R.id.rvContacts);
        recview.setLayoutManager(new LinearLayoutManager(this));
        rvadapter = new
                adapter(data.getListData(), this);

        recview.setAdapter(rvadapter);

        //Add ItemDecoration to recyclerview
        recview.addItemDecoration(new RVItemDecoration(this));

    }
}
