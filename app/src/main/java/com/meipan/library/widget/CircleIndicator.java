package com.meipan.library.widget;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.AnimatorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

import me.relex.circleindicator.R.animator;
import me.relex.circleindicator.R.drawable;
import me.relex.circleindicator.R.styleable;

/**
 * setViewPager(ViewPager，int)的方法，解决Max循环的问题
 */
public class CircleIndicator extends LinearLayout implements OnPageChangeListener {
    private static final int DEFAULT_INDICATOR_WIDTH = 5;
    private ViewPager mViewpager;
    private int mIndicatorMargin = -1;
    private int mIndicatorWidth = -1;
    private int mIndicatorHeight = -1;
    private int mAnimatorResId;
    private int mAnimatorReverseResId;
    private int mIndicatorBackgroundResId;
    private int mIndicatorUnselectedBackgroundResId;
    private int mCurrentPosition;
    private Animator mAnimationOut;
    private Animator mAnimationIn;

    public CircleIndicator(Context context) {
        super(context);
        this.mAnimatorResId = animator.scale_with_alpha;
        this.mAnimatorReverseResId = 0;
        this.mIndicatorBackgroundResId = drawable.white_radius;
        this.mIndicatorUnselectedBackgroundResId = drawable.white_radius;
        this.mCurrentPosition = 0;
        this.init(context, (AttributeSet) null);
    }

    public CircleIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mAnimatorResId = animator.scale_with_alpha;
        this.mAnimatorReverseResId = 0;
        this.mIndicatorBackgroundResId = drawable.white_radius;
        this.mIndicatorUnselectedBackgroundResId = drawable.white_radius;
        this.mCurrentPosition = 0;
        this.init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        this.setOrientation(LinearLayout.HORIZONTAL);
        this.setGravity(17);
        this.handleTypedArray(context, attrs);
        this.checkIndicatorConfig(context);
    }

    private void handleTypedArray(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, styleable.CircleIndicator);
            this.mIndicatorWidth = typedArray.getDimensionPixelSize(styleable.CircleIndicator_ci_width, -1);
            this.mIndicatorHeight = typedArray.getDimensionPixelSize(styleable.CircleIndicator_ci_height, -1);
            this.mIndicatorMargin = typedArray.getDimensionPixelSize(styleable.CircleIndicator_ci_margin, -1);
            this.mAnimatorResId = typedArray.getResourceId(styleable.CircleIndicator_ci_animator, animator.scale_with_alpha);
            this.mAnimatorReverseResId = typedArray.getResourceId(styleable.CircleIndicator_ci_animator_reverse, 0);
            this.mIndicatorBackgroundResId = typedArray.getResourceId(styleable.CircleIndicator_ci_drawable, drawable.white_radius);
            this.mIndicatorUnselectedBackgroundResId = typedArray.getResourceId(styleable.CircleIndicator_ci_drawable_unselected, this.mIndicatorBackgroundResId);
            typedArray.recycle();
        }
    }

    public void configureIndicator(int indicatorWidth, int indicatorHeight, int indicatorMargin) {
        this.configureIndicator(indicatorWidth, indicatorHeight, indicatorMargin, animator.scale_with_alpha, 0, drawable.white_radius, drawable.white_radius);
    }

    public void configureIndicator(int indicatorWidth, int indicatorHeight, int indicatorMargin, @AnimatorRes int animatorId, @AnimatorRes int animatorReverseId, @DrawableRes int indicatorBackgroundId, @DrawableRes int indicatorUnselectedBackgroundId) {
        this.mIndicatorWidth = indicatorWidth;
        this.mIndicatorHeight = indicatorHeight;
        this.mIndicatorMargin = indicatorMargin;
        this.mAnimatorResId = animatorId;
        this.mAnimatorReverseResId = animatorReverseId;
        this.mIndicatorBackgroundResId = indicatorBackgroundId;
        this.mIndicatorUnselectedBackgroundResId = indicatorUnselectedBackgroundId;
        this.checkIndicatorConfig(this.getContext());
    }

    private void checkIndicatorConfig(Context context) {
        this.mIndicatorWidth = this.mIndicatorWidth < 0 ? this.dip2px(5.0F) : this.mIndicatorWidth;
        this.mIndicatorHeight = this.mIndicatorHeight < 0 ? this.dip2px(5.0F) : this.mIndicatorHeight;
        this.mIndicatorMargin = this.mIndicatorMargin < 0 ? this.dip2px(5.0F) : this.mIndicatorMargin;
        this.mAnimatorResId = this.mAnimatorResId == 0 ? animator.scale_with_alpha : this.mAnimatorResId;
        this.mAnimationOut = AnimatorInflater.loadAnimator(context, this.mAnimatorResId);
        if (this.mAnimatorReverseResId == 0) {
            this.mAnimationIn = AnimatorInflater.loadAnimator(context, this.mAnimatorResId);
            this.mAnimationIn.setInterpolator(new ReverseInterpolator());
        } else {
            this.mAnimationIn = AnimatorInflater.loadAnimator(context, this.mAnimatorReverseResId);
        }

        this.mIndicatorBackgroundResId = this.mIndicatorBackgroundResId == 0 ? drawable.white_radius : this.mIndicatorBackgroundResId;
        this.mIndicatorUnselectedBackgroundResId = this.mIndicatorUnselectedBackgroundResId == 0 ? this.mIndicatorBackgroundResId : this.mIndicatorUnselectedBackgroundResId;
    }

    public void setViewPager(ViewPager viewPager, int count) {
        setCount(count);
        setViewPager(viewPager);
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewpager = viewPager;
        this.mCurrentPosition = this.mViewpager.getCurrentItem() % (getCount(viewPager) == 0 ? 1 :getCount(viewPager));
        this.createIndicators(viewPager);
        this.mViewpager.removeOnPageChangeListener(this);
        this.mViewpager.addOnPageChangeListener(this);
        this.onPageSelected(this.mCurrentPosition);
    }

    /**
     * @deprecated
     */
    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.mViewpager == null) {
            throw new NullPointerException("can not find Viewpager , setViewPager first");
        } else {
            this.mViewpager.removeOnPageChangeListener(onPageChangeListener);
            this.mViewpager.addOnPageChangeListener(onPageChangeListener);
        }
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    public void onPageSelected(int position) {
        if (this.mViewpager.getAdapter() != null && getCount(this.mViewpager) > 0) {
            position = position % getCount(mViewpager);
            if (this.mAnimationIn.isRunning()) {
                this.mAnimationIn.end();
            }

            if (this.mAnimationOut.isRunning()) {
                this.mAnimationOut.end();
            }

            View currentIndicator = this.getChildAt(this.mCurrentPosition);
            currentIndicator.setBackgroundResource(this.mIndicatorUnselectedBackgroundResId);
            this.mAnimationIn.setTarget(currentIndicator);
            this.mAnimationIn.start();
            View selectedIndicator = this.getChildAt(position);
            selectedIndicator.setBackgroundResource(this.mIndicatorBackgroundResId);
            this.mAnimationOut.setTarget(selectedIndicator);
            this.mAnimationOut.start();
            this.mCurrentPosition = position;
        }
    }

    public void onPageScrollStateChanged(int state) {
    }

    private void createIndicators(ViewPager viewPager) {
        this.removeAllViews();
        if (viewPager.getAdapter() != null) {
            int count = getCount(viewPager);
            if (count > 0) {
                this.addIndicator(this.mIndicatorBackgroundResId, this.mAnimationOut);

                for (int i = 1; i < count; ++i) {
                    this.addIndicator(this.mIndicatorUnselectedBackgroundResId, this.mAnimationIn);
                }

            }
        }
    }

    private void addIndicator(@DrawableRes int backgroundDrawableId, Animator animator) {
        if (animator.isRunning()) {
            animator.end();
        }

        View Indicator = new View(this.getContext());
        Indicator.setBackgroundResource(backgroundDrawableId);
        this.addView(Indicator, this.mIndicatorWidth, this.mIndicatorHeight);
        LayoutParams lp = (LayoutParams) Indicator.getLayoutParams();
        lp.leftMargin = this.mIndicatorMargin;
        lp.rightMargin = this.mIndicatorMargin;
        Indicator.setLayoutParams(lp);
        animator.setTarget(Indicator);
        animator.start();
    }

    public int dip2px(float dpValue) {
        float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5F);
    }

    private class ReverseInterpolator implements Interpolator {
        private ReverseInterpolator() {
        }

        public float getInterpolation(float value) {
            return Math.abs(1.0F - value);
        }
    }

    private int mCount = 0;

    private int getCount(ViewPager viewPager) {
        return mCount > 0 ? mCount : viewPager.getAdapter().getCount();
    }

    public void setCount(int count) {
        mCount = count;
    }

}
