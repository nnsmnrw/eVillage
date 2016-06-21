package cn.deepai.evillage.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import cn.deepai.evillage.R;

/**
 * 生活条件
 */
public class PkhShtjPage extends PkhBasePage{

    public PkhShtjPage(Context context) {
        this(context,null);
    }
    public PkhShtjPage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PkhShtjPage(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        LayoutInflater.from(context).inflate(R.layout.page_pkhshtj, this);
        initView();
    }

    @Override
    public String getPageName() {
        return getResources().getString(R.string.pkh_shtj);
    }

    private void initView() {

    }
}
