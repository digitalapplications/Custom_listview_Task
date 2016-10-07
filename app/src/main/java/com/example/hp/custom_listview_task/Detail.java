package com.example.hp.custom_listview_task;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    TextView tv_name,tv_designation,tv_qualification,tv_experties,tv_contact;
    ImageView iv,iv_message,iv_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String name = getIntent().getStringExtra("name");
        String designation = getIntent().getStringExtra("designation");
        String qualification = getIntent().getStringExtra("qualification");
        String experties = getIntent().getStringExtra("experties");
        int contact = getIntent().getIntExtra("contact", 0);
        int id = getIntent().getIntExtra("id",1001);

        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_designation = (TextView) findViewById(R.id.tv_designation);
        tv_qualification = (TextView) findViewById(R.id.tv_qualification);
        tv_experties = (TextView) findViewById(R.id.tv_experties);
        tv_contact = (TextView) findViewById(R.id.tv_contact);
        iv_message = (ImageView) findViewById(R.id.iv_message);
        iv_phone = (ImageView) findViewById(R.id.iv_phone);

        iv_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", tv_contact.getText());
                smsIntent.putExtra("sms_body","Hello "+tv_name.getText());
                startActivity(smsIntent);
            }
        });

        iv_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+tv_contact.getText()));
                startActivity(intent);
            }
        });

        iv = (ImageView) findViewById(R.id.iv_student);
        int res = getApplication().getResources().getIdentifier("cartoon_" + id, "drawable", getApplication().getPackageName());
        iv.setImageResource(res);


        tv_name.setText(name);
        tv_designation.setText(designation);
        tv_qualification.setText(qualification);
        tv_experties.setText(experties);
        tv_contact.setText(contact+"");
    }
}
