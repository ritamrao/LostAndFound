package com.example.lostandfound.ui.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.lostandfound.data.local.entity.CaseEntity;
import com.example.lostandfound.databinding.FragmentCreateAdvertBinding;
import com.example.lostandfound.ui.viewModels.CreateAdvertViewModel;
import com.example.lostandfound.R;
import com.example.lostandfound.ui.viewModels.OnEntitySavedListener;

public class CreateAdvertFragment extends Fragment implements OnEntitySavedListener {

    private CreateAdvertViewModel mViewModel;
    private FragmentCreateAdvertBinding binding;

    NavController navController ;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentCreateAdvertBinding.inflate(inflater);
        return binding.getRoot();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CreateAdvertViewModel.class);
        mViewModel.initiate(getContext(),this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController= NavHostFragment.findNavController(this);
        binding.AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.edTextName.getText().toString();
                String phone = binding.edTextPhone.getText().toString();
                String description = binding.edTextDescription.getText().toString();
                String date = binding.edTextDate.getText().toString();
                String location = binding.edTextLocation.getText().toString();
                int selectedRadioButtonId = binding.radioGroup.getCheckedRadioButtonId();
                String selectedRadioButtonText = "";
                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = view.findViewById(selectedRadioButtonId);
                    selectedRadioButtonText = selectedRadioButton.getText().toString();
                }
                CaseEntity entity = new CaseEntity(name,selectedRadioButtonText, phone, description, date, location);
                mViewModel.saveEntity(entity);
            }
        });
        binding.edTextDate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    DatePickerFragment datePickerFragment = new DatePickerFragment(binding.edTextDate);
                    datePickerFragment.show(requireActivity().getSupportFragmentManager(), "datePicker");
                }
                return true;
            }
        });
    }

    @Override
    public void onEntitySaved() {
        Toast.makeText(requireContext(),"saved successfully",Toast.LENGTH_SHORT).show();
        navController.popBackStack();
    }
}