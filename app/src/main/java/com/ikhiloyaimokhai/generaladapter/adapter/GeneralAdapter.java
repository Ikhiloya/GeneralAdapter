package com.ikhiloyaimokhai.generaladapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.ikhiloyaimokhai.generaladapter.R;
import com.ikhiloyaimokhai.generaladapter.model.GeneralModel;

import java.util.List;

import static com.ikhiloyaimokhai.generaladapter.model.Constant.GENERAL_LAYOUT_TYPE;
import static com.ikhiloyaimokhai.generaladapter.model.Constant.LAYOUT_A;
import static com.ikhiloyaimokhai.generaladapter.model.Constant.LAYOUT_A_TYPE;
import static com.ikhiloyaimokhai.generaladapter.model.Constant.LAYOUT_B;
import static com.ikhiloyaimokhai.generaladapter.model.Constant.LAYOUT_B_TYPE;
import static com.ikhiloyaimokhai.generaladapter.model.Constant.LAYOUT_C;
import static com.ikhiloyaimokhai.generaladapter.model.Constant.LAYOUT_C_TYPE;


/**
 * An adapter class that handles rendering of data in the recycler view
 * and choosing views to inflate based on the {@link GeneralModel#modelType}
 */
public class GeneralAdapter extends RecyclerView.Adapter<GeneralAdapter.ViewHolder> {
    private Context mContext;
    private List<GeneralModel> models;
    private ListItemClickListener listItemClickListener;


    /**
     * an interface to handle click events on a card
     */
    public interface ListItemClickListener {
        void onListItemClick(int adapterPosition);
    }

    public void setOnItemClickListener(ListItemClickListener listItemClickListener) {
        this.listItemClickListener = listItemClickListener;

    }


    public GeneralAdapter(Context mContext, List<GeneralModel> models) {
        this.mContext = mContext;
        this.models = models;
    }

    public GeneralAdapter(Context mContext, List<GeneralModel> models, ListItemClickListener listItemClickListener) {
        this.mContext = mContext;
        this.models = models;
        this.listItemClickListener = listItemClickListener;
    }


    private void onItemClick(ViewHolder holder) {
        if (listItemClickListener != null) {
            GeneralModel model = models.get(holder.getAdapterPosition());
            listItemClickListener.onListItemClick(holder.getAdapterPosition());
        }
    }


    @Override
    public int getItemViewType(int position) {
        String viewType = models.get(position).getModelType();
        return getItemViewType(viewType);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view;
        switch (viewType) {
            case LAYOUT_A_TYPE:
                view = layoutInflater.inflate(R.layout.layout_a, parent, false);
                return new ViewHolder(view);
            case LAYOUT_B_TYPE:
                view = layoutInflater.inflate(R.layout.layout_b, parent, false);
                return new ViewHolder(view);
            case LAYOUT_C_TYPE:
                view = layoutInflater.inflate(R.layout.layout_c, parent, false);
                return new ViewHolder(view);
            case GENERAL_LAYOUT_TYPE:
                view = layoutInflater.inflate(R.layout.layout_d, parent, false);
                return new ViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(models.get(position));
    }

    @Override
    public int getItemCount() {
        return models != null ? models.size() : 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Nullable
        private ImageView iconImageView;
        @Nullable
        private TextView titleText;

        @Nullable
        private TextView subTitleText;

        @Nullable
        private TextView dateText;


        private GeneralModel modelSelected;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconImageView = itemView.findViewById(R.id.icon);
            titleText = itemView.findViewById(R.id.title);
            subTitleText = itemView.findViewById(R.id.subTitle);
            dateText = itemView.findViewById(R.id.date);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClick(this);
        }


        public void bind(GeneralModel model) {
            modelSelected = model;
            if (iconImageView != null) iconImageView.setImageResource(model.getIcon());
            if (titleText != null) titleText.setText(model.getTitle());
            if (subTitleText != null) subTitleText.setText(model.getSubTitle());
            if (dateText != null) dateText.setText(model.getDate());
        }
    }

    private int getItemViewType(String viewType) {
        if (null == viewType || viewType.equals(LAYOUT_A)) {
            return LAYOUT_A_TYPE;
        } else if (viewType.equals(LAYOUT_B)) {
            return LAYOUT_B_TYPE;
        } else if (viewType.equals(LAYOUT_C)) {
            return LAYOUT_C_TYPE;
        } else {
            return GENERAL_LAYOUT_TYPE;
        }
    }

}
