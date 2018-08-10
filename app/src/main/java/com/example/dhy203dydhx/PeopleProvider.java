package com.example.dhy203dydhx;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;

public class PeopleProvider extends ContentProvider {
    private static final int ITEMS=1;
    private static final int ITEM_ID=2;
    public static final String DbName="Db_People";
    public static final String TableName="tb_people";
    DbHelper dbhelper;
    SQLiteDatabase db;
    public static final String CONTENT_ITEMS_TYPE = "vnd.android.cursor.items/com.example.dhy203dydhx.Db_People";
    public static final String CONTENT_ITEMID_TYPE = "vnd.android.cursor.itemid/com.example.dhy203dydhx.Db_People";
    public static final Uri CONTENT_URI = Uri.parse("content://com.example.dhy203dydhx.Db_People/tb_people");
    private static final UriMatcher sMatcher;
    static
    {
        sMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        sMatcher.addURI("com.example.dhy203dydhx.Db_People", TableName, ITEMS);
        sMatcher.addURI("com.example.dhy203dydhx.Db_People", TableName+"/#",ITEM_ID);
    }
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        db = dbhelper.getWritableDatabase();
        int count = 0;
        switch (sMatcher.match(uri)) {
            case ITEMS:
                count = db.delete("tb_people",selection, selectionArgs);
                break;
            case ITEM_ID:
                String id = uri.getPathSegments().get(1);
                count = db.delete("tb_people", "_ID="+id+(!TextUtils.isEmpty("_ID=?")?"AND("+selection+')':""), selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI"+uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
    @Override
    public String getType(Uri uri) {
        // TODO Auto-generated method stub
        switch (sMatcher.match(uri)) {
            case ITEMS:
                return CONTENT_ITEMS_TYPE;
            case ITEM_ID:
                return CONTENT_ITEMID_TYPE;
            default:
                throw new IllegalArgumentException("Unknown URI"+uri);
        }
    }
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        db = dbhelper.getWritableDatabase();
        long rowId;
        if(sMatcher.match(uri)!=ITEMS){
            throw new IllegalArgumentException("Unknown URI"+uri);
        }
        rowId = db.insert("tb_people","_ID",values);
        if(rowId>0)
        {
            Uri noteUri=ContentUris.withAppendedId(CONTENT_URI, rowId);
            getContext().getContentResolver().notifyChange(noteUri, null);
            return noteUri;
        }
        throw new IllegalArgumentException("Unknown URI"+uri);
    }
    @Override
    public boolean onCreate() {
        // TODO Auto-generated method stub
        dbhelper=new DbHelper(this.getContext(), "Db_People",null, 1);
        return true;
    }
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        db = dbhelper.getReadableDatabase();
        Cursor c;
        switch (sMatcher.match(uri)) {
            case ITEMS:
                c = db.query("tb_people", projection, selection, selectionArgs, null, null, null);
                break;
            case ITEM_ID:
                String id = uri.getPathSegments().get(1);
                c = db.query("tb_people", projection, "_ID="+id+(!TextUtils.isEmpty(selection)?"AND("+selection+')':""),selectionArgs, null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI"+uri);
        }
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }
    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        db = dbhelper.getWritableDatabase();
        int count = 0;
        switch (sMatcher.match(uri)) {
            case ITEMS:
                count = db.update("tb_people",values,selection, selectionArgs);
                break;
            case ITEM_ID:
                String id = uri.getPathSegments().get(1);
                count = db.update("tb_people", values, "_ID="+id+(!TextUtils.isEmpty("_ID=?")?"AND("+selection+')':""), selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI"+uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}
