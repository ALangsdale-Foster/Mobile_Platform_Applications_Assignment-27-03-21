package com.example.mpa_app;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FirstFragment extends android.app.Fragment {
    View view;
    ListView heroListView;
    ArrayAdapter<String> listAdapter;
    Context ctx;


    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Map<String, Object> hero = new HashMap<>();
    CollectionReference heroes = db.collection("heroes");

    ArrayList<String> nameList = new ArrayList<String>();
    ArrayList<Double> pickList = new ArrayList<Double>();
    ArrayList<Double> winList = new ArrayList<Double>();
    ArrayList<String> roleList = new ArrayList<String>();

    String heroName;
    Double pickRate;
    Double winRate;

    public interface OnHeadlineSelectedListener {
        public void onArticleSelected(int position);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ctx = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_first, container, false);
        heroListView = (ListView) view.findViewById(R.id.heroListView);

        db.collection("heroes")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                //Log.d("tag", document.getId() + " => " + document.getData());
                                heroName = document.getId();
                                nameList.add(heroName);

                                pickRate = document.getDouble("pickrate");
                                pickList.add(pickRate);

                                winRate = document.getDouble("winrate");
                                winList.add(winRate);
                                Log.d("tag", heroName + " pick rate: " + pickRate + " win rate: " + winRate);
                                //Create array adapter
                                listAdapter = new ArrayAdapter<String>(ctx, R.layout.single_list_item, nameList);

                                heroListView.setAdapter(listAdapter);

                                heroListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        String heroSelected = nameList.get(i).toString();
                                        OnePlayerActivity act = (OnePlayerActivity) getActivity();
                                        act.receiveName(heroSelected);
                                    }
                                });

                            }
                        } else {
                            Log.d("tag", "Error getting documents: ", task.getException());
                        }
                    }
                });


        return view;

    }
}

