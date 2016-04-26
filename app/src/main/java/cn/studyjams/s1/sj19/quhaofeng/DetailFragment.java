package cn.studyjams.s1.sj19.quhaofeng;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

/**
 * Created by Quhaofeng on 16-4-27.
 */
public class DetailFragment extends Fragment {
    /**
     * 存放布局
     * */
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_detail, container, false);
        return mView;
    }

    /**
     * 用于刷新具体文章的内容和图片
     * */
    public void refresh(String title, int imgId, String articlePage) {
        CustomTitle.setTitle(title);
        ImageView imageView = (ImageView) mView.findViewById(R.id.image_view);
        imageView.setImageResource(imgId);
        WebView webView = (WebView) mView.findViewById(R.id.web_view);
        webView.loadDataWithBaseURL(null, articlePage, "text/html", "UTF-8", null);
    }
}
