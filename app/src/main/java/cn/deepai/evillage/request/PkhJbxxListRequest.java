package cn.deepai.evillage.request;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Date;

import cn.deepai.evillage.controller.activity.LoginActivity;
import cn.deepai.evillage.model.LoginData;
import cn.deepai.evillage.model.LoginResult;
import cn.deepai.evillage.model.RequestHeader;
import cn.deepai.evillage.model.RequestSucceedEvent;
import cn.deepai.evillage.model.ResponseHeader;
import cn.deepai.evillage.utils.LogUtil;
import cn.deepai.evillage.utils.MD5Util;
import de.greenrobot.event.EventBus;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author GaoYixuan
 * 登录请求处理
 */
public class PkhJbxxListRequest extends EVNetRequest{

    public static void request(int userId) {
        RequestSucceedEvent event = new RequestSucceedEvent();
        event.body = "[\n" +
                "            {\n" +
                "                \"hid\":43,\n" +
                "                \"hzxm\":\"张三\",\n" +
                "                \"jdnf\":2015,\n" +
                "                \"jzdz\":\"遵义市桐梓县燎原镇花园新村7号楼7-201\",\n" +
                "                \"vid\":43,\n" +
                "                \"lxdh\":\"17012332312\",\n" +
                "\"jlsj\":20150803121212\n" +
                "            },\n" +
                "            {\n" +
                "                \"hid\":44,\n" +
                "                \"hzxm\":\"李四\",\n" +
                "                \"jdnf\":2014,\n" +
                "                \"jzdz\":\"遵义市桐梓县燎原镇花园新村5号楼7-201\",\n" +
                "                \"vid\":43,\n" +
                "                \"lxdh\":\"18012332322\",\n" +
                "\"jlsj\":20150803121212\n" +
                "            }\n" +
                "        ]";
        EventBus.getDefault().post(event);
//        LoginData loginData = new LoginData();
//        loginData.setUserCode(name);
//        loginData.setPassword(MD5Util.getMD5(password));
//        loginData.setVersionCode("1");

//        RequestHeader header = new RequestHeader();
//        header.setReqCode("zyfp01001");
//        header.setReqTime((new Date()).toString());
//        header.setTokenId("0");
//
//        final Gson gson = new Gson();
//        EVNetRequest.request(EVNetRequest.ACTION_LOGIN_WITH_PASSWORD, gson.toJson(header), gson.toJson(""), new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                try {
//                    JSONObject jsonObject = new JSONObject(response.body().string());
//                    String str1 = jsonObject.getString("rspHeader");
//                    String str2 = jsonObject.getString("data");
//
//                    ResponseHeader responseHeader = gson.fromJson(str1, ResponseHeader.class);
//                    LoginResult result = gson.fromJson(str2, LoginResult.class);
//                    LogUtil.v(LoginActivity.class,str1);
//                    LogUtil.v(LoginActivity.class,str2);
//
//                } catch (JSONException e) {
//
//                }
//
//            }
//        });
    }
}
