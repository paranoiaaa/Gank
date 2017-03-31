package material.com.news.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import material.com.base.BaseFragment;
import material.com.news.R;

/**
 * Created by zjl on 2017/3/30.
 */

public class AllNewsFragment extends BaseFragment{

    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    private List<Fragment> pageFagments = new ArrayList<Fragment>();
    private List<String> pageTitles = new ArrayList<String>();
    private TabLayout tabLayout;

    private View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.news_all_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toolbar toolbar = (Toolbar)view.findViewById(R.id.news_toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        tabLayout = (TabLayout) view.findViewById(R.id.news_gank_tab);
        mViewPager =(ViewPager) view.findViewById(R.id.news_gank_view_pager);
        pageTitles = PageConfig.getPageTitles();
//        try{
//            for (int i=0;i<PageConfig.fragmentNames.length;i++){
//                String address = PageConfig.fragmentNames[i];
//                //反射获得Class
//                Class clazz = Class.forName(address);
//                //创建类
//                Fragment tab = (Fragment) clazz.newInstance();
//                Bundle bundle = new Bundle();
//                bundle.putString("sort",PageConfig.getPageTitles().get(i));
//                tab.setArguments(bundle);
//                //添加到viewPagerAdapter的资源
//                pageFagments.add(tab);
//            }
//        }catch (ClassNotFoundException e){
//            e.printStackTrace();
//        }catch (IllegalAccessException e){
//            e.printStackTrace();
//        }catch (java.lang.InstantiationException e){
//            e.printStackTrace();
//        }

        for(int i=0;i<PageConfig.fragmentNames.length;i++){
            Fragment tab = new NewFragment();
            Bundle bundle = new Bundle();
            bundle.putString("sort",PageConfig.getPageTitles().get(i));
            tab.setArguments(bundle);
            pageFagments.add(tab);
        }

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(mViewPager);
        mViewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(),pageFagments,pageTitles);

        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void loadData() {

    }
}
