package cn.studyjams.s1.sj19.quhaofeng;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 根据按钮的id来传递不同的值到Activity
     */
    public void introduceHandler(View view) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        String title = "初始值";
        int imgId = 0;
        String articlePage = "<html><p>初始值</p></html>";
        switch (view.getId()) {
            case R.id.a:
                title = getResources().getString(R.string.btn_introduce);
                imgId = R.drawable.p1_intrudous;
                articlePage = Detial.articleOne;
                break;
            case R.id.b:
                title = getResources().getString(R.string.btn_area);
                imgId = R.drawable.p2_area;
                articlePage = Detial.articleTwo;
                break;
            case R.id.c:
                title = getResources().getString(R.string.btn_rule);
                imgId = R.drawable.p3_rule;
                articlePage = Detial.articleThree;
                break;
            case R.id.d:
                title = getResources().getString(R.string.btn_skill);
                imgId = R.drawable.p4_skill;
                articlePage = Detial.articleFour;
                break;
            case R.id.e:
                title = getResources().getString(R.string.btn_other);
                imgId = R.drawable.p5_other;
                articlePage = Detial.articleFive;
                break;
            default:
                title = "err";
                imgId = 0;
                articlePage = "<html><p>Err</p></html>";
        }
        intent.putExtra("title", title);
        intent.putExtra("imgId", imgId);
        intent.putExtra("article", articlePage);
        startActivity(intent);//向第二个Activity传递数据，并启动第二个Activity
    }
}