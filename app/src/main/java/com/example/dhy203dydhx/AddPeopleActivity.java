package com.example.dhy203dydhx;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPeopleActivity extends Activity {
    private EditText edt_name;
    private EditText edt_phone;
    private EditText edt_mobile;
    private EditText edt_email;
    private Button bt_save;
    String name,phone,mobile,email;
    DbHelper dbhelper;
    SQLiteDatabase db;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addpeople);

        edt_name=(EditText)findViewById(R.id.edt_name);
        edt_phone=(EditText)findViewById(R.id.edt_phone);
        edt_mobile=(EditText)findViewById(R.id.edt_mobile);
        edt_email=(EditText)findViewById(R.id.edt_email);
        bt_save=(Button)findViewById(R.id.bt_save);

        bundle=this.getIntent().getExtras();
        if(bundle!=null)
        {
            edt_name.setText(bundle.getString("name"));
            edt_phone.setText(bundle.getString("phone"));
            edt_mobile.setText(bundle.getString("mobile"));
            edt_email.setText(bundle.getString("email"));
        }
        bt_save.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                name=edt_name.getText().toString();
                phone=edt_phone.getText().toString();
                mobile=edt_mobile.getText().toString();
                email=edt_email.getText().toString();

                ContentValues value=new ContentValues();
                value.put("name", name);
                value.put("phone", phone);
                value.put("mobile", mobile);
                value.put("email", email);
                DbHelper dbhelper = new DbHelper(AddPeopleActivity.this, "Db_People",null, 1);
                SQLiteDatabase db=dbhelper.getWritableDatabase();
                long status;
                if(bundle!=null)
                {
                    status=db.update("tb_people", value, "_id=?", new String[]{bundle.getLong("id")+""});
                }
                else
                {
                    status=db.insert("tb_people", null, value);
                }
                if(status!=-1)
                {
                    Toast.makeText(AddPeopleActivity.this, "保存成功", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(AddPeopleActivity.this, "保存失败", Toast.LENGTH_LONG).show();
                }
                db.close();
            }
        });
    }
}

