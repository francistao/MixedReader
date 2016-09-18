package com.francis.mixedreader.main.view;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.francis.mixedreader.R;
import com.francis.mixedreader.main.presenter.MainPresenter;
import com.francis.mixedreader.main.presenter.MainPresenterImpl;

public class MainActivity extends AppCompatActivity implements MainView{

	private DrawerLayout drawerLayout;
	private ActionBarDrawerToggle actionBarDrawerToggle;
	private Toolbar toolbar;
	private NavigationView navigationView;

	private MainPresenter mainPresenter;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open,
				R.string.drawer_close);
		actionBarDrawerToggle.syncState();
		drawerLayout.setDrawerListener(actionBarDrawerToggle);
		navigationView = (NavigationView) findViewById(R.id.navigation_view);

		mainPresenter = new MainPresenterImpl(this);
		setupDrawerContent(navigationView);

		switch2News();
	}


	private void setupDrawerContent(NavigationView navigationView){
		navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

			@Override
			public boolean onNavigationItemSelected(MenuItem item) {
				mainPresenter.switchNavigation(item.getItemId());
				item.setChecked(true);
				drawerLayout.closeDrawers();
				return true;
			}
		});
	}

	@Override
	public void switch2News() {

	}

	@Override
	public void switch2Images() {

	}

	@Override
	public void switch2Weather() {

	}

	@Override
	public void switch2About() {

	}
}
