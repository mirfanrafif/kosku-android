package com.mirfanrafif.koskuapp.ui.anakkos;

import android.content.Intent;
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

public class AnakKosFragment extends Fragment {

    private AnakKosAdapter anakKosAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AnakKosViewModel anakKosViewModel =
                ViewModelProviders.of(this).get(AnakKosViewModel.class);
        FragmentDashboardBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_dashboard, container, false);
        View view = binding.getRoot();
        RecyclerView anakKosRv = view.findViewById(R.id.anakKosRv);
        anakKosViewModel.setVisibility(binding.progressBar, true);

        anakKosViewModel.getListAnakKos().observe(getViewLifecycleOwner(), anakKos -> {
            anakKosViewModel.setVisibility(binding.progressBar, false);
            anakKosAdapter = new AnakKosAdapter(getActivity(), anakKos);
            anakKosAdapter.notifyDataSetChanged();
            anakKosRv.setLayoutManager(new LinearLayoutManager(getContext()));
            anakKosRv.setAdapter(anakKosAdapter);
            Log.d("DashboardFragment", "Uda lewat sini lho");
        });
        binding.setViewModel(anakKosViewModel);

        binding.tambahDataFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), TambahAnakKos.class);
                startActivity(intent);
            }
        });

        return view;
    }
}