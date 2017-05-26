package com.nehasharma.recyclerviewdecoration;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class RVItemDecoration extends RecyclerView.ItemDecoration{

    private Paint paintCyan;
    private int offset;
    Bitmap bitmap;
    int bitmap_w, bitmap_h;
    Rect rectSrc;

    public RVItemDecoration(Context c){
        offset = 10;

        paintCyan = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintCyan.setColor(Color.CYAN);
        paintCyan.setStyle(Paint.Style.STROKE);
        paintCyan.setStrokeWidth(5);

        bitmap = BitmapFactory.decodeResource(
                c.getResources(),
                android.R.drawable.ic_dialog_dialer);
        bitmap_w = bitmap.getWidth();
        bitmap_h = bitmap.getHeight();
        rectSrc = new Rect(0, 0, bitmap_w, bitmap_h);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(offset, offset, offset, offset);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
       /* c.drawBitmap(bitmap,
                rectSrc,
                new Rect(
                        c.getWidth()-(2*bitmap_w),
                        c.getHeight()-(2*bitmap_h),
                        c.getWidth(),
                        c.getHeight()),
                null);*/
        final RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();

        for(int i=0; i<parent.getChildCount(); i++){

            final View child = parent.getChildAt(i);

            c.drawRoundRect(layoutManager.getDecoratedLeft(child) + offset,
                    layoutManager.getDecoratedTop(child) + offset,
                    layoutManager.getDecoratedRight(child) - offset,
                    layoutManager.getDecoratedBottom(child) - offset,
                    15,
                    15,
                    paintCyan);
        }
    }
}
