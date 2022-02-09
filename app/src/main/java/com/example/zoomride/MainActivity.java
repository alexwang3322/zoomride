package com.example.zoomride;

import android.app.Activity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends Activity {

    private MoveListAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainAdapter = new MoveListAdapter();

        DividerItemDecoration divider =
            new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divider.setDrawable(getDrawable(R.drawable.main_list_divider));


        RecyclerView rv = findViewById(R.id.listview);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(mMainAdapter);
        rv.addItemDecoration(divider);

        /** To simulate a internet connection */
        rv.postDelayed(new Runnable() {
            @Override
            public void run() {
                MovePOJO move = new MovePOJO();
                mMainAdapter.setData(move);
                mMainAdapter.notifyDataSetChanged();
            }
        }, 100);

    }
}