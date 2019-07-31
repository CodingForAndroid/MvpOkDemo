package bczm.com.mvpokdemo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

import bczm.com.mvpokdemo.adapter.BeautiesAdapter;
import bczm.com.mvpokdemo.base.BaseActivity;
import bczm.com.mvpokdemo.model.Beauties;
import bczm.com.mvpokdemo.presenter.BeautiesPresenter;
import bczm.com.mvpokdemo.view.IBeautiesView;

/**
 *
 * @author zhangjun
 */
public class BeautiesActivity extends BaseActivity<IBeautiesView,BeautiesPresenter<IBeautiesView>> implements IBeautiesView {
    private RecyclerView recyclerView;
    private Button btnMoreData;
    private BeautiesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beauties);
        //recyclerView
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setFocusableInTouchMode(false);
        //load more
        btnMoreData = findViewById(R.id.btnMoreData);

        /**
         * 2.执行UI逻辑
         */
        presenter.fetch();

        //load more click event
        btnMoreData.setOnClickListener((view)-> presenter.loadMore());
    }

    @Override
    protected BeautiesPresenter<IBeautiesView> createPresenter() {
        return new BeautiesPresenter<>();
    }

    @Override
    protected List<BeautiesPresenter<IBeautiesView>> createPresenters() {
        return null;
    }

    @Override
    public void showBeauties(Beauties beauties) {
        if(adapter==null){
            adapter = new BeautiesAdapter(R.layout.item,beauties.getResults(),this);
            recyclerView.setAdapter(adapter);
        }else {
            adapter.addData(beauties.getResults());
        }


    }
}
