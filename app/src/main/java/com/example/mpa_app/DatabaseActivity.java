package com.example.mpa_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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
import java.util.HashMap;
import java.util.Map;

public class DatabaseActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Map<String, Object> hero = new HashMap<>();
    CollectionReference heroes = db.collection("heroes");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);


    }


    public void updateDB(View view) {


        //enter data into db - done due to planned API being paid
        hero.put("name", "Abaddon");
        hero.put("pickrate", 10);
        hero.put("role", "Offlane");
        hero.put("winrate", 51.4);
        heroes.document("Abaddon").set(hero);

        hero.put("name", "Alchemist");
        hero.put("pickrate", 10);
        hero.put("role", "Carry");
        hero.put("winrate", 47.1);
        heroes.document("Alchemist").set(hero);

        hero.put("name", "Ancient Apparition");
        hero.put("pickrate", 7.42);
        hero.put("winrate", 50.3);
        hero.put("role", "support");
        heroes.document("AncientApparition").set(hero);

        hero.put("name", "Arc Warden");
        hero.put("pickrate", 1.43);
        hero.put("winrate", 46.47);
        hero.put("role", "Carry");
        heroes.document("ArcWarden").set(hero);

        hero.put("name", "Axe");
        hero.put("pickrate", 13.82);
        hero.put("winrate", 51.89);
        hero.put("role", "Offlane");
        heroes.document("Axe").set(hero);

        hero.put("name", "Bane");
        hero.put("pickrate", 3.47);
        hero.put("winrate", 51.20);
        hero.put("role", "Support");
        heroes.document("Bane").set(hero);

        hero.put("name", "Batrider");
        hero.put("pickrate", 1.91);
        hero.put("winrate", 45.67);
        hero.put("role", "Offlane");
        heroes.document("Batrider").set(hero);

        hero.put("name", "Beastmaster");
        hero.put("pickrate", 2.42);
        hero.put("winrate", 52.80);
        hero.put("role", "Offlane");
        heroes.document("BeastMaster").set(hero);

        hero.put("name", "Bloodseeker");
        hero.put("pickrate", 10.27);
        hero.put("winrate", 52.96);
        hero.put("role", "Carry");
        heroes.document("Bloodseeker").set(hero);

        hero.put("name", "Bounty Hunter");
        hero.put("pickrate", 11.46);
        hero.put("winrate", 52.88);
        hero.put("role", "Support");
        heroes.document("BountyHunter").set(hero);

        hero.put("name", "Brewmaster");
        hero.put("pickrate", 1.56);
        hero.put("winrate", 49.85);
        hero.put("role", "Offlane");
        heroes.document("Brewmaster").set(hero);

        hero.put("name", "Broodmother");
        hero.put("pickrate", 1.87);
        hero.put("winrate", 49.11);
        hero.put("role", "Mid");
        heroes.document("Broodmother").set(hero);

        hero.put("name", "Centaur Warrunner");
        hero.put("pickrate", 6.51);
        hero.put("winrate", 50.9);
        hero.put("role", "Offlane");
        heroes.document("CentaurWarrunner").set(hero);

        hero.put("name", "Chaos Knight");
        hero.put("pickrate", 4.22);
        hero.put("winrate", 49.71);
        hero.put("role", "Carry");
        heroes.document("ChaosKnight").set(hero);

        hero.put("name", "Chen");
        hero.put("pickrate", 0.86);
        hero.put("winrate", 49.14);
        hero.put("role", "Support");
        heroes.document("Chen").set(hero);

        hero.put("name", "Clinkz");
        hero.put("pickrate", 3.71);
        hero.put("winrate", 47.63);
        hero.put("role", "Carry");
        heroes.document("Clinkz").set(hero);

        hero.put("name", "Clockwerk");
        hero.put("pickrate", 7.72);
        hero.put("winrate", 53.29);
        hero.put("role", "Offlane");
        heroes.document("Clockwerk").set(hero);

        hero.put("name", "Crystal Maiden");
        hero.put("pickrate", 14.60);
        hero.put("winrate", 51.86);
        hero.put("role", "Support");
        heroes.document("CrystalMaiden").set(hero);

        hero.put("name", "Dark Seer");
        hero.put("pickrate", 2.13);
        hero.put("winrate", 52.29);
        hero.put("role", "Offlane");
        heroes.document("DarkSeer").set(hero);

        hero.put("name", "Dark Willow");
        hero.put("pickrate", 5.94);
        hero.put("winrate", 51.29);
        hero.put("role", "Support");
        heroes.document("DarkWillow").set(hero);

        hero.put("name", "Dazzle");
        hero.put("pickrate", 12.1);
        hero.put("winrate", 50.99);
        hero.put("role", "Support");
        heroes.document("Dazzle").set(hero);

        hero.put("name", "Death Prophet");
        hero.put("pickrate", 4.63);
        hero.put("winrate", 50.47);
        hero.put("role", "Mid");
        heroes.document("DeathProphet").set(hero);

        hero.put("name", "Doom");
        hero.put("pickrate", 3.19);
        hero.put("winrate", 45.15);
        hero.put("role", "Offlane");
        heroes.document("Doom").set(hero);

        hero.put("name", "Dragon Knight");
        hero.put("pickrate", 7.43);
        hero.put("winrate", 52.06);
        hero.put("role", "Mid");
        heroes.document("Dragon Knight").set(hero);

        hero.put("name", "Drow Ranger");
        hero.put("pickrate", 10.53);
        hero.put("winrate", 49.34);
        hero.put("role", "Carry");
        heroes.document("DrowRanger").set(hero);

        hero.put("name", "Earth Spirit");
        hero.put("pickrate", 3.29);
        hero.put("winrate", 45.82);
        hero.put("role", "Support");
        heroes.document("EarthSpirit").set(hero);

        hero.put("name", "Earthshaker");
        hero.put("pickrate", 13.89);
        hero.put("winrate", 49.22);
        hero.put("role", "Support");
        heroes.document("Earthshaker").set(hero);

        hero.put("name", "Elder Titan");
        hero.put("pickrate", 1.52);
        hero.put("winrate", 48.99);
        hero.put("role", "Support");
        heroes.document("ElderTitan").set(hero);

        hero.put("name", "Ember Spirit");
        hero.put("pickrate", 8.94);
        hero.put("winrate", 46.33);
        hero.put("role", "Mid");
        heroes.document("EmberSpirit").set(hero);

        hero.put("name", "Enchantress");
        hero.put("pickrate", 2.93);
        hero.put("winrate", 45.54);
        hero.put("role", "Support");
        heroes.document("Enchantress").set(hero);

        hero.put("name", "Enigma");
        hero.put("pickrate", 3);
        hero.put("winrate", 50.33);
        hero.put("role", "Support");
        heroes.document("Enigma").set(hero);

        hero.put("name", "Faceless Void");
        hero.put("pickrate", 15.93);
        hero.put("winrate", 49.2);
        hero.put("role", "Carry");
        heroes.document("FacelessVoid").set(hero);

        hero.put("name", "Grimstroke");
        hero.put("pickrate", 6.52);
        hero.put("winrate", 46.65);
        hero.put("role", "Support");
        heroes.document("Grimstroke").set(hero);

        hero.put("name", "Gyrocopter");
        hero.put("pickrate", 3.87);
        hero.put("winrate", 45.65);
        hero.put("role", "Carry");
        heroes.document("Gyrocopter").set(hero);

        hero.put("name", "Huskar");
        hero.put("pickrate", 8.35);
        hero.put("winrate", 50.01);
        hero.put("role", "Mid");
        heroes.document("Huskar").set(hero);

        hero.put("name", "Invoker");
        hero.put("pickrate", 15.38);
        hero.put("winrate", 46.87);
        hero.put("role", "Mid");
        heroes.document("Invoker").set(hero);

        hero.put("name", "Io");
        hero.put("pickrate", 2.64);
        hero.put("winrate", 45.12);
        hero.put("role", "Support");
        heroes.document("Io").set(hero);

        hero.put("name", "Jakiro");
        hero.put("pickrate", 10.97);
        hero.put("winrate", 52.74);
        hero.put("role", "Support");
        heroes.document("Jakiro").set(hero);

        hero.put("name", "Juggernaut");
        hero.put("pickrate", 22.88);
        hero.put("winrate", 49.55);
        hero.put("role", "Carry");
        heroes.document("Juggernaut").set(hero);

        hero.put("name", "Keeper of the Light");
        hero.put("pickrate", 5.37);
        hero.put("winrate", 51.4);
        hero.put("role", "Support");
        heroes.document("KeeperOfTheLight").set(hero);

        hero.put("name", "Kunkka");
        hero.put("pickrate", 8.31);
        hero.put("winrate", 46.81);
        hero.put("role", "Mid");
        heroes.document("Kunkka").set(hero);

        hero.put("name", "Legion Commander");
        hero.put("pickrate", 16.74);
        hero.put("winrate", 49.77);
        hero.put("role", "Carry");
        heroes.document("LegionCommander").set(hero);

        hero.put("name", "Leshrac");
        hero.put("pickrate", 2.14);
        hero.put("winrate", 44.89);
        hero.put("role", "Mid");
        heroes.document("Leshrac").set(hero);

        hero.put("name", "Lich");
        hero.put("pickrate", 12.02);
        hero.put("winrate", 51.02);
        hero.put("role", "Support");
        heroes.document("Lich").set(hero);

        hero.put("name", "Lifestealer");
        hero.put("pickrate", 8.42);
        hero.put("winrate", 47.9);
        hero.put("role", "Carry");
        heroes.document("Lifestealer").set(hero);

        hero.put("name", "Lina");
        hero.put("pickrate", 12.67);
        hero.put("winrate", 47.5);
        hero.put("role", "Mid");
        heroes.document("Lina").set(hero);

        hero.put("name", "Lion");
        hero.put("pickrate", 24.4);
        hero.put("winrate", 48.69);
        hero.put("role", "Support");
        heroes.document("Lion").set(hero);

        hero.put("name", "Lone Druid");
        hero.put("pickrate", 2.97);
        hero.put("winrate", 52.38);
        hero.put("role", "Carry");
        heroes.document("LoneDruid").set(hero);

        hero.put("name", "Luna");
        hero.put("pickrate", 6.36);
        hero.put("winrate", 51.74);
        hero.put("role", "Carry");
        heroes.document("Luna").set(hero);

        hero.put("name", "Lycan");
        hero.put("pickrate", 3.24);
        hero.put("winrate", 53.53);
        hero.put("role", "Carry");
        heroes.document("Lycan").set(hero);

        hero.put("name", "Magnus");
        hero.put("pickrate", 3.93);
        hero.put("winrate", 45.24);
        hero.put("role", "Offlane");
        heroes.document("Magnus").set(hero);

        hero.put("name", "Mars");
        hero.put("pickrate", 9.7);
        hero.put("winrate", 49.08);
        hero.put("role", "Offlane");
        heroes.document("Mars").set(hero);

        hero.put("name", "Medusa");
        hero.put("pickrate", 7.12);
        hero.put("winrate", 48.33);
        hero.put("role", "Carry");
        heroes.document("Medusa").set(hero);

        hero.put("name", "Meepo");
        hero.put("pickrate", 5.76);
        hero.put("winrate", 58.2);
        hero.put("role", "Mid");
        heroes.document("Meepo").set(hero);

        hero.put("name", "Mirana");
        hero.put("pickrate", 12.4);
        hero.put("winrate", 51.15);
        hero.put("role", "Support");
        heroes.document("Mirana").set(hero);

        hero.put("name", "Monkey King");
        hero.put("pickrate", 13.73);
        hero.put("winrate", 48.94);
        hero.put("role", "Carry");
        heroes.document("MonkeyKing").set(hero);

        hero.put("name", "Morphling");
        hero.put("pickrate", 9.14);
        hero.put("winrate", 47.55);
        hero.put("role", "Carry");
        heroes.document("Morphling").set(hero);

        hero.put("name", "Naga Siren");
        hero.put("pickrate", 3.59);
        hero.put("winrate", 51.61);
        hero.put("role", "Carry");
        heroes.document("NagaSiren").set(hero);

        hero.put("name", "Natures Prophet");
        hero.put("pickrate", 7.84);
        hero.put("winrate", 45.13);
        hero.put("role", "Offlane");
        heroes.document("NaturesProphet").set(hero);

        hero.put("name", "Necrophos");
        hero.put("pickrate", 9.15);
        hero.put("winrate", 52.08);
        hero.put("role", "Mid");
        heroes.document("Necrophos").set(hero);

        hero.put("name", "Night Stalker");
        hero.put("pickrate", 3.4);
        hero.put("winrate", 51.07);
        hero.put("role", "Offlane");
        heroes.document("NightStalker").set(hero);

        hero.put("name", "Nyx Assassin");
        hero.put("pickrate", 4.49);
        hero.put("winrate", 51.03);
        hero.put("role", "Support");
        heroes.document("NyxAssassin").set(hero);

        hero.put("name", "Ogre Magi");
        hero.put("pickrate", 22.28);
        hero.put("winrate", 53.52);
        hero.put("role", "Support");
        heroes.document("OgreMagi").set(hero);

        hero.put("name", "Omniknight");
        hero.put("pickrate", 2.31);
        hero.put("winrate", 48.91);
        hero.put("role", "Support");
        heroes.document("Omniknight").set(hero);

        hero.put("name", "Oracle");
        hero.put("pickrate", 2.82);
        hero.put("winrate", 45.94);
        hero.put("role", "Support");
        heroes.document("Oracle").set(hero);

        hero.put("name", "Outworld Devourer");
        hero.put("pickrate", 4.93);
        hero.put("winrate", 45.71);
        hero.put("role", "Mid");
        heroes.document("OutworldDevourer").set(hero);

        hero.put("name", "Pangolier");
        hero.put("pickrate", 6.76);
        hero.put("winrate", 47.55);
        hero.put("role", "Offlane");
        heroes.document("Pangolier").set(hero);

        hero.put("name", "Phantom Assassin");
        hero.put("pickrate", 20.1);
        hero.put("winrate", 49.48);
        hero.put("role", "Carry");
        heroes.document("PhantomAssassin").set(hero);

        hero.put("name", "Phantom Lancer");
        hero.put("pickrate", 10.96);
        hero.put("winrate", 51.35);
        hero.put("role", "Carry");
        heroes.document("Phantom Lancer").set(hero);

        hero.put("name", "Phoenix");
        hero.put("pickrate", 6.66);
        hero.put("winrate", 52.49);
        hero.put("role", "Support");
        heroes.document("Phoenix").set(hero);

        hero.put("name", "Puck");
        hero.put("pickrate", 4.87);
        hero.put("winrate", 46.78);
        hero.put("role", "Mid");
        heroes.document("Puck").set(hero);

        hero.put("name", "Pudge");
        hero.put("pickrate", 23.91);
        hero.put("winrate", 49.69);
        hero.put("role", "Support");
        heroes.document("Pudge").set(hero);

        hero.put("name", "Pugna");
        hero.put("pickrate", 6.3);
        hero.put("winrate", 49.39);
        hero.put("role", "Mid");
        heroes.document("Pugna").set(hero);

        hero.put("name", "Queen of Pain");
        hero.put("pickrate", 9.86);
        hero.put("winrate", 50.79);
        hero.put("role", "Mid");
        heroes.document("QueenOfPain").set(hero);

        hero.put("name", "Razor");
        hero.put("pickrate", 5.96);
        hero.put("winrate", 51.23);
        hero.put("role", "Mid");
        heroes.document("Razor").set(hero);

        hero.put("name", "Riki");
        hero.put("pickrate", 9.65);
        hero.put("winrate", 52.66);
        hero.put("role", "Carry");
        heroes.document("Riki").set(hero);

        hero.put("name", "Rubick");
        hero.put("pickrate", 14.12);
        hero.put("winrate", 47.19);
        hero.put("role", "Support");
        heroes.document("Rubick").set(hero);

        hero.put("name", "Sand King");
        hero.put("pickrate", 5.06);
        hero.put("winrate", 46.6);
        hero.put("role", "Support");
        heroes.document("Sand King").set(hero);

        hero.put("name", "Shadow Demon");
        hero.put("pickrate", 2.66);
        hero.put("winrate", 46.91);
        hero.put("role", "Support");
        heroes.document("Shadow Demon").set(hero);

        hero.put("name", "Shadow Fiend");
        hero.put("pickrate", 13.22);
        hero.put("winrate", 49.54);
        hero.put("role", "Mid");
        heroes.document("Shadow Fiend").set(hero);

        hero.put("name", "Shadow Shaman");
        hero.put("pickrate", 12.37);
        hero.put("winrate", 49.46);
        hero.put("role", "Support");
        heroes.document("Shadow Shaman").set(hero);

        hero.put("name", "Silencer");
        hero.put("pickrate", 11.04);
        hero.put("winrate", 50.05);
        hero.put("role", "Support");
        heroes.document("Silencer").set(hero);

        hero.put("name", "Skywrath Mage");
        hero.put("pickrate", 9.83);
        hero.put("winrate", 49.5);
        hero.put("role", "Support");
        heroes.document("SkywrathMage").set(hero);

        hero.put("name", "Slardar");
        hero.put("pickrate", 10.25);
        hero.put("winrate", 50.87);
        hero.put("role", "Offlane");
        heroes.document("Slardar").set(hero);

        hero.put("name", "Slark");
        hero.put("pickrate", 17);
        hero.put("winrate", 49.95);
        hero.put("role", "Carry");
        heroes.document("Slark").set(hero);

        hero.put("name", "Snapfire");
        hero.put("pickrate", 13.57);
        hero.put("winrate", 49.69);
        hero.put("role", "Support");
        heroes.document("Snapfire").set(hero);

        hero.put("name", "Sniper");
        hero.put("pickrate", 20.06);
        hero.put("winrate", 50.11);
        hero.put("role", "Carry");
        heroes.document("Sniper").set(hero);

        hero.put("name", "Spectre");
        hero.put("pickrate", 7.22);
        hero.put("winrate", 51.32);
        hero.put("role", "Carry");
        heroes.document("Spectre").set(hero);

        hero.put("name", "Spirit Breaker");
        hero.put("pickrate", 11.49);
        hero.put("winrate", 50.72);
        hero.put("role", "Support");
        heroes.document("SpiritBreaker").set(hero);

        hero.put("name", "Storm Spirit");
        hero.put("pickrate", 9.54);
        hero.put("winrate", 47.15);
        hero.put("role", "Mid");
        heroes.document("StormSpirit").set(hero);

        hero.put("name", "Sven");
        hero.put("pickrate", 7.46);
        hero.put("winrate", 49.1);
        hero.put("role", "Carry");
        heroes.document("Sven").set(hero);

        hero.put("name", "Techies");
        hero.put("pickrate", 7.42);
        hero.put("winrate", 49.46);
        hero.put("role", "Support");
        heroes.document("Techies").set(hero);

        hero.put("name", "Templar Assassin");
        hero.put("pickrate", 6);
        hero.put("winrate", 47.96);
        hero.put("role", "Mid");
        heroes.document("Templar Assassin").set(hero);

        hero.put("name", "Terrorblade");
        hero.put("pickrate", 3.58);
        hero.put("winrate", 42.02);
        hero.put("role", "Carry");
        heroes.document("Terrorblade").set(hero);

        hero.put("name", "Tidehunter");
        hero.put("pickrate", 5.3);
        hero.put("winrate", 50.44);
        hero.put("role", "Support");
        heroes.document("Tidehunter").set(hero);

        hero.put("name", "Timbersaw");
        hero.put("pickrate", 6.94);
        hero.put("winrate", 48.66);
        hero.put("role", "Offlane");
        heroes.document("Timbersaw").set(hero);

        hero.put("name", "Tinker");
        hero.put("pickrate", 6.63);
        hero.put("winrate", 46.11);
        hero.put("role", "Mid");
        heroes.document("Tinker").set(hero);

        hero.put("name", "Tiny");
        hero.put("pickrate", 6);
        hero.put("winrate", 43.5);
        hero.put("role", "Support");
        heroes.document("Tiny").set(hero);

        hero.put("name", "Treant Protector");
        hero.put("pickrate", 4.27);
        hero.put("winrate", 49.73);
        hero.put("role", "Support");
        heroes.document("TreantProtector").set(hero);

        hero.put("name", "Troll Warlord");
        hero.put("pickrate", 8.97);
        hero.put("winrate", 51.89);
        hero.put("role", "Carry");
        heroes.document("TrollWarlord").set(hero);

        hero.put("name", "Tusk");
        hero.put("pickrate", 5.49);
        hero.put("winrate", 48.17);
        hero.put("role", "Support");
        heroes.document("Tusk").set(hero);

        hero.put("name", "Underlord");
        hero.put("pickrate", 7.07);
        hero.put("winrate", 54.71);
        hero.put("role", "Offlane");
        heroes.document("Underlord").set(hero);

        hero.put("name", "Undying");
        hero.put("pickrate", 5);
        hero.put("winrate", 50.49);
        hero.put("role", "Support");
        heroes.document("Undying").set(hero);

        hero.put("name", "Ursa");
        hero.put("pickrate", 10.07);
        hero.put("winrate", 52.43);
        hero.put("role", "Carry");
        heroes.document("Ursa").set(hero);

        hero.put("name", "Vengeful Spirit");
        hero.put("pickrate", 5.61);
        hero.put("winrate", 52.41);
        hero.put("role", "Support");
        heroes.document("Vengeful Spirit").set(hero);

        hero.put("name", "Venomancer");
        hero.put("pickrate", 5.38);
        hero.put("winrate", 49.65);
        hero.put("role", "Support");
        heroes.document("Venomancer").set(hero);

        hero.put("name", "Viper");
        hero.put("pickrate", 7.79);
        hero.put("winrate", 46.39);
        hero.put("role", "Mid");
        heroes.document("Viper").set(hero);

        hero.put("name", "Visage");
        hero.put("pickrate", 0.79);
        hero.put("winrate", 52.41);
        hero.put("role", "Support");
        heroes.document("Visage").set(hero);

        hero.put("name", "Void Spirit");
        hero.put("pickrate", 9.93);
        hero.put("winrate", 49.44);
        hero.put("role", "Mid");
        heroes.document("VoidSpirit").set(hero);

        hero.put("name", "Warlock");
        hero.put("pickrate", 4.8);
        hero.put("winrate", 51.34);
        hero.put("role", "Support");
        heroes.document("Warlock").set(hero);

        hero.put("name", "Weaver");
        hero.put("pickrate", 9.16);
        hero.put("winrate", 49.62);
        hero.put("role", "Carry");
        heroes.document("Weaver").set(hero);

        hero.put("name", "Windranger");
        hero.put("pickrate", 15.99);
        hero.put("winrate", 49.53);
        hero.put("role", "Mid");
        heroes.document("Windranger").set(hero);

        hero.put("name", "Winter Wyvern");
        hero.put("pickrate", 5.09);
        hero.put("winrate", 48.76);
        hero.put("role", "Support");
        heroes.document("Winter Wyvern").set(hero);

        hero.put("name", "Witch Doctor");
        hero.put("pickrate", 14.46);
        hero.put("winrate", 50.37);
        hero.put("role", "Support");
        heroes.document("WitchDoctor").set(hero);

        hero.put("name", "Wraith King");
        hero.put("pickrate", 17.45);
        hero.put("winrate", 55.88);
        hero.put("role", "Carry");
        heroes.document("Wraith King").set(hero);

        hero.put("name", "Zeus");
        hero.put("pickrate", 12.72);
        hero.put("winrate", 51.61);
        hero.put("role", "Mid");
        heroes.document("Zeus").set(hero);


        //output info to console to ensure upload worked
        db.collection("heroes")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("tag", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.d("tag", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }

    public void enterInfo(View view) {

        EditText nameBox = findViewById(R.id.textName);
        EditText pickBox = findViewById(R.id.textPick);
        EditText roleBox = findViewById(R.id.textRole);
        EditText winBox = findViewById(R.id.textWin);

        hero.put("name", nameBox.getText().toString());

        try {
            Double number = Double.parseDouble(String.valueOf(pickBox.getText()));
            hero.put("pickrate", number);
        } catch (NumberFormatException e) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter a valid number format for Pick rate", Toast.LENGTH_LONG);
            Log.d("tag", "Exception - Win");
            toast.show();
        }

        try {
            Double number = Double.parseDouble(String.valueOf(winBox.getText()));
            hero.put("winrate", number);
        } catch (NumberFormatException e) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter a valid number format for Win rate", Toast.LENGTH_LONG);
            Log.d("tag", "Exception - Win");
            toast.show();
        }

        hero.put("role", roleBox.getText().toString());


    }
}