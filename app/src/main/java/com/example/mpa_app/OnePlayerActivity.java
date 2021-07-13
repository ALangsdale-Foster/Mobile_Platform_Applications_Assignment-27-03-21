package com.example.mpa_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static android.service.autofill.Validators.and;

public class OnePlayerActivity extends AppCompatActivity{

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Map<String, Object> hero = new HashMap<>();
    CollectionReference heroes = db.collection("heroes");

    List<String> nameList;
    List<Double> pickList;
    List<Double> winList;
    List<String> roleList;

    String heroName;
    Double pickRate;
    Double winRate;

    String receivedData;

    Boolean supp1, supp2, offlane, mid, carry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_player);
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
                                //Log.d("tag", document.getId() + " => " + document.getData());
                                heroName = document.getId();
                                nameList.add(heroName);

                                pickRate = document.getDouble("pickrate");
                                pickList.add(pickRate);

                                winRate = document.getDouble("winrate");
                                winList.add(winRate);
                                Log.d("tag", heroName + " pick rate: " + pickRate + " win rate: " + winRate);
                            }
                        } else {
                            Log.d("tag", "Error getting documents: ", task.getException());
                        }
                    }
                });

        Button firstFragment = (Button) findViewById(R.id.heroPickButton);
        firstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new FirstFragment());
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

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.heroPickLayout, fragment);
        fragmentTransaction.commit();
    }
    boolean aiflag = false;
    public void receiveName(String val) {
        receivedData = val;
        String[] ids = {"text1B1", "text2B1", "text1B2", "text2B2", "text1B3", "text2B3",
                "text1H1", "text2H1", "text1H2", "text2H2", "text1H3", "text2H3", "text1H4", "text2H4", "text1H5", "text2H5"};

        int random = -3;
        for (int i = 0; i < ids.length; i++ ) {
            TextView text = (TextView) findViewById(getElementName(ids[i]));
            //Toast.makeText(OnePlayerActivity.this, "String chosen: " + text.getText().toString(), Toast.LENGTH_SHORT).show();
            if (text.getText().toString().equals("None")) {
                if (aiflag == true)  {
                    //String ainame = chooseName();
                    boolean aiCheck = false;
                    random = new Random().nextInt(nameList.size());
                    Toast.makeText(OnePlayerActivity.this, "AI Chose: " + random, Toast.LENGTH_SHORT).show();
                    while (!aiCheck) {
                        aiCheck = checkName(nameList.get(random));
                        random = new Random().nextInt(nameList.size());
                    }
                    String ainame = nameList.get(random);
                    text.setText(ainame);
                    random = -1;
                    i = ids.length;
                }

                if (aiflag == false) {
                    if (checkName(receivedData)) {
                        text.setText(receivedData);
                        //Toast.makeText(OnePlayerActivity.this, "AI's Turn, Player Chose: " + receivedData, Toast.LENGTH_SHORT).show();
                        i = ids.length;
                    } else {
                        Toast.makeText(OnePlayerActivity.this, "Hero already chosen/banned", Toast.LENGTH_SHORT).show();
                    }
                    random = -2;
                    aiflag = true;
                }

                if (random == -1) {
                    aiflag = false;
                }
                TextView finaltext = (TextView) findViewById(R.id.text2H5);
                if (!"None".equals(finaltext.getText())) {
                    ArrayList<String> Player1 = new ArrayList<String>();
                    ArrayList<String> Player2 = new ArrayList<String>();
                    TextView picked1 = findViewById(R.id.text1H1);
                    TextView picked2 = findViewById(R.id.text1H2);
                    TextView picked3 = findViewById(R.id.text1H3);
                    TextView picked4 = findViewById(R.id.text1H4);
                    TextView picked5 = findViewById(R.id.text1H5);
                    TextView picked6 = findViewById(R.id.text2H1);
                    TextView picked7 = findViewById(R.id.text2H2);
                    TextView picked8 = findViewById(R.id.text2H3);
                    TextView picked9 = findViewById(R.id.text2H4);
                    TextView picked10 = findViewById(R.id.text2H5);

                    Player1.add((String) picked1.getText());
                    Player1.add((String) picked2.getText());
                    Player1.add((String) picked3.getText());
                    Player1.add((String) picked4.getText());
                    Player1.add((String) picked5.getText());

                    Player2.add((String) picked6.getText());
                    Player2.add((String) picked7.getText());
                    Player2.add((String) picked8.getText());
                    Player2.add((String) picked9.getText());
                    Player2.add((String) picked10.getText());

                    calcScore(Player1, Player2);
                }
            }
        }
    }

    public void calcScore(ArrayList<String> p1, ArrayList<String> p2) {
        ArrayList<Integer>iValue1 = new ArrayList<Integer>();
        ArrayList<Integer>iValue2 = new ArrayList<Integer>();
        for (int i = 0; i < nameList.size(); i++ ) {
            for (int j = 0; j < p1.size(); j++) {
                if (p1.get(j).equals(nameList.get(i))) {
                    iValue1.add(i);
                }

                if (p2.get(j).equals(nameList.get(i))) {
                    iValue2.add(i);
                }
            }
        }
        double score1 = 0.0;
        double score2 = 0.0;
        for (int i = 0; i < p1.size(); i++) {
            score1 += winList.get(iValue1.get(i)) * 10;
            score2 += winList.get(iValue2.get(i)) * 10;
        }

        if (score1 > score2) {
            Toast.makeText(OnePlayerActivity.this, "Player Wins with score: " + score1 + " vs AI's " + score2, Toast.LENGTH_LONG).show();
        } else if (score2 > score1) {
            Toast.makeText(OnePlayerActivity.this, "AI Wins with score: " + score2 + " vs Player's " + score1, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(OnePlayerActivity.this, "The game is a draw with " + score2, Toast.LENGTH_LONG).show();
        }

    }

    public int getElementName(String val) {
        int id = getResources().getIdentifier(val, "id", getPackageName());
        return id;
    }

    public boolean checkName(String name) {
        boolean check = true;
        TextView banned1 = findViewById(R.id.text1B1);
        TextView banned2 = findViewById(R.id.text1B2);
        TextView banned3 = findViewById(R.id.text1B3);
        TextView banned4 = findViewById(R.id.text2B1);
        TextView banned5 = findViewById(R.id.text2B2);
        TextView banned6 = findViewById(R.id.text2B3);

        if(banned1.getText().toString().equals(name)) {
            check = false;
        } else if (banned2.getText().toString().equals(name)) {
            check = false;
        } else if (banned3.getText().toString().equals(name)) {
            check = false;
        } else if (banned4.getText().toString().equals(name)) {
            check = false;
        } else if (banned5.getText().toString().equals(name)) {
            check = false;
        } else if (banned6.getText().toString().equals(name)) {
            check = false;
        }
        //remove picked heroes
        TextView picked1 = findViewById(R.id.text1H1);
        TextView picked2 = findViewById(R.id.text1H2);
        TextView picked3 = findViewById(R.id.text1H3);
        TextView picked4 = findViewById(R.id.text1H4);
        TextView picked5 = findViewById(R.id.text1H5);
        TextView picked6 = findViewById(R.id.text2H1);
        TextView picked7 = findViewById(R.id.text2H2);
        TextView picked8 = findViewById(R.id.text2H3);
        TextView picked9 = findViewById(R.id.text2H4);

        if(picked1.getText().toString().equals(name)) {
            check = false;
        } else if (picked2.getText().toString().equals(name)) {
            check = false;
        } else if (picked3.getText().toString().equals(name)) {
            check = false;
        } else if (picked4.getText().toString().equals(name)) {
            check = false;
        } else if (picked5.getText().toString().equals(name)) {
            check = false;
        } else if (picked6.getText().toString().equals(name)) {
            check = false;
        } else if (picked7.getText().toString().equals(name)) {
            check = false;
        } else if (picked8.getText().toString().equals(name)) {
            check = false;
        } else if (picked9.getText().toString().equals(name)) {
            check = false;
        }

        return check;
    }

    public String chooseName() {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> listcopy = new ArrayList<Integer>();
        int value = 0;
        int flag = 0;
        //check which roles need filling and populate list with appropriate indices
        /*for (int i = 0; i < roleList.size(); i++) {
            if ((supp1 == false) && (roleList.get(i).equals("support"))) {
                list.add(i);
                flag = 1;
            } else if ((supp2 == false) && (roleList.get(i).equals("support"))) {
                list.add(i);
                flag = 2;
            } else if ((supp2 == false) && (roleList.get(i).equals("offlane"))) {
                list.add(i);
                flag = 3;
            } else if ((supp2 == false) && (roleList.get(i).equals("carry"))) {
                list.add(i);
                flag = 4;
            } else if ((supp2 == false) && (roleList.get(i).equals("mid"))) {
                list.add(i);
                flag = 5;
            }
        }
        //backup list just in case;
        listcopy = list;
        //set role bool to true
        switch(flag) {
            case 1:
                supp1 = true;
                Toast.makeText(OnePlayerActivity.this, "1", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                supp2 = true;
                Toast.makeText(OnePlayerActivity.this, "2", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                offlane = true;
                Toast.makeText(OnePlayerActivity.this, "3", Toast.LENGTH_SHORT).show();
            case 4:
                carry = true;
                Toast.makeText(OnePlayerActivity.this, "4", Toast.LENGTH_SHORT).show();
            case 5:
                mid = true;
                Toast.makeText(OnePlayerActivity.this, "5", Toast.LENGTH_SHORT).show();
        }*/
        //remove banned indices
        TextView banned1 = findViewById(R.id.text1B1);
        TextView banned2 = findViewById(R.id.text1B2);
        TextView banned3 = findViewById(R.id.text1B3);
        TextView banned4 = findViewById(R.id.text2B1);
        TextView banned5 = findViewById(R.id.text2B2);
        TextView banned6 = findViewById(R.id.text2B3);
        for (int i = 0; i < list.size(); i++) {
            if(banned1.getText().toString().equals(nameList.get(i))) {
                list.remove(i);
            } else if (banned2.getText().toString().equals(nameList.get(i))) {
                list.remove(i);
            } else if (banned3.getText().toString().equals(nameList.get(i))) {
                list.remove(i);
            } else if (banned4.getText().toString().equals(nameList.get(i))) {
                list.remove(i);
            } else if (banned5.getText().toString().equals(nameList.get(i))) {
                list.remove(i);
            } else if (banned6.getText().toString().equals(nameList.get(i))) {
                list.remove(i);
            }
        }
        //remove picked heroes
        TextView picked1 = findViewById(R.id.text1H1);
        TextView picked2 = findViewById(R.id.text1H2);
        TextView picked3 = findViewById(R.id.text1H3);
        TextView picked4 = findViewById(R.id.text1H4);
        TextView picked5 = findViewById(R.id.text1H5);
        TextView picked6 = findViewById(R.id.text2H1);
        TextView picked7 = findViewById(R.id.text2H2);
        TextView picked8 = findViewById(R.id.text2H3);
        TextView picked9 = findViewById(R.id.text2H4);
        for (int i = 0; i < list.size(); i++) {
            if(picked1.getText().toString().equals(nameList.get(i))) {
                list.remove(i);
            } else if (picked2.getText().toString().equals(nameList.get(i))) {
                list.remove(i);
            } else if (picked3.getText().toString().equals(nameList.get(i))) {
                list.remove(i);
            } else if (picked4.getText().toString().equals(nameList.get(i))) {
                list.remove(i);
            } else if (picked5.getText().toString().equals(nameList.get(i))) {
                list.remove(i);
            } else if (picked6.getText().toString().equals(nameList.get(i))) {
                list.remove(i);
            } else if (picked7.getText().toString().equals(nameList.get(i))) {
                list.remove(i);
            } else if (picked8.getText().toString().equals(nameList.get(i))) {
                list.remove(i);
            } else if (picked9.getText().toString().equals(nameList.get(i))) {
                list.remove(i);
            }
        }
        //calculate weighting
        double totalWeight = 0.0;
        for (int i = 0; i < list.size(); i++) {
            totalWeight += pickList.get(list.get(i));
        }
        double randomno = Math.random() * totalWeight;
        //select based on weight
        double probItr = 0.0;
        for (int i = 0; i < list.size(); i++) {
            probItr = pickList.get(list.get(i));
            if (probItr >= randomno) {
                value = i;
            }
        }

        return nameList.get(value);
    }
}
