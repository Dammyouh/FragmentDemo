package com.yxy.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements
        BottomNavigationBar.OnTabSelectedListener,ViewPager.OnPageChangeListener {

    private BottomNavigationBar bottomBar;
    private ViewPager viewPager;
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private ThirdFragment thirdFragment;
    private ForthFragment forthFragment;
    private MyAdapter myAdapter;
    private MyStateAdapter myStateAdapter;
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBottom();
        initViewPager();
    }

    private void initBottom() {
        bottomBar = findViewById(R.id.bottom_nav_bar);
        BottomNavigationItem firstItem = new BottomNavigationItem(R.drawable.icon_mine,"我的");
        BottomNavigationItem secondItem = new BottomNavigationItem(R.drawable.icon_like,"点赞");
        BottomNavigationItem thirdItem = new BottomNavigationItem(R.drawable.icon_messahe,"消息");
        BottomNavigationItem forthItem = new BottomNavigationItem(R.drawable.icon_up,"置顶");
        bottomBar.addItem(firstItem);
        bottomBar.addItem(secondItem);
        bottomBar.addItem(thirdItem);
        bottomBar.addItem(forthItem);
        bottomBar.initialise();
        bottomBar.setTabSelectedListener(this);
    }

    private void initViewPager() {
        viewPager = findViewById(R.id.viewpager);
        viewPager.setClipChildren(false);
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        thirdFragment = new ThirdFragment();
        forthFragment = new ForthFragment();
        fragmentList.add(firstFragment);
        fragmentList.add(secondFragment);
        fragmentList.add(thirdFragment);
        fragmentList.add(forthFragment);
//        myAdapter = new MyAdapter(this.getSupportFragmentManager(),fragmentList);
        myStateAdapter = new MyStateAdapter(this.getSupportFragmentManager(),fragmentList);
//        viewPager.setAdapter(myAdapter);
        viewPager.setAdapter(myStateAdapter);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onTabSelected(int position) {
        viewPager.setCurrentItem(position);

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        bottomBar.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
