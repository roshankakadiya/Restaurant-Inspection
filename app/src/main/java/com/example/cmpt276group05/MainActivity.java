package com.example.cmpt276group05;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cmpt276group05.model.Inspection;
import com.example.cmpt276group05.model.InspectionManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private InspectionManager inspectionManager;
    private List<Inspection> myInspection=new ArrayList<Inspection>();

    ListView listview;
    ArrayList<String> instype=new ArrayList<String>();
    int [] cricissues = new int[10] ;
    int [] noncricissues=new int[10];
    ArrayList<String> hazardlevel=new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inspectionManager=InspectionManager.getInstance(this);
        myInspection=inspectionManager.getList("SDFO-8HKP7E");

        listview=(ListView) findViewById(R.id.InspectionListview);

        for(int i=0; i<myInspection.size();i++){

            instype.add(myInspection.get(i).getInspectionType());
            cricissues[i]=myInspection.get(i).getNumCritViolations();
            noncricissues[i]=myInspection.get(i).getNumNonCritViolations();
            hazardlevel.add(myInspection.get(i).getHazardRating());

        }

        MyAdapter adapter=new MyAdapter(this,instype,cricissues,noncricissues,hazardlevel);


         listview.setAdapter(adapter);

    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String inspectionType[];
        int cricviolations [];
        int noncricviolations[];
        String hazardlevels[];

        MyAdapter(Context c,ArrayList <String> type,int numcricviolations[],int numnoncricviolations[],ArrayList <String> hazardstring){
            super(c,R.layout.rowofinspection,R.id.instypetextview,type);
            this.context=c;
            this.inspectionType=type.toArray(new String[0]);
            this.cricviolations=cricissues;
            this.noncricviolations=noncricissues;
            this.hazardlevels=hazardstring.toArray(new String[0]);


        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater)getApplication().getSystemService(LAYOUT_INFLATER_SERVICE);
            View row=layoutInflater.inflate(R.layout.rowofinspection,parent,false);
            TextView typeofInspection=row.findViewById(R.id.instypetextview);
            TextView numberofcricviolations=row.findViewById(R.id.criticalissuetextview);
            TextView numberofnoncricviolations=row.findViewById(R.id.noncriticalissuetextview);
            TextView hazardl=row.findViewById(R.id.hazardlevltextview);

            typeofInspection.setText(inspectionType[position]);
            numberofcricviolations.setText(""+cricviolations[position]);
            numberofnoncricviolations.setText(""+noncricviolations[position]);
            hazardl.setText(hazardlevels[position]);



            return row;
        }
    }
}