package com.example.projectchuyende.ui.timekeeping;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.projectchuyende.R;


import java.util.ArrayList;


public class timekeeping extends Fragment {
    ListView lv_timeKeeping;
    ArrayList<String> datatimeKeeping = new ArrayList<>();
    ArrayAdapter TimeKeepingadapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_timekeeping, container, false);
        lv_timeKeeping = root.findViewById(R.id.lv_timeKeeping);

        setEvent();
        return root;

    }

    private void setEvent() {
        TimeKeepingadapter = new ArrayAdapter(getContext(), R.layout.show_timekeeping, datatimeKeeping);
        lv_timeKeeping.setAdapter(TimeKeepingadapter);
    }


}