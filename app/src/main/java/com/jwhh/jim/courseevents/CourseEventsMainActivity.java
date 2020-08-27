package com.jwhh.jim.courseevents;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class CourseEventsMainActivity extends AppCompatActivity
        implements EventDisplayCallbacks {

    ArrayList<String> mCourseEvents;
    ArrayAdapter<String> mCourseEventsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_events_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupListView();


    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

    protected void setupListView() {
        mCourseEvents = new ArrayList<>();
        mCourseEventsAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mCourseEvents);

        final ListView listView = findViewById(R.id.list_course_events);
        listView.setAdapter(mCourseEventsAdapter);
    }

    @Override
    public void onEventReceived(String eventMessage) {
        if(eventMessage != null) {
            mCourseEvents.add(eventMessage);
            mCourseEventsAdapter.notifyDataSetChanged();
        }
    }

}
