package cn.studyjams.s1.sj19.quhaofeng;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Quhaofeng on 16-4-27.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

    /**
     * 存放布局
     */
    private View mView;

    /**
     * 用于判断是否处于双页面
     */
    private boolean isTwoPace = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_main, container, false);
        Button buttonA = (Button) mView.findViewById(R.id.a);
        buttonA.setOnClickListener(this);
        Button buttonB = (Button) mView.findViewById(R.id.b);
        buttonB.setOnClickListener(this);
        Button buttonC = (Button) mView.findViewById(R.id.c);
        buttonC.setOnClickListener(this);
        Button buttonD = (Button) mView.findViewById(R.id.d);
        buttonD.setOnClickListener(this);
        Button buttonE = (Button) mView.findViewById(R.id.e);
        buttonE.setOnClickListener(this);
        return mView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //横屏的时候会回调这个函数，并调用相应的land布局
        if (getActivity().findViewById(R.id.detail_layout) != null) {
            isTwoPace = true;//双页面
            DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_fragment);
            detailFragment.refresh(getResources().getString(R.string.btn_introduce), R.drawable.p1_intrudous, Detial.articleOne);
        } else {
            isTwoPace = false;//单页面
        }
    }

    @Override
    public void onClick(View view) {
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
        if (isTwoPace) {
            DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_fragment);
            detailFragment.refresh(title, imgId, articlePage);//刷新fragment里的内容
        } else {
            DetailActivity.actionStart(getActivity(), title, imgId, articlePage);//向第二个Activity传递数据，并启动第二个Activity
        }
    }
}
