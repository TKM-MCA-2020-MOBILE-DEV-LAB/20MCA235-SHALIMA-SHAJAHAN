package com.example.co4_q1gridalert;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class ImageAdapter extends BaseAdapter {
   private Context mContext;
   public ImageAdapter(Context c) {
       mContext = c;
   }
   public int getCount() {
       return thumbImages.length;
   }
   public Object getItem(int position) {
       return null;
   }
   public long getItemId(int position) {
       return 0;
   }
   public View getView(int position, View convertView, ViewGroup parent) {
       ImageView imageView = new ImageView(mContext);
       imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
       imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
       imageView.setPadding(8, 8, 8, 8);
       imageView.setImageResource(thumbImages[position]);
       return imageView;
   }

   public Integer[] thumbImages = {
           R.drawable.d1,
           R.drawable.d2,
           R.drawable.d3
   };
}
