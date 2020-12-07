package com.mirfanrafif.koskuapp.ui.pembayaran;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.mirfanrafif.koskuapp.R;
import com.mirfanrafif.koskuapp.databinding.PembayaranItemBinding;
import com.mirfanrafif.koskuapp.models.Pembayaran;
import java.util.List;

public class PembayaranAdapter extends RecyclerView.Adapter<PembayaranAdapter.PembayaranViewHolder> {

    private List<Pembayaran> pembayaranList;
    private Context context;

    public PembayaranAdapter(List<Pembayaran> pembayaranList, Context context) {
        this.pembayaranList = pembayaranList;
        this.context = context;
    }

    @NonNull
    @Override
    public PembayaranAdapter.PembayaranViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        PembayaranItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.pembayaran_item, parent, false);
        return new PembayaranViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PembayaranAdapter.PembayaranViewHolder holder, int position) {
        PembayaranItemViewModel viewModel = new PembayaranItemViewModel(pembayaranList.get(position));
        holder.bind(viewModel);
    }

    @Override
    public int getItemCount() {
        return pembayaranList.size();
    }

    public class PembayaranViewHolder extends RecyclerView.ViewHolder {
        PembayaranItemBinding binding;
        public PembayaranViewHolder(@NonNull PembayaranItemBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void bind(PembayaranItemViewModel viewModel) {
            this.binding.setViewModel(viewModel);
            binding.pembayaranCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailPembayaran.class);
                    intent.putExtra("EXTRA_ID", viewModel.getId().getValue());
                    context.startActivity(intent);
                }
            });
        }
    }
}
