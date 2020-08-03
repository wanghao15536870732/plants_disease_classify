package com.example.resnettest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.resnettest.bean.AgriProduct;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TestActivity extends AppCompatActivity {

    private static String address = "http://wnd.agri114.cn/wndms/json/findDiseaseFeatures.action";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        sendOkHttpRequest(address, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Toast.makeText(TestActivity.this, "加载失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try {
                    JSONObject responseData = new JSONObject(response.body().string());
                    JSONArray productArray = responseData.getJSONArray("agriProductList");
                    for(int i = 0;i < productArray.length();i ++){
                        JSONObject productObject = productArray.getJSONObject(i);
                        AgriProduct product = new AgriProduct();
                        product.setImg(productObject.getString("img"));
                        product.setName(productObject.getString("name"));
                        product.setId(productObject.getInt("id"));
                        product.setCategory(productObject.getString("category"));
                        sendOkHttpRequest(address + "?agriProductId=" +
                                productObject.getInt("id"), new Callback() {
                            @Override
                            public void onFailure(@NotNull Call call, @NotNull IOException e) {

                            }

                            @Override
                            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                            }
                        });
                        Log.e("test",product.toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private void sendOkHttpRequest(String address, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
