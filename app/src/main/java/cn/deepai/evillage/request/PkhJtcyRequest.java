package cn.deepai.evillage.request;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;

import cn.deepai.evillage.R;
import cn.deepai.evillage.model.bean.PkhjtcyBean;
import cn.deepai.evillage.model.event.ResponseEvent;
import cn.deepai.evillage.model.bean.RequestHeaderBean;
import cn.deepai.evillage.model.event.ResponseHeaderEvent;
import cn.deepai.evillage.model.event.RspCode;
import cn.deepai.evillage.manager.CacheManager;
import de.greenrobot.event.EventBus;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 家庭成员详情
 */
public class PkhJtcyRequest extends EVRequest {

    public static void request(int id) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("jtcyxxId", id);
        }catch (JSONException e) {
            return;
        }
        RequestHeaderBean header = new RequestHeaderBean(R.string.req_code_getPkhJtcyJbxx);

        final Gson requestGson = new Gson();
        EVRequest.request(EVRequest.ACTION_GET_JTCYJBXX, requestGson.toJson(header), jsonObject.toString(), new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ResponseEvent<PkhjtcyBean> responseEvent = new ResponseEvent<>();
                String cache = CacheManager.getInstance().getCacheData(EVRequest.ACTION_GET_JTCYJBXX);
                responseEvent.data = requestGson.fromJson(cache, PkhjtcyBean.class);
                responseEvent.rspHeader = new ResponseHeaderEvent();
                responseEvent.rspHeader.setRspCode(RspCode.RSP_CODE_NO_CONNECTION);
                EventBus.getDefault().post(responseEvent);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Type type = new TypeToken<ResponseEvent<PkhjtcyBean>>(){}.getType();
                ResponseEvent<PkhjtcyBean> responseEvent = requestGson.fromJson(response.body().string(), type);
                EventBus.getDefault().post(responseEvent);
                if (RspCode.RSP_CODE_SUCCESS.equals(responseEvent.rspHeader.getRspCode())) {
                    CacheManager.getInstance().cacheData(
                            EVRequest.ACTION_GET_JTCYJBXX,requestGson.toJson(responseEvent.data));
                }
            }
        });
    }
}
