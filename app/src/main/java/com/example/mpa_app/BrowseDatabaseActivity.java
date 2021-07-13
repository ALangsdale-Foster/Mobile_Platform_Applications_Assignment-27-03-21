package com.example.mpa_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrowseDatabaseActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Map<String, Object> hero = new HashMap<>();
    CollectionReference heroes = db.collection("heroes");

    List<String> nameList;
    List<Double> pickList;
    List<Double> winList;
    List<String> roleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_database);

        //initialize arrays
        nameList = new ArrayList<String>();
        pickList = new ArrayList<Double>();
        winList = new ArrayList<Double>();
        roleList = new ArrayList<String>();
        //populate arrays from firebase
        db.collection("heroes")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String heroName = document.getId();
                                nameList.add(heroName);

                                Double pickRate = (Double) document.get("pickrate");
                                pickList.add(pickRate);
                                //Log.d("tag", "Hero name: " + heroName);
                            }
                        } else {
                            Log.d("tag", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }

    protected boolean existsElement(List<String> list, String name) {
        for (String item : list) {
            if (item.contains(name)) {
                return true;
            }
        }

        return false;
    }
}
