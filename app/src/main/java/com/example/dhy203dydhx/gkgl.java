package com.example.dhy203dydhx;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class gkgl extends AppCompatActivity {
    /** Called when the activity is first created. */
    private ListView list_people;
    private DbHelper dbhelper;
    private SQLiteDatabase db;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gkgl_jm);

        list_people=(ListView)findViewById(R.id.list_people);

        dbhelper=new DbHelper(this, "Db_People",null, 1);
        db=dbhelper.getReadableDatabase();
        Cursor c=db.query("tb_people", new String[]{"_id","name","phone","mobile","email"}, null, null,null,null,null);
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,
                R.layout.peoplelist,
                c,
                new String[]{"_id","name","phone","mobile","email"},
                new int[]{R.id.id,R.id.name,R.id.phone,R.id.mobile,R.id.email});
        this.list_people.setAdapter(adapter);

        this.registerForContextMenu(list_people);
        db.close();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        menu.add(Menu.NONE, Menu.FIRST + 1, 1, "添加").setIcon(android.R.drawable.ic_menu_add);
        menu.add(Menu.NONE, Menu.FIRST + 2, 2, "退出").setIcon(android.R.drawable.ic_menu_delete);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case Menu.FIRST + 1:Intent intent=new Intent();
                intent.setClass(gkgl.this, AddPeopleActivity.class);
                startActivity(intent);
                break;
            case Menu.FIRST + 2:finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo)
    {
        // TODO Auto-generated method stub
        menu.setHeaderIcon(R.drawable.ic_home_black_24dp);
        menu.add(0,3,0,"修改");
        menu.add(0,4,0,"删除");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        AdapterContextMenuInfo menuInfo = (AdapterContextMenuInfo) item.getMenuInfo();
        // TODO Auto-generated method stub
        switch(item.getItemId())
        {
            case 3:
                String name = ((TextView) menuInfo.targetView.findViewById(R.id.name)).getText().toString();
                String phone = ((TextView) menuInfo.targetView.findViewById(R.id.phone)).getText().toString();
                String mobile = ((TextView) menuInfo.targetView.findViewById(R.id.mobile)).getText().toString();
                String email = ((TextView) menuInfo.targetView.findViewById(R.id.email)).getText().toString();
                Intent intent=new Intent();
                intent.setClass(gkgl.this, AddPeopleActivity.class);
                Bundle bundle=new Bundle();
                bundle.putLong("id", menuInfo.id);
                bundle.putString("name",name);
                bundle.putString("phone",phone);
                bundle.putString("mobile", mobile);
                bundle.putString("email", email);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case 4:
                dbhelper=new DbHelper(this, "Db_People",null, 1);
                db=dbhelper.getReadableDatabase();
                db.delete("tb_people","_id=?", new String[]{menuInfo.id+""});
                db.close();
                break;
        }
        return true;
    }
}