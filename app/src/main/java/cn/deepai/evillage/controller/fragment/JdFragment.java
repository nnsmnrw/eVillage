package cn.deepai.evillage.controller.fragment;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.deepai.evillage.R;
import cn.deepai.evillage.adapter.PkhRecyclerAdapter;
import cn.deepai.evillage.manager.SettingManager;
import cn.deepai.evillage.model.bean.JdPkhjbxxList;
import cn.deepai.evillage.net.JdPkhListRequest;
import de.greenrobot.event.EventBus;

public class JdFragment extends BaseFragment {


    private RecyclerView mRecyclerView;
    private PkhRecyclerAdapter mPkhRecyclerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_pkh, container, false);
        mRecyclerView = (RecyclerView) root.findViewById(R.id.recyclerview_pkh);
        initView();
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
        loadData();
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @SuppressWarnings("all")
    public void onEventMainThread(JdPkhjbxxList event) {
        mPkhRecyclerAdapter.notifyResult(true, event.list);
        tryToHideProcessDialog();
    }

    @Override
    protected String getFragmentName() {
        return "Page_Jd";
    }

    private void loadData() {
        tryToShowProcessDialog();
        String id = SettingManager.getInstance().getStaffId();
        JdPkhListRequest.request(id);
    }

    private void initView() {
        if (mRecyclerView == null) return;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mPkhRecyclerAdapter = new PkhRecyclerAdapter(PkhRecyclerAdapter.TYPE_WRITE);
        mRecyclerView.setAdapter(mPkhRecyclerAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
