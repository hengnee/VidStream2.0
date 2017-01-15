package com.example.android101.vidstream;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView Title, Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //String stream_url = "http://172.28.218.13:8080/stream/video.mjpeg";

        String stream_url = "http://192.168.0.111:8080/stream/video.mjpeg";
        WebView browser = (WebView) this.findViewById(R.id.webView);
        browser.setInitialScale(1);
        browser.getSettings().setLoadWithOverviewMode(true);
        browser.getSettings().setUseWideViewPort(true);
        browser.loadUrl(stream_url);

        Title = (TextView)findViewById(R.id.textTitle);
        Message = (TextView)findViewById(R.id.textMessage);

        if(getIntent().getExtras() != null){
            for(String key : getIntent().getExtras().keySet()){
                if(key.equals("title"))
                    Title.setText(getIntent().getExtras().getString(key));
                else if(key.equals("message"))
                    Message.setText(getIntent().getExtras().getString(key));
            }
        }
    }
}
