package com.weathercloset.sunkyoung.wcmain_2019;

import android.graphics.drawable.Drawable;

public class RecyclerViewItem {

    private Drawable icon ;
    private String count;
  //  private String titleStr ;

    public Drawable getIcon() {
        return icon;
    }

    public RecyclerViewItem(Drawable icon, String count) {
        this.icon = icon;
        this.count = count;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
