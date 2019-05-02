package com.example.ethyl.mallmapproject;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ethyl on 11/27/2017.
 */


public class MainActivity extends AppCompatActivity{
    public DatabaseInsert data;
    RecyclerView recyclerView;
    ListAdapter listAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list);
        createMall();
        recyclerView = (RecyclerView) findViewById(R.id.listRecyclerView);
        listAdapter = new ListAdapter();
        recyclerView.setAdapter(listAdapter);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
    }
    public DatabaseInsert createMall(){
        data = new DatabaseInsert(this);
        if (!data.mallCheck()){
            Mall mall = new Mall("Conestoga Mall", 43.4978, -80.5268, "conestoga");
            data.addMallToDataBase(mall);
            Store store = new Store("A&W", 1, 43.497108,-80.526386);
            data.addStoreToDataBase(store);
            store = new Store("Aerie",1,43.498706, -80.527697);
            data.addStoreToDataBase(store);
            store = new Store("Aldo", 1, 43.497825, -80.527255);
            data.addStoreToDataBase(store);
            store = new Store("Altered Image",1,43.498313, -80.526358);
            data.addStoreToDataBase(store);
            store = new Store("American Eagle", 1, 43.498769, -80.527646);
            data.addStoreToDataBase(store);
            store = new Store("Anna Bella",1,43.498250, -80.526974);
            data.addStoreToDataBase(store);
            store = new Store("Apple", 1, 43.497695, -80.527108);
            data.addStoreToDataBase(store);
            store = new Store("Ardene",1,43.497910, -80.525914);
            data.addStoreToDataBase(store);
            store = new Store("Raymond's", 1, 43.498380, -80.526440);
            data.addStoreToDataBase(store);
            store = new Store("Bath&BodyWorks",1,43.497198, -80.527220);
            data.addStoreToDataBase(store);
            store = new Store("Bell", 1, 43.498053, -80.526911);
            data.addStoreToDataBase(store);
            store = new Store("Bench.",1,43.498340, -80.527534);
            data.addStoreToDataBase(store);
            store = new Store("Bentley", 1, 43.497291, -80.525891);
            data.addStoreToDataBase(store);
            store = new Store("Best Buy Mobile",1,43.497215, -80.525982);
            data.addStoreToDataBase(store);
            store = new Store("Bikini Village",1,43.497956, -80.525976);
            data.addStoreToDataBase(store);
            store = new Store("Bluenotes", 1, 43.498398, -80.527200);
            data.addStoreToDataBase(store);
            store = new Store("Boathouse",1,43.497475, -80.526221);
            data.addStoreToDataBase(store);
            store = new Store("Bourbon st. Grill",1,43.496958, -80.526801);
            data.addStoreToDataBase(store);;
            store = new Store("Spring",1,43.497474, -80.526952);
            data.addStoreToDataBase(store);
            store = new Store("Charm",1,43.498108, -80.527329);
            data.addStoreToDataBase(store);
            store = new Store("The Children's Place", 1, 43.498301, -80.527789);
            data.addStoreToDataBase(store);
            store = new Store("CIBC",1,43.499090, -80.529516);
            data.addStoreToDataBase(store);
            store = new Store("Cinnabon", 1, 43.498117, -80.526285);
            data.addStoreToDataBase(store);
            store = new Store("Cleo",1,43.498291, -80.526873);
            data.addStoreToDataBase(store);
            store = new Store("Coles", 1,43.497490, -80.525983);
            data.addStoreToDataBase(store);
            store = new Store("Crate Designs furniture", 1, 43.497594, -80.525915);
            data.addStoreToDataBase(store);
            store = new Store("Cultures",1,43.496796, -80.526739);
            data.addStoreToDataBase(store);
            store = new Store("Dynamite", 1, 43.498724, -80.527110);
            data.addStoreToDataBase(store);
            store = new Store("EB Games",1,43.497217, -80.526941);
            data.addStoreToDataBase(store);
            store = new Store("FairWeather", 1,43.498300, -80.526553);
            data.addStoreToDataBase(store);
            store = new Store("fetaOlives",1,43.497075, -80.526836);
            data.addStoreToDataBase(store);
            store = new Store("Fido", 1,43.497837, -80.526281);
            data.addStoreToDataBase(store);
            store = new Store("Foot Locker", 1,43.498485, -80.527155);
            data.addStoreToDataBase(store);
            store = new Store("Freedom mobile",1,43.497507, -80.525741);
            data.addStoreToDataBase(store);
            store = new Store("Freshly Squeezed", 1, 43.498013, -80.526316);
            data.addStoreToDataBase(store);
            store = new Store("Galaxy Cinema",1,43.496299, -80.525737);
            data.addStoreToDataBase(store);
            store = new Store("GAP", 1,43.498479, -80.527588);
            data.addStoreToDataBase(store);
            store = new Store("Garage",1,43.497206, -80.527088);
            data.addStoreToDataBase(store);
            store = new Store("Gateway Newstands",1,43.498051, -80.527970);
            data.addStoreToDataBase(store);
            store = new Store("Greenearth", 1, 43.497957, -80.526606);
            data.addStoreToDataBase(store);
            store = new Store("H&M",1,43.497259, -80.527716);
            data.addStoreToDataBase(store);
            store = new Store("Hallmark Cards", 1, 43.498012, -80.527784);
            data.addStoreToDataBase(store);
            store = new Store("Hudson's Bay",1,43.496526, -80.527561);
            data.addStoreToDataBase(store);
            store = new Store("ICING", 1,43.498250, -80.527150);
            data.addStoreToDataBase(store);
            store = new Store("Jean Machine",1,43.497998, -80.526066);
            data.addStoreToDataBase(store);
            store = new Store("Journeys", 1,43.498260, -80.526789);
            data.addStoreToDataBase(store);
            store = new Store("Justice", 1,43.497880, -80.526584);
            data.addStoreToDataBase(store);
            store = new Store("Kernels",1,43.498136, -80.526905);
            data.addStoreToDataBase(store);
            store = new Store("TacoBell", 1,43.496929, -80.526395);
            data.addStoreToDataBase(store);
            store = new Store("KFC", 1,43.496929, -80.526395);
            data.addStoreToDataBase(store);
            store = new Store("Koodo", 1,43.497449, -80.525826);
            data.addStoreToDataBase(store);
            store = new Store("la Senza",1,43.497938, -80.526393);
            data.addStoreToDataBase(store);
            store = new Store("la Vie en Rose", 1,43.498027, -80.526839);
            data.addStoreToDataBase(store);
            store = new Store("Laura Second",1,43.497257, -80.526371);
            data.addStoreToDataBase(store);
            store = new Store("le Chateau", 1,43.497572, -80.527192);
            data.addStoreToDataBase(store);
            store = new Store("LensCrafters",1,43.497606, -80.525518);
            data.addStoreToDataBase(store);
            store = new Store("Lids", 1,43.497258, -80.526241);
            data.addStoreToDataBase(store);
            store = new Store("lululemon",1,43.497900, -80.527230);
            data.addStoreToDataBase(store);
            store = new Store("Mac's Sushi", 1,43.497275, -80.526620);
            data.addStoreToDataBase(store);
            store = new Store("Manchu Wok",1,43.497036, -80.526386);
            data.addStoreToDataBase(store);
            store = new Store("Mappins",1,43.497857, -80.526933);
            data.addStoreToDataBase(store);
            store = new Store("Michael hill", 1,43.497222, -80.526861);
            data.addStoreToDataBase(store);
            store = new Store("mobile Outfitters",1,43.497337, -80.527177);
            data.addStoreToDataBase(store);
            store = new Store("Mountain WareHouse", 1,43.497992, -80.526472);
            data.addStoreToDataBase(store);
            store = new Store("Nails for you",1,43.498422, -80.526300);
            data.addStoreToDataBase(store);
            store = new Store("NY Fries", 1,43.497130, -80.526838);
            data.addStoreToDataBase(store);
            store = new Store("Old Navy",1,43.498385, -80.528053);
            data.addStoreToDataBase(store);
            store = new Store("Pandora", 1,43.498260, -80.527586);
            data.addStoreToDataBase(store);
            store = new Store("Payless",1,43.497686, -80.526081);
            data.addStoreToDataBase(store);
            store = new Store("Peoples", 1,43.498236, -80.527241);
            data.addStoreToDataBase(store);
            store = new Store("Pink",1,43.497485, -80.526716);
            data.addStoreToDataBase(store);
            store = new Store("Raffi", 1,43.498041, -80.527188);
            data.addStoreToDataBase(store);
            store = new Store("Ricki's",1,43.497805, -80.527595);
            data.addStoreToDataBase(store);
            store = new Store("Rocky MTN Chocolate", 1,43.497395, -80.527179);
            data.addStoreToDataBase(store);
            store = new Store("Rogers",1,43.497685, -80.525678);
            data.addStoreToDataBase(store);
            store = new Store("Roots", 1,43.498322, -80.526674);
            data.addStoreToDataBase(store);
            store = new Store("Royal Bee",1,43.497549, -80.526848);
            data.addStoreToDataBase(store);
            store = new Store("RW & CO.", 1,43.497453, -80.526422);
            data.addStoreToDataBase(store);
            store = new Store("S&H Health Foods",1,43.497390, -80.525732);
            data.addStoreToDataBase(store);
            store = new Store("Saje", 1,43.497983, -80.526770);
            data.addStoreToDataBase(store);
            store = new Store("Sephora", 1,43.497461, -80.527638);
            data.addStoreToDataBase(store);
            store = new Store("Shoppers Drug Mart",1,43.498820, -80.527134);
            data.addStoreToDataBase(store);
            store = new Store("Sirens",1,43.499131, -80.529551);
            data.addStoreToDataBase(store);
            store = new Store("SoftMoc", 1,43.497412, -80.527075);
            data.addStoreToDataBase(store);
            store = new Store("SportCheck",1,43.497788, -80.525734);
            data.addStoreToDataBase(store);
            store = new Store("Stars",1,43.498664, -80.527113);
            data.addStoreToDataBase(store);
            store = new Store("Studio C", 1,43.497545, -80.525850);
            data.addStoreToDataBase(store);
            store = new Store("Subway",1,43.496906, -80.526783);
            data.addStoreToDataBase(store);
            store = new Store("sunglass hut", 1,43.497409, -80.527282);
            data.addStoreToDataBase(store);
            store = new Store("Tbooth",1,43.497256, -80.526150);
            data.addStoreToDataBase(store);
            store = new Store("Telus",1,43.498088, -80.526232);
            data.addStoreToDataBase(store);
            store = new Store("The Body Shop", 1,43.498046, -80.526976);
            data.addStoreToDataBase(store);
            store = new Store("the Source",1,43.498048, -80.526150);
            data.addStoreToDataBase(store);
            store = new Store("Things Engraved", 1,43.498043, -80.527616);
            data.addStoreToDataBase(store);
            store = new Store("Tim Hortons",1,43.496845, -80.526411);
            data.addStoreToDataBase(store);
            store = new Store("Timothy's", 1,43.497210, -80.526372);
            data.addStoreToDataBase(store);
            store = new Store("Tonyc",1,43.497348, -80.525805);
            data.addStoreToDataBase(store);
            store = new Store("TD", 1,43.498056, -80.528030);
            data.addStoreToDataBase(store);
            store = new Store("Trillium Dental",1,43.498600, -80.526521);
            data.addStoreToDataBase(store);
            store = new Store("tripCentral", 1,43.498381, -80.526331);
            data.addStoreToDataBase(store);
            store = new Store("Villa Madina",1,43.496986, -80.526382);
            data.addStoreToDataBase(store);
            store = new Store("Vine Vera", 1,43.498245, -80.527714);
            data.addStoreToDataBase(store);
            store = new Store("Virgin Mobile",1,43.498836, -80.527372);
            data.addStoreToDataBase(store);
            store = new Store("Vivah", 1,43.497336, -80.527010);
            data.addStoreToDataBase(store);
            store = new Store("Volum",1,43.497632, -80.525977);
            data.addStoreToDataBase(store);
            store = new Store("Winners", 1,43.498249, -80.525878);
            data.addStoreToDataBase(store);
            store = new Store("World Vision",1,43.497649, -80.525618);
            data.addStoreToDataBase(store);
            store = new Store("WirelessWave",1,43.498132, -80.526776);
            data.addStoreToDataBase(store);
            store = new Store("yogen fruz", 1,43.498045, -80.526439);
            data.addStoreToDataBase(store);
            store = new Store("your GOOD HEALTH store",1,43.498013, -80.527899);
            data.addStoreToDataBase(store);
            store = new Store("Zehrs", 1,43.497046, -80.525217);
            data.addStoreToDataBase(store);
            mall = new Mall("Fairview Park Mall", 43.423495, -80.439474, "fairview");
            data.addMallToDataBase(mall);
            store = new Store("A&W", 2,43.425178, -80.438490);
            data.addStoreToDataBase(store);
            store = new Store("Aldo", 2,43.424457, -80.438793);
            data.addStoreToDataBase(store);
            store = new Store("Ardene",2,43.424125, -80.437784);
            data.addStoreToDataBase(store);
            store = new Store("American Eagle", 2,43.424112, -80.438915);
            data.addStoreToDataBase(store);
            store = new Store("Aritzia",2,43.424601, -80.439594);
            data.addStoreToDataBase(store);
            store = new Store("Banana Republic", 2,43.424632, -80.439475);
            data.addStoreToDataBase(store);
            store = new Store("Bath&BodyWorks",2,43.424384, -80.439214);
            data.addStoreToDataBase(store);
            store = new Store("Bell", 2,43.423583, -80.440281);
            data.addStoreToDataBase(store);
            store = new Store("Bentley", 2,43.424066, -80.438603);
            data.addStoreToDataBase(store);
            store = new Store("Best Buy Mobile",2,43.424906, -80.438544);
            data.addStoreToDataBase(store);
            store = new Store("Bikini Village",2,43.424532, -80.438271);
            data.addStoreToDataBase(store);
            store = new Store("Bluenotes", 2,43.423851, -80.438294);
            data.addStoreToDataBase(store);
            store = new Store("Bonkers",2,43.423735, -80.438502);
            data.addStoreToDataBase(store);
            store = new Store("BootLegger",2,43.424315, -80.437945);
            data.addStoreToDataBase(store);
            store = new Store("Bourbon st. Grill",2,43.425138, -80.438835);
            data.addStoreToDataBase(store);
            store = new Store("Carlton Cards",2,43.424938, -80.438354);
            data.addStoreToDataBase(store);
            store = new Store("Chatr Mobile",2,43.423361, -80.438474);
            data.addStoreToDataBase(store);
            store = new Store("Cinnabon", 2,43.423903, -80.439806);
            data.addStoreToDataBase(store);
            store = new Store("Clair De Lune",2,43.423763, -80.438088);
            data.addStoreToDataBase(store);
            store = new Store("Cleo",2,43.424725, -80.439269);
            data.addStoreToDataBase(store);
            store = new Store("Coach", 2,43.424391, -80.438725);
            data.addStoreToDataBase(store);
            store = new Store("Continental Currency Exchange", 2,43.424864, -80.438626);
            data.addStoreToDataBase(store);
            store = new Store("Dairy Queen", 2,43.424020, -80.438343);
            data.addStoreToDataBase(store);
            store = new Store("Dynamite", 2,43.424658, -80.439038);
            data.addStoreToDataBase(store);
            store = new Store("EB Games",2,43.424971, -80.438493);
            data.addStoreToDataBase(store);
            store = new Store("Famous Wok", 2,43.425280, -80.438658);
            data.addStoreToDataBase(store);
            store = new Store("Fido", 2,43.424548, -80.438634);
            data.addStoreToDataBase(store);
            store = new Store("Fine Gold Jewellers", 2,43.424020, -80.438056);
            data.addStoreToDataBase(store);
            store = new Store("Flight Centre", 2,43.423668, -80.440043);
            data.addStoreToDataBase(store);
            store = new Store("Foot Locker", 2,43.424535, -80.438258);
            data.addStoreToDataBase(store);
            store = new Store("Forever 21", 2,43.423664, -80.439330);
            data.addStoreToDataBase(store);
            store = new Store("Fossil", 2,43.424546, -80.438845);
            data.addStoreToDataBase(store);
            store = new Store("Freedom mobile",2,43.423912, -80.439722);
            data.addStoreToDataBase(store);
            store = new Store("Freshly Squeezed", 2,43.423766, -80.439929);
            data.addStoreToDataBase(store);
            store = new Store("GAP", 2,43.424310, -80.440011);
            data.addStoreToDataBase(store);
            store = new Store("Garage",2,43.424659, -80.439038);
            data.addStoreToDataBase(store);
            store = new Store("Gateway Newstands",2,43.424326, -80.438560);
            data.addStoreToDataBase(store);
            store = new Store("Greenearth", 2,43.424099, -80.438223);
            data.addStoreToDataBase(store);
            store = new Store("Guess", 2,43.424423, -80.439707);
            data.addStoreToDataBase(store);
            store = new Store("GymBoree",2,43.423955, -80.439324);
            data.addStoreToDataBase(store);
            store = new Store("Hollister", 2,43.424823, -80.439245);
            data.addStoreToDataBase(store);
            store = new Store("Hudson's Bay",2,43.423536, -80.440616);
            data.addStoreToDataBase(store);
            store = new Store("Jack Astor's Bar & Grill", 2,43.423571, -80.438959);
            data.addStoreToDataBase(store);
            store = new Store("Jean Machine",2,43.424520, -80.439014);
            data.addStoreToDataBase(store);
            store = new Store("Jimmy The Greek", 2,43.715009, -79.722265);
            data.addStoreToDataBase(store);
            store = new Store("Kernels",2,43.424012, -80.438439);
            data.addStoreToDataBase(store);
            store = new Store("TacoBell", 2,43.425206, -80.438540);
            data.addStoreToDataBase(store);
            store = new Store("KFC", 2,43.425206, -80.438540);
            data.addStoreToDataBase(store);
            store = new Store("Koodo", 2,43.424009, -80.439761);
            data.addStoreToDataBase(store);
            store = new Store("la Senza",2,43.424116, -80.439523);
            data.addStoreToDataBase(store);
            store = new Store("la Vie en Rose", 2,43.424451, -80.438045);
            data.addStoreToDataBase(store);
            store = new Store("Laura Second",2,43.424769, -80.438728);
            data.addStoreToDataBase(store);
            store = new Store("le Chateau", 2,43.424226, -80.438426);
            data.addStoreToDataBase(store);
            store = new Store("LensCrafters",2,43.423868, -80.440622);
            data.addStoreToDataBase(store);
            store = new Store("Lids", 2,43.423873, -80.438111);
            data.addStoreToDataBase(store);
            store = new Store("Mac Cosmetics", 2,43.424586, -80.438991);
            data.addStoreToDataBase(store);
            store = new Store("MetalSmiths",2,43.424093, -80.437994);
            data.addStoreToDataBase(store);
            store = new Store("Michael hill", 2,43.423915, -80.439942);
            data.addStoreToDataBase(store);
            store = new Store("Mint Fashion Accesories",2,43.423760, -80.439717);
            data.addStoreToDataBase(store);
            store = new Store("Natural Solutions",2,43.424408, -80.438090);
            data.addStoreToDataBase(store);
            store = new Store("NY Fries", 2,43.424907, -80.438867);
            data.addStoreToDataBase(store);
            store = new Store("Nutrition House",2,43.424816, -80.438674);
            data.addStoreToDataBase(store);
            store = new Store("Pandora", 2,43.424242, -80.439428);
            data.addStoreToDataBase(store);
            store = new Store("Payless",2,43.424335, -80.438598);
            data.addStoreToDataBase(store);
            store = new Store("Peoples Jewellery", 2,43.424093, -80.438887);
            data.addStoreToDataBase(store);
            store = new Store("Rogers",2,43.423759, -80.439815);
            data.addStoreToDataBase(store);
            store = new Store("Roots", 2,43.424508, -80.439646);
            data.addStoreToDataBase(store);
            store = new Store("RW & CO.", 2,43.424375, -80.439812);
            data.addStoreToDataBase(store);
            store = new Store("Sears",2,43.423780, -80.437622);
            data.addStoreToDataBase(store);
            store = new Store("Sephora", 2,43.424647, -80.438583);
            data.addStoreToDataBase(store);
            store = new Store("SoftMoc", 2,43.424134, -80.438314);
            data.addStoreToDataBase(store);
            store = new Store("Spring",2,43.424196, -80.438947);
            data.addStoreToDataBase(store);
            store = new Store("Subway",2,43.424935, -80.438923);
            data.addStoreToDataBase(store);
            store = new Store("sunglass hut", 2,43.424482, -80.439063);
            data.addStoreToDataBase(store);
            store = new Store("Swarovski", 2,43.423839, -80.439017);
            data.addStoreToDataBase(store);
            store = new Store("Swiss Chalet", 2,43.425044, -80.438947);
            data.addStoreToDataBase(store);
            store = new Store("Tbooth",2,43.423889, -80.438018);
            data.addStoreToDataBase(store);
            store = new Store("Telus",2,43.424464, -80.439140);
            data.addStoreToDataBase(store);
            store = new Store("ThaiExpress", 2,43.425244, -80.438595);
            data.addStoreToDataBase(store);
            store = new Store("The Body Shop", 2,43.424046, -80.439160);
            data.addStoreToDataBase(store);
            store = new Store("the Source",2,43.424452, -80.438135);
            data.addStoreToDataBase(store);
            store = new Store("Things Remembered", 2,43.423811, -80.438181);
            data.addStoreToDataBase(store);
            store = new Store("Tim Hortons",2,43.425318, -80.438726);
            data.addStoreToDataBase(store);
            store = new Store("Tommy Gun's Original Barbershop", 2,43.424016, -80.438175);
            data.addStoreToDataBase(store);
            store = new Store("Tonyc",2,43.423716, -80.439640);
            data.addStoreToDataBase(store);
            store = new Store("ToothWorks", 2,43.423925, -80.440256);
            data.addStoreToDataBase(store);
            store = new Store("TD", 2,43.423628, -80.439981);
            data.addStoreToDataBase(store);
            store = new Store("Torrid",2,43.424674, -80.438540);
            data.addStoreToDataBase(store);
            store = new Store("TownShoes", 2,43.424162, -80.440039);
            data.addStoreToDataBase(store);
            store = new Store("Umi Sushi",2,43.425181, -80.438787);
            data.addStoreToDataBase(store);
            store = new Store("Virgin Mobile", 2,43.423842, -80.439362);
            data.addStoreToDataBase(store);
            store = new Store("WALMART", 2,43.425473, -80.438032);
            data.addStoreToDataBase(store);
            store = new Store("WirelessWave",2,43.423875, -80.440140);
            data.addStoreToDataBase(store);
            store = new Store("yogen fruz", 2,43.424283, -80.438694);
            data.addStoreToDataBase(store);
            store = new Store("ZUMIEZ",2,43.424251, -80.437849);
            data.addStoreToDataBase(store);
        }
        return data;
    }

    public class ListAdapter extends RecyclerView.Adapter {
        ArrayList<Mall> mallArray = data.getMalls();
        ArrayList<Store> storeArray = data.getStores();

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mall_item,parent,false);
            return new ListViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((ListViewHolder) holder).setView(position);
        }

        @Override
        public int getItemCount() {
            return mallArray.size();
        }


        private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            private TextView mText;
            private ImageView mImage;
            private int aPosition;


            public ListViewHolder(View itemView){
                super(itemView);
                mText = (TextView)itemView.findViewById(R.id.itemText);
                mImage = (ImageView) itemView.findViewById(R.id.itemImage);
                itemView.setOnClickListener(this);
            }

            public void setView(int p){
                mText.setText(mallArray.get(p).getmMallId());
                Resources res = getResources();
                int resourceId = res.getIdentifier(mallArray.get(p).getImage(), "drawable", getPackageName());
                mImage.setImageResource(resourceId);
                aPosition = p;
            }

            public void onClick(View v){
                ArrayList<Store> sendStores = new ArrayList<>();
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra("LATITUDE", mallArray.get(aPosition).getLat());
                intent.putExtra("LONGITUDE", mallArray.get(aPosition).getLong());
                for (int i = 0; i < storeArray.size(); i++){
                    if (storeArray.get(i).getMall() == aPosition + 1){
                        sendStores.add(storeArray.get(i));
                    }
                }
                intent.putParcelableArrayListExtra("STORES", sendStores);
                startActivity(intent);
            }
        }
    }
}
