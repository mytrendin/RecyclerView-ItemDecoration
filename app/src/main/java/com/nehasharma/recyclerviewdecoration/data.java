package com.nehasharma.recyclerviewdecoration;

import android.app.LauncherActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shree on 5/25/2017.
 */

public class data {

    private static final String[] name = {"Name 1","Name 2", "Name 3"};
    private static final int[] image = {android.R.drawable.ic_media_play,android.R.drawable.ic_btn_speak_now,android.R.drawable.ic_popup_reminder};

    public static List<ListItems> getListData(){
        List<ListItems> data = new ArrayList<>();

        for(int x =0;x<8;x++){
            for(int i=0;i<name.length && i<image.length;i++){
                ListItems items = new ListItems();
                items.setImage(image[i]);
                items.setName(name[i]);
                data.add(items);

            }
        }
        return data;
    }
}
