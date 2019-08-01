package bczm.com.mvpokdemo.ui.fragmenttabhost;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bczm.com.mvpokdemo.R;
import bczm.com.mvpokdemo.base.BaseActivity;
import bczm.com.mvpokdemo.presenter.BasePresenter;

/**
 * @author zhangjun
 * @date 2019-8-1
 */
public class FragmentTabHostActivity extends BaseActivity {
    private String[] tabs = new String[]{"首页", "分类", "案例", "设置"};
    private Class[] mFragmentClasses = new Class[]{AFragment.class, BFragment.class,
            CFragment.class, DFragment.class};
    private int[] selectorImg = new int[]{R.drawable.tab_home_selector, R.drawable.tab_classification_selector,
            R.drawable.tab_case_selector, R.drawable.tab_setting_selector};



    /**
     * tab的view对象
     *
     * @param index 索引
     * @return view对象
     */
    private View getTabView(int index) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.item_tab, null);
        ImageView tabImage = inflate.findViewById(R.id.tab_image);
        TextView tabTitle = inflate.findViewById(R.id.tab_title);
        tabImage.setImageResource(selectorImg[index]); // 通过selector来控制图片的改变
        tabTitle.setText(tabs[index]);// 通过selector来控制文字颜色的改变
        return inflate;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fragment_tabhost;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected List createPresenters() {
        return null;
    }

    @Override
    protected void findViews() {
        FragmentTabHost mTabHost = (FragmentTabHost) findViewById(R.id.tabHost);

        mTabHost.setup(this,getSupportFragmentManager() , R.id.tabContent);
//        mTabHost.getTabWidget().setVisibility(View.GONE);

        for (int i = 0; i < tabs.length; i++) {
            mTabHost.addTab(mTabHost.newTabSpec(tabs[i]).setIndicator(getTabView(i)),mFragmentClasses[i], null);
        }
        // 设置默认tab
        mTabHost.setCurrentTab(2);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {

    }
}
