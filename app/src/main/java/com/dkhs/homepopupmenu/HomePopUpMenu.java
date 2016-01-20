package com.dkhs.homepopupmenu;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by xuetong on 2016/1/20.
 */
public class HomePopUpMenu extends PopupWindow {
    Context mContext;
    int mScreenWidth;
    ListView mListView;
    HomePopUpMenuAdapter mHomePopupAdapter;
    private ArrayList<HomePopUpMenuItem> mMenuItems = new ArrayList();

    public HomePopUpMenu(Context paramContext, int width, int height) {
        super(paramContext);
        this.mContext = paramContext;
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        this.mScreenWidth = com.dkhs.homepopupmenu.ViewUtils.getScreenWidthPixels(mContext);
        setWidth(width);
        setHeight(height);
        setBackgroundDrawable(new BitmapDrawable());
        setContentView(LayoutInflater.from(this.mContext).inflate(R.layout.main_home_popup_menu, null));
        initData();
        initUI();
    }
    public void show(View paramView)
    {
        int[] arrayOfInt = new int[2];
        paramView.getLocationOnScreen(arrayOfInt);
        showAtLocation(paramView, 0, this.mScreenWidth - getWidth(), arrayOfInt[1]+30 + paramView.getHeight());
    }
    private void initUI() {
        this.mListView = ((ListView) getContentView().findViewById(R.id.menu_list));
        this.mHomePopupAdapter = new HomePopUpMenuAdapter();
        this.mListView.setAdapter(this.mHomePopupAdapter);
    }

    private void initData() {
        this.mMenuItems.add(new HomePopUpMenuItem("写点评", R.drawable.home_navibar_tips_icon_comment));
        this.mMenuItems.add(new HomePopUpMenuItem("添加商户", R.drawable.home_navibar_tips_icon_store));
        this.mMenuItems.add(new HomePopUpMenuItem("扫一扫", R.drawable.home_navibar_tips_icon_scan));
        this.mMenuItems.add(new HomePopUpMenuItem("付款码", R.drawable.home_add_icon_pay));
    }

    private class HomePopUpMenuAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mMenuItems.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(HomePopUpMenu.this.mContext).inflate(R.layout.main_home_popup_menu_item, null);
            ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
            TextView title = (TextView) convertView.findViewById(R.id.title);
            icon.setImageResource(mMenuItems.get(position).icon);
            title.setText(mMenuItems.get(position).title);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                    Log.e("xue", mMenuItems.get(position).title);
                }
            });


            return convertView;
        }
    }
}
