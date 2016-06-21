package cn.deepai.evillage.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * @author GaoYixuan
 */
public abstract class PkhBasePage  extends FrameLayout {

    protected Context mContext;

    public PkhBasePage(Context context) {
        this(context, null);
    }

    public PkhBasePage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PkhBasePage(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
    }

    public abstract String getPageName();

}