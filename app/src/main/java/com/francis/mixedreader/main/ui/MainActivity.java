package com.francis.mixedreader.main.ui;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.francis.mixedreader.R;
import com.francis.mixedreader.about.AboutFragment;
import com.francis.mixedreader.image.ui.ImageFragment;
import com.francis.mixedreader.main.presenter.MainPresenter;
import com.francis.mixedreader.main.presenter.MainPresenterImpl;
import com.francis.mixedreader.main.view.MainView;
import com.francis.mixedreader.news.ui.NewsFragment;
import com.francis.mixedreader.weather.ui.WeatherFragment;

public class MainActivity extends AppCompatActivity implements MainView {

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
		getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new NewsFragment()).commit();
		toolbar.setTitle(R.string.navigation_news);
	}

	@Override
	public void switch2Images() {
		getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new ImageFragment()).commit();
		toolbar.setTitle(R.string.navigation_images);
	}

	@Override
	public void switch2Weather() {
		getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new WeatherFragment()).commit();
		toolbar.setTitle(R.string.navigation_weather);
	}

	@Override
	public void switch2About() {
		getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new AboutFragment()).commit();
		toolbar.setTitle(R.string.navigation_about);
	}
}
