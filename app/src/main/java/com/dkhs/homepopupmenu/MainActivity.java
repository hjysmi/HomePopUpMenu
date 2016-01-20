package com.dkhs.homepopupmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {
    ImageButton notify;
    ImageView tips_arrow;
    HomePopUpMenu popUpMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notify = (ImageButton) findViewById(R.id.notify);
        tips_arrow = (ImageView) findViewById(R.id.tips_arrow);
        this.popUpMenu = new HomePopUpMenu(this, -2, -2);
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopUpArrow(true);
                popUpMenu.show(v);
            }
        });
        popUpMenu.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                showPopUpArrow(false);
            }
        });
    }

    public void showPopUpArrow(boolean paramBoolean) {
        if (paramBoolean) {
            this.tips_arrow.setVisibility(View.VISIBLE);
            return;
        }
        this.tips_arrow.setVisibility(View.GONE);
    }
}
