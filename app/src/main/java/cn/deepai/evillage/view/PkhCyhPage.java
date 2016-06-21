package cn.deepai.evillage.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import cn.deepai.evillage.R;

/**
 * @author GaoYixuan
 */
public class PkhCyhPage extends PkhBasePage{

    public PkhCyhPage(Context context) {
        this(context,null);
    }
    public PkhCyhPage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PkhCyhPage(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    @Override
    public String getPageName() {
        return getResources().getString(R.string.pkh_cyh);
    }

    private void initView() {

    }
}