package net.webuildapp.torrypubrepo.swipeit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FeedsAdapter extends  RecyclerView.Adapter<FeedsAdapter.FeedsHolder>
{
    private Context context;
    private List<Feeds> feedsList;

    public FeedsAdapter(Context ctx, List<Feeds> list)
    {
        context = ctx;
        feedsList = list;
    }

    @NonNull
    @Override
    public FeedsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_template, null);
        return new FeedsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedsHolder holder, int position)
    {
        Feeds feeds = feedsList.get(position);

        // Bind Data to View
        holder.tvtTitle.setText(feeds.getFeedTitle());
        holder.tvtContent.setText(feeds.getFeedContent());
    }

    @Override
    public int getItemCount() {
        return feedsList.size();
    }

    // ViewHolder
    static class FeedsHolder extends RecyclerView.ViewHolder
    {
        TextView tvtTitle, tvtContent;
        public FeedsHolder(View view)
        {
            super(view);

            tvtTitle = (TextView) view.findViewById(R.id.txtTitle);
            tvtContent = (TextView) view.findViewById(R.id.txtContent);
        }
    }
}
