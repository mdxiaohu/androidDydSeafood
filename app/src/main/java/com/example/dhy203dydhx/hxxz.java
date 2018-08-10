package com.example.dhy203dydhx;


import android.os.Bundle;
        import android.app.Activity;
        import android.content.Context;
        import android.view.Menu;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.AdapterView.OnItemClickListener;
        import android.widget.BaseAdapter;
        import android.widget.Gallery;
        import android.widget.ImageView;
        import android.widget.Toast;

public class hxxz extends Activity {

    /** Called when the activity is first created. */
    private Gallery mGallery;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hxzs_jm);


        mGallery = (Gallery)findViewById(R.id.mygallery);
        mGallery.setAdapter(new ImageAdapter(this));
        mGallery.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,  long arg3)
            {
                Toast.makeText(hxxz.this, "点击了第"+(arg2+1)+"张图片", Toast.LENGTH_LONG).show();
            }
        });
    }

}
class ImageAdapter extends BaseAdapter{
    private Context mContext;
    private Integer[] mImage = {
            R.drawable.simple1,
            R.drawable.simple2,
            R.drawable.simple3,
            R.drawable.simple4,
            R.drawable.simple5,
            R.drawable.simple6,
            R.drawable.simple7,
            R.drawable.simple8,
            R.drawable.simple9,
            R.drawable.simple10
    };
    public ImageAdapter(Context c){
        mContext = c;
    }
    @Override
    public int getCount() {
        return mImage.length;
    }
    @Override
    public Object getItem(int position) {
        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ImageView i = new ImageView (mContext);
        i.setImageResource(mImage[position]);
        i.setScaleType(ImageView.ScaleType.FIT_XY);
        i.setLayoutParams(new Gallery.LayoutParams(400, 400));
        return i;
    }
};

