package cn.studyjams.s1.sj19.quhaofeng;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Quhaofeng on 16-4-26.<br/>
 * 用于显示详细的文本的，主要包括顶部标题栏，图片，以及一个WebView
 */
public class DetailActivity extends AppCompatActivity {

    /**
     * 用于启动本身这个Activity，要传进来的参数都在这个函数里了
     *
     * @param context     上下文
     * @param title       标题字符串
     * @param imgId       图片的资源ID
     * @param articlePage html字符串
     */
    public static void actionStart(Context context, String title, int imgId, String articlePage) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("imgId", imgId);
        intent.putExtra("article", articlePage);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detial);
        Intent intent = getIntent();//获取上一个传来的数据
        String title = intent.getStringExtra("title");
        int imgId = intent.getIntExtra("imgId", 0);
        String data = intent.getStringExtra("article");
        DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_fragment);
        detailFragment.refresh(title, imgId, data);//刷新fragment
    }
}
