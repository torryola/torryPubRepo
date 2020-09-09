package net.webuildapp.torrypubrepo.swipeit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.wifi.hotspot2.pps.Credential;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private static List<Feeds> feedsList;
    private static List<Feeds> achievedList = new ArrayList<>();
    private ItemTouchHelper swipeTouch_Helper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.feed_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        // Initialize Adapter
        final FeedsAdapter feedsAdapter = new FeedsAdapter(this, loadSampleData());
        // Set Adapter
        recyclerView.setAdapter(feedsAdapter);
        // Set RecyclerView Layout
        recyclerView.setLayoutManager(linearLayoutManager);

        // Animate RecyclerView
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        recyclerView.setItemAnimator(itemAnimator);

        // Add the direction of the swipe and Handle the Swipe in onSwipe
        // 1st arg is for Drag-and-Drop, set to 0 if not handled.
        swipeTouch_Helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.DOWN | ItemTouchHelper.UP
                | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT)
        {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder origin,
                                  @NonNull RecyclerView.ViewHolder target)
            {
                // Get The Original Index
                int from = origin.getAdapterPosition();
                // Get the Target Index
                int to = target.getAdapterPosition();
                // Swap the Data in the List
                Collections.swap(feedsList, from, to);
                // Notify the Adapter of the Change
                feedsAdapter.notifyItemMoved(from, to);
                Toast.makeText(MainActivity.this, "Item Moved From : "+(from+1)+" To :"+(to+1), Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction)
            {
                int position  = viewHolder.getAdapterPosition();
                if (direction == ItemTouchHelper.RIGHT)
                {
                    Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                    // Delete Item on Swipe Right
                    feedsList.remove(position);
                }
                else if (direction == ItemTouchHelper.LEFT)
                {
                    // Achieve it
                    achievedList.add(feedsList.get(position));
                    // remove from list
                    feedsList.remove(position);
                    Toast.makeText(MainActivity.this, "Achieved Size : "+achievedList.size(), Toast.LENGTH_SHORT).show();
                }
                // Notify Adapter of the Changes
                feedsAdapter.notifyItemRemoved(position);

            }
        });

        // Attache Touch Helper to RecyclerView for responding swipe event
        swipeTouch_Helper.attachToRecyclerView(recyclerView);

    }

    private static List<Feeds> loadSampleData()
    {
        feedsList = new ArrayList<>();
        Feeds feeds = new Feeds("AWS Tutorial","AWS Cloud Fundamental", new Date().toString());
        Feeds feeds1 = new Feeds("Azure Cloud","Azure Cloud Essential", new Date().toString());
        Feeds feeds2 = new Feeds("GCP","GCP Cloud Fundamental", new Date().toString());


        feedsList.add(feeds);
        feedsList.add(feeds1);
        feedsList.add(feeds2);

        feedsList.add(feeds);
        feedsList.add(feeds1);
        feedsList.add(feeds2);
        feedsList.add(feeds);
        feedsList.add(feeds1);
        feedsList.add(feeds2);

        return feedsList;
    }
}