package com.mirfanrafif.koskuapp.ui.anakkos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.mirfanrafif.koskuapp.R;
import com.mirfanrafif.koskuapp.databinding.AnakKosItemBinding;
import com.mirfanrafif.koskuapp.models.AnakKos;

import java.util.List;

public class AnakKosAdapter extends RecyclerView.Adapter<AnakKosAdapter.AnakKosViewHolder> {

    private Context context;
    private List<AnakKos> anakKosList;

    public AnakKosAdapter(Context context, List<AnakKos> anakKosList) {
        this.context = context;
        this.anakKosList = anakKosList;
    }

    @NonNull
    @Override
    public AnakKosAdapter.AnakKosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        AnakKosItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.anak_kos_item, parent, false);
        return new AnakKosViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AnakKosAdapter.AnakKosViewHolder holder, int position) {
        AnakKosItemViewModel anakKosViewModel = new AnakKosItemViewModel(anakKosList.get(position));
        holder.setBinding(anakKosViewModel);
    }

    @Override
    public int getItemCount() {
        return anakKosList.size();
    }

    public class AnakKosViewHolder extends RecyclerView.ViewHolder{
        private AnakKosItemBinding binding;
        public AnakKosViewHolder(@NonNull AnakKosItemBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void setBinding(AnakKosItemViewModel viewModel) {
            this.binding.setViewModel(viewModel);
            binding.executePendingBindings();
            binding.anakKosCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(binding.getRoot().getContext(), DetailAnakKos.class);
                    intent.putExtra("EXTRA_ID", viewModel.getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}
