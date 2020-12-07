package com.mirfanrafif.koskuapp.ui.pembayaran;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mirfanrafif.koskuapp.R;
import com.mirfanrafif.koskuapp.databinding.FragmentNotificationsBinding;

public class PembayaranFragment extends Fragment {

    private PembayaranViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(PembayaranViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        FragmentNotificationsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notifications, container, false);
        View view = binding.getRoot();

        binding.progressBar.setVisibility(View.VISIBLE);
        RecyclerView recyclerView = binding.pembayaranRv;
        notificationsViewModel.getPembayaranList().observe(getViewLifecycleOwner(), pembayarans -> {
            binding.progressBar.setVisibility(View.INVISIBLE);
            PembayaranAdapter pembayaranAdapter = new PembayaranAdapter(pembayarans, getActivity());
            pembayaranAdapter.notifyDataSetChanged();
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(pembayaranAdapter);
        });

        binding.tambahPembayaranFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TambahPembayaran.class);
                startActivity(intent);
            }
        });

        binding.setViewModel(notificationsViewModel);

        return view;
    }
}