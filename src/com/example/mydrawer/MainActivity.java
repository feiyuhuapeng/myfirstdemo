package com.example.mydrawer;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
    private String[] mplaneTitle;
    private DrawerLayout dl;
    private ListView lv;
    private ActionBarDrawerToggle mbt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drawer);
		mplaneTitle=new String[]{"shanghai","beijing","guangzhou"};
		dl=(DrawerLayout)findViewById(R.id.drawer_layout);
		lv=(ListView)findViewById(R.id.left_drawer);
		lv.setAdapter(new ArrayAdapter<String>(this
				,android.R.layout.simple_list_item_1,
				mplaneTitle));
		lv.setOnItemClickListener(new OnItemClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long id) {
				// TODO Auto-generated method stub
				  Fragment frg=new Fragment();
				  FragmentManager frgmag=getFragmentManager();
				  frgmag.beginTransaction().replace(R.id.content_frame,frg ).commit();
				  lv.setItemChecked(position, true);
				  getActionBar().setTitle(mplaneTitle[position]);
				  dl.closeDrawers();

			}
		});
		//dl.setDrawerListener(listener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
