package com.mirfanrafif.koskuapp.ui.AnakKos;

import android.os.Bundle;
import android.util.Log;
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
import com.mirfanrafif.koskuapp.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private AnakKosAdapter anakKosAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        FragmentDashboardBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_dashboard, container, false);
        View view = binding.getRoot();
        RecyclerView anakKosRv = view.findViewById(R.id.anakKosRv);
        dashboardViewModel.setVisibility(binding.progressBar, true);

        dashboardViewModel.getListAnakKos().observe(getViewLifecycleOwner(), anakKos -> {
            dashboardViewModel.setVisibility(binding.progressBar, false);
            anakKosAdapter = new AnakKosAdapter(getActivity(), anakKos);
            anakKosAdapter.notifyDataSetChanged();
            anakKosRv.setLayoutManager(new LinearLayoutManager(getContext()));
            anakKosRv.setAdapter(anakKosAdapter);
            Log.d("DashboardFragment", "Uda lewat sini lho");
        });
        binding.setViewModel(dashboardViewModel);

        return view;
    }
}