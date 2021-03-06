package com.meipan.library._ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.meipan.library.R;
import com.meipan.library._ui.dialog.ReadingMenuDialog;
import com.meipan.library.widget.Pager;
import com.meipan.library.widget.PagerFactory;

import butterknife.ButterKnife;

/**
 * 阅读页
 */
public class YueDuActivity extends BaseActivity {
    private Pager pager;
    private PagerFactory pagerFactory;
    private Bitmap currentBitmap, mCurPageBitmap, mNextPageBitmap;
    private Canvas mCurPageCanvas, mNextPageCanvas;
    private int[] pages1 = {R.drawable.ds001, R.drawable.ds002, R.drawable.ds003,R.drawable.ds004, R.drawable.ds003,R.drawable.ds004, R.drawable.ds003,R.drawable.ds004, R.drawable.ds003,R.drawable.ds004, R.drawable.ds003,R.drawable.ds004, R.drawable.ds003,R.drawable.ds004, R.drawable.ds003,R.drawable.ds004, R.drawable.ds003,R.drawable.ds004, R.drawable.ds003,R.drawable.ds004, R.drawable.ds003,R.drawable.ds004};
    private int[] pages2 = {R.drawable.ds005, R.drawable.ds006, R.drawable.ds007, R.drawable.ds006, R.drawable.ds007, R.drawable.ds006, R.drawable.ds007, R.drawable.ds006, R.drawable.ds007, R.drawable.ds006, R.drawable.ds007, R.drawable.ds006, R.drawable.ds007, R.drawable.ds006, R.drawable.ds007, R.drawable.ds006, R.drawable.ds007, R.drawable.ds006, R.drawable.ds007, R.drawable.ds006, R.drawable.ds007, R.drawable.ds006, R.drawable.ds007, R.drawable.ds006, R.drawable.ds007, R.drawable.ds006, R.drawable.ds007 };
    private int[] pages3 = {R.drawable.ds009, R.drawable.ds010, R.drawable.ds011 , R.drawable.ds010, R.drawable.ds011, R.drawable.ds010, R.drawable.ds011, R.drawable.ds010, R.drawable.ds011, R.drawable.ds010, R.drawable.ds011, R.drawable.ds010, R.drawable.ds011, R.drawable.ds010, R.drawable.ds011, R.drawable.ds010, R.drawable.ds011, R.drawable.ds010, R.drawable.ds011, R.drawable.ds010, R.drawable.ds011, R.drawable.ds010, R.drawable.ds011, R.drawable.ds010, R.drawable.ds011, R.drawable.ds010, R.drawable.ds011};
    private int[] pages4 = {R.drawable.ds013, R.drawable.ds014, R.drawable.ds015 , R.drawable.ds014, R.drawable.ds015 , R.drawable.ds014, R.drawable.ds015 , R.drawable.ds014, R.drawable.ds015 , R.drawable.ds014, R.drawable.ds015 , R.drawable.ds014, R.drawable.ds015 , R.drawable.ds014, R.drawable.ds015 , R.drawable.ds014, R.drawable.ds015 , R.drawable.ds014, R.drawable.ds015 , R.drawable.ds014, R.drawable.ds015 , R.drawable.ds014, R.drawable.ds015 , R.drawable.ds014, R.drawable.ds015 , R.drawable.ds014, R.drawable.ds015 };
    private int[] pages ={R.drawable.ds001, R.drawable.ds002, R.drawable.ds003,R.drawable.ds004, R.drawable.ds003,R.drawable.ds004, R.drawable.ds003,R.drawable.ds004, R.drawable.ds003,R.drawable.ds004, R.drawable.ds003,R.drawable.ds004, R.drawable.ds003,R.drawable.ds004, R.drawable.ds003,R.drawable.ds004, R.drawable.ds003,R.drawable.ds004, R.drawable.ds003,R.drawable.ds004, R.drawable.ds003,R.drawable.ds004};
    private int screenWidth;
    private int screenHeight;
    private boolean isFlip;
    private int mPageNumber = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yue_du);
        ButterKnife.bind(this);
        int p = getIntent().getIntExtra("book",0);
        switch (p){
            case 1:
            case 5:
            case 9:
                pages = pages1;
                break;
            case 2:
            case 6:
            case 10:
                pages = pages2;
                break;
            case 3:
            case 7:
            case 11:
                pages = pages3;
                break;
            case 4:
            case 8:
            case 12:
                pages = pages4;
                break;
            default:
                break;
        }
        initView();

    }

    private void initView() {

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels;
        pager = new Pager(this, screenWidth, screenHeight);

        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addContentView(pager, layoutParams);
        //当前页面图片
        mCurPageBitmap = Bitmap.createBitmap(screenWidth, screenHeight, Bitmap.Config.ARGB_8888);
        //下一页面
        mNextPageBitmap = Bitmap.createBitmap(screenWidth, screenHeight, Bitmap.Config.ARGB_8888);
        //画布
        mCurPageCanvas = new Canvas(mCurPageBitmap);
        mNextPageCanvas = new Canvas(mNextPageBitmap);

        pagerFactory = new PagerFactory(getApplicationContext());

        pager.setBitmaps(mCurPageBitmap, mNextPageBitmap);
        loadImage(mCurPageCanvas, mPageNumber);

        pager.setOnTouchListener(new View.OnTouchListener() {

            private int count = pages.length;
            private int currentIndex = mPageNumber;
            private int lastIndex = mPageNumber > 0?mPageNumber - 1:0;
            private Bitmap lastBitmap = null;

            @Override
            public boolean onTouch(View v, MotionEvent e) {
                boolean ret = false;
                if (v == pager) {
                    if (e.getAction() == MotionEvent.ACTION_DOWN) {

                        //判断弹出菜单 还是 翻页
                        if (dialog(e.getX(), e.getY())){
                            isFlip = false;
                            Log.i("TAGGG","菜单");
                        } else {
                            Log.i("TAGGG","翻页");
                            isFlip = true;
                            pager.calcCornerXY(e.getX(), e.getY());
//
                            lastBitmap = currentBitmap;
                            lastIndex = currentIndex;

                            pagerFactory.onDraw(mCurPageCanvas, currentBitmap);
                            if (pager.DragToRight()) {    // 向右滑动，显示前一页
                                if (currentIndex == 0) return false;
                                Log.i("TAGGG","向右滑动");
                                pager.abortAnimation();
                                currentIndex--;
                                loadImage(mNextPageCanvas, currentIndex);
                            } else {        // 向左滑动，显示后一页
                                if (currentIndex + 1 == count) return false;
                                Log.i("TAGGG","向左滑动");
                                pager.abortAnimation();
                                currentIndex++;
                                loadImage(mNextPageCanvas, currentIndex);
                            }
                        }
                    } else if (e.getAction() == MotionEvent.ACTION_MOVE) {

                    } else if (e.getAction() == MotionEvent.ACTION_UP) {
                        if (isFlip){
                            if (!pager.canDragOver() && isFlip) {
                                Log.i("TAGGG","这个是什么");
                                currentIndex = lastIndex;
                                currentBitmap = lastBitmap;
                                isFlip = false;
                            }
                        } else {
                            if (dialog(e.getX(), e.getY()) && !isFlip){
                                Log.i("TAGGG","菜单位置");
                                ReadingMenuDialog dialog = ReadingMenuDialog.getInstance("ss");
                                dialog.show(getSupportFragmentManager(),"main");
                                isFlip = false;
                            }
                        }

                    }

                    ret = pager.doTouchEvent(e);

                    return ret;
                }
                return false;
            }
        });
    }


    private void loadImage(final Canvas canvas, int index) {
        Log.i("TAGGG","loadImage()   "+index);

        Bitmap bitmap = getBitmap(pages[index]);
        currentBitmap = bitmap;
        pagerFactory.onDraw(canvas, bitmap);
        pager.setBitmaps(mCurPageBitmap, mNextPageBitmap);
        pager.postInvalidate();
    }

    //得到资源图片图片
    private Bitmap getBitmap(int name) {

        Bitmap tempBitmap =  BitmapFactory.decodeResource(this.getResources(), name);

        int width = tempBitmap.getWidth();
        int height = tempBitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) screenWidth) / width, ((float) screenHeight) / height);
        Bitmap bitmap = Bitmap.createBitmap(tempBitmap, 0, 0, width, height, matrix, true);
        return getBitmapTest(bitmap);
       // return bitmap;
    }
    //与背景合成
    public Bitmap getBitmapTest(Bitmap bm){
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.background);

        Bitmap alertBitmap = Bitmap.createBitmap(screenWidth, screenHeight, bitmap.getConfig());
        Canvas canvas = new Canvas(alertBitmap);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawBitmap(bitmap, new Matrix(), paint);
        Bitmap ic_luncher = bm;//BitmapFactory.decodeResource(getResources(),R.drawable.welcome_bg);
        canvas.drawBitmap(ic_luncher,new Matrix(),paint);
        return alertBitmap;
    }

    public boolean dialog(float x,float y){
        if (x > screenWidth / 3 && x < screenWidth - screenWidth / 3 && y > 200 && y < screenHeight - 200)
            return true;
        return false;

    }
}
