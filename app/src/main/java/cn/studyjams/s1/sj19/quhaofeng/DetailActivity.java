package cn.studyjams.s1.sj19.quhaofeng;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.ImageView;

/**
 * Created by Quhaofeng on 16-4-26.<br/>
 * 用于显示详细的文本的，主要包括顶部标题栏，图片，以及一个WebView
 */
public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detial);
        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        WebView webView = (WebView) findViewById(R.id.web_view);
        Intent intent = getIntent();//获取上一个Activity传来的数据
        //设置标题
        String title = intent.getStringExtra("title");
        CustomTitle.setTitle(title);
        //设置图图片
        int imgId = intent.getIntExtra("imgId", 0);
        imageView.setImageResource(imgId);
        //设置web文本
        String data = intent.getStringExtra("article");
        webView.loadDataWithBaseURL(null, data, "text/html", "UTF-8", null);
    }
}
