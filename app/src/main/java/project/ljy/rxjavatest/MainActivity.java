package project.ljy.rxjavatest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import bean.DaliyBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import data.DaliyData;


/**
 * 测试rxjava结合retrofit的效果，使用mvp模式构建
 */
public class MainActivity extends AppCompatActivity implements IMain.View {

    //    Observable<String> observable;

    IMain.Presenter mPresenter;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.list)
    RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ButterKnife.setDebug(true);
        new MainPresenter(this).loadData();

//        listCallable callable = new listCallable();
//        observable = Observable.fromCallable(callable);
//        subscription = observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unsubscribe();
    }

    @Override
    public void showData(List<DaliyData> list) {
        if (list != null) {

        }
    }

    @Override
    public void setPresenter(IMain.Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }


//    /**
//     * 从网络获取数据的callable类
//     * 这是从直接使用Callable类来加载数据，没有结合adapter-rxjava来简化操作
//     */
//    class listCallable implements Callable<String> {
//
//        @Override
//        public String call() throws Exception {
//            Retrofit retrofit = new Retrofit.Builder().baseUrl("http://gank.io/api/").addConverterFactory(GsonConverterFactory.create()).build();
//            API.GankApi gankApi = retrofit.create(API.GankApi.class);
//            Call<GankBean> Enquene = gankApi.Found(2016+"",5 + "",25 + "");
//            Enquene.enqueue(new Callback<GankBean>() {
//                @Override
//                public void onResponse(Call<GankBean> call, Response<GankBean> response) {
//                    if(!response.body().isError()){
//                        List<GankBean.ResultsEntity> entity = response.body().getResults();
//                        if(entity.size() > 0){
//                            Toast.makeText(MainActivity.this, entity.get(0).getTitle(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<GankBean> call, Throwable t) {
//                    t.printStackTrace();
//                }
//            });
//            return result;
//        }
//    }


}
