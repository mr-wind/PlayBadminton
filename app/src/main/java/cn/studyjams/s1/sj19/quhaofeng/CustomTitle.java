package cn.studyjams.s1.sj19.quhaofeng;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Quhaofeng on 16-4-26.<br/>
 * 自定义标题布局，使之能够变换标题
 */
public class CustomTitle extends LinearLayout {

    private static TextView title;

    public CustomTitle(Context context, AttributeSet attri) {
        super(context, attri);
        LayoutInflater.from(context).inflate(R.layout.actionbar_title, this);
        title = (TextView) findViewById(R.id.my_action_bar_title);
    }

    /**
     * 修改顶部标题
     *
     * @param s 要设置的标题文本
     */
    public static void setTitle(String s) {
        title.setText(s);
    }
}
