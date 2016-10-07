package com.example.hp.custom_listview_task;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv_students;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_students = (ListView) findViewById(R.id.lv_students);
        final List<Students> data = DataProvider.getData();

        ArrayAdapter<Students> adapter = new customArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,data);
        lv_students.setAdapter(adapter);
        lv_students.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Students students = data.get(position);

                Intent intent = new Intent(MainActivity.this,Detail.class);
                intent.putExtra("name",students.getName());
                intent.putExtra("id",students.getId());
                intent.putExtra("designation",students.getDesignation());
                intent.putExtra("qualification",students.getQualification());
                intent.putExtra("experties",students.getExperties());
                intent.putExtra("contact",students.getContact());

                startActivity(intent);
            }
        });
    }

    class customArrayAdapter extends ArrayAdapter<Students>{

        Context context;
        List<Students> objects;
        public customArrayAdapter(Context context, int resource, List<Students> objects) {
            super(context, resource, objects);

            this.context = context;
            this.objects = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Students students = objects.get(position);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.mylayout,null);

            ImageView iv = (ImageView) view.findViewById(R.id.custom_iv);
            int res = context.getResources().getIdentifier("cartoon_" +students.getId(), "drawable", context.getPackageName());
            iv.setImageResource(res);

            TextView tv = (TextView) view.findViewById(R.id.custom_tv);
            tv.setText(students.getName());
            return view;
        }
    }
}
