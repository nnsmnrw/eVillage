package cn.deepai.evillage.viewholder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.deepai.evillage.R;
import cn.deepai.evillage.controller.activity.PkhjtcyActivity;
import cn.deepai.evillage.controller.activity.PkhxqActivity;
import cn.deepai.evillage.model.PkhjtcyBean;

/**
 * 贫困户家庭成员
 */
public class PkhjtcyViewHolder extends BaseViewHolder {

    private Context mContext;
    private PkhjtcyBean mPkhjtcyBean;
    public TextView xm;
    public TextView xb;
    public TextView id;
    public TextView gx;

    public PkhjtcyViewHolder(ViewGroup parent, int viewType) {
        super(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_pkhjtcy,parent,false));
        mContext = parent.getContext();
        xm = (TextView)itemView.findViewById(R.id.item_pkhjtcy_xm);
        xb = (TextView)itemView.findViewById(R.id.item_pkhjtcy_xb);
        id = (TextView)itemView.findViewById(R.id.item_pkhjtcy_id);
        gx = (TextView)itemView.findViewById(R.id.item_pkhjtcy_gx);
    }

    public void onBindData(PkhjtcyBean pkhjtcyBean) {
        this.mPkhjtcyBean = pkhjtcyBean;
        xm.setText(pkhjtcyBean.getXm());
        xb.setText(pkhjtcyBean.getXb());
        id.setText(pkhjtcyBean.getSfzhm());
        gx.setText(pkhjtcyBean.getYhzgx());
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        mPkhjtcyBean.getId();
        Intent intent = new Intent(mContext, PkhjtcyActivity.class);
        mContext.startActivity(intent);
        ((Activity)mContext).overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
    }
}