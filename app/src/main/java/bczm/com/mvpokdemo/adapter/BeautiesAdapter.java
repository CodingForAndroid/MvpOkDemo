package bczm.com.mvpokdemo.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import bczm.com.mvpokdemo.R;
import bczm.com.mvpokdemo.model.Beauties;

/**
 * @author zhangjun
 * @date 2019-7-31
 */
public class BeautiesAdapter extends BaseQuickAdapter<Beauties.ResultsBean, BaseViewHolder> {

    public Context cxt;
    public BeautiesAdapter(int layoutResId, @Nullable List<Beauties.ResultsBean> data, Context context) {
        super(layoutResId, data);
        cxt = context;
    }


    @Override
    protected void convert(BaseViewHolder helper, Beauties.ResultsBean item) {
        ImageView view = helper.getView(R.id.image);
        Glide.with(cxt).load( item.getUrl()).into(view);
    }
}
