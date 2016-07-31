package cn.deepai.evillage.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import cn.deepai.evillage.R;
import cn.deepai.evillage.adapter.PkhjtcyRecyclerAdapter;
import cn.deepai.evillage.controller.activity.PkhjtcyActivity;
import cn.deepai.evillage.manager.DialogManager;
import cn.deepai.evillage.model.bean.PkhRequestBean;
import cn.deepai.evillage.model.bean.PkhjtcyBean;
import cn.deepai.evillage.model.bean.PkhjtcyList;
import cn.deepai.evillage.model.bean.RequestHeaderBean;
import cn.deepai.evillage.model.event.JdDataSaveEvent;
import cn.deepai.evillage.model.event.PagexjItemEvent;
import cn.deepai.evillage.net.Action;
import cn.deepai.evillage.net.EVRequest;
import cn.deepai.evillage.net.ResponseCallback;
import de.greenrobot.event.EventBus;

/**
 * @author GaoYixuan
 */
public class JdJtcyPage extends BasePage {

    private PkhjtcyRecyclerAdapter mPkhjtcyRecyclerAdapter;
    private RecyclerView mRecyclerView;
    public JdJtcyPage(Context context) {
        this(context, null);
    }

    public JdJtcyPage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public JdJtcyPage(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        LayoutInflater.from(context).inflate(R.layout.page_recycerview, this);
        initView();
    }

    @Override
    public void registeEventBus() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void unRegisteEventBus() {
        EventBus.getDefault().unregister(this);
    }

    @SuppressWarnings("all")
    public void onEventMainThread(PkhjtcyList event) {
        if (isSelected()) {
            mPkhjtcyRecyclerAdapter.notifyResult(true, event.list);
            mHasData = true;
        }
    }

    @SuppressWarnings("all")
    public void onEventMainThread(PagexjItemEvent event) {
        if (isSelected()) {
            Intent intent = new Intent(mContext, PkhjtcyActivity.class);
            intent.putExtra("editable",true);
            mContext.startActivity(intent);
            ((Activity)mContext).overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
            mHasData = true;
        }
    }
    // 点击保存按钮
    @SuppressWarnings("all")
    public void onEvent(JdDataSaveEvent event) {
//        localData.setHzxm(hzxm.getText().toString());
//        localData.setJzdz(jzdz.getText().toString());
//        localData.setLxdh(lxdh.getText().toString());
//        localData.setHzsfz(hzsfz.getText().toString());
//        localData.setHkhyx(hkhyx.getText().toString());
//        localData.setYxzh(yxzh.getText().toString());
//        localData.setPkhzt(pkhzt.getText().toString());
//        localData.setTpnf(tpnf.getText().toString());
    }

    @Override
    public void requestData() {

        final Gson requestGson = new Gson();
        EVRequest.request(Action.ACTION_GET_PKHJTCYLIST,
                requestGson.toJson(new RequestHeaderBean(R.string.req_code_getPkhJtcyList)),
                requestGson.toJson(new PkhRequestBean(true)),
                new ResponseCallback() {
                    @Override
                    public void onDataResponse(String dataJsonString) {
                        PkhjtcyList responseEvent = requestGson.fromJson(dataJsonString, PkhjtcyList.class);
                        EventBus.getDefault().post(responseEvent);
                    }
                });
    }

    @Override
    public String getPageName() {
        return getResources().getString(R.string.pkh_jtcy);
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_page);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mPkhjtcyRecyclerAdapter = new PkhjtcyRecyclerAdapter(true);
        mRecyclerView.setAdapter(mPkhjtcyRecyclerAdapter);
        mHasData = false;
    }
}
