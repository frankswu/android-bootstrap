

package com.donnfelker.android.bootstrap.ui;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.Window;
import com.donnfelker.android.bootstrap.BootstrapApplication;
import com.donnfelker.android.bootstrap.R;
import com.donnfelker.android.bootstrap.R.id;

import com.viewpagerindicator.TitlePageIndicator;

import butterknife.InjectView;
import butterknife.Views;

/**
 * Activity to view the carousel and view pager indicator with fragments.
 */
public class CarouselActivity extends BootstrapFragmentActivity {

    /**
     * https://github.com/JakeWharton/butterknife
     *
     * View "injection" library for Android which uses annotation processing to generate boilerplate code for you.
     * 
     * Eliminate findViewById calls by using @InjectView on fields.
     * Group multiple views in a list using @InjectViews. Operate on all of them at once with actions, setters, or properties.
     * Eliminate anonymous inner-classes for listeners by annotating methods with @OnClick and others.
     * class ExampleActivity extends Activity {
     *   @InjectView(R.id.user) EditText username;
     *   @InjectView(R.id.pass) EditText password;
     * 
     *   @OnClick(R.id.submit) void submit() {
     *     // TODO call server...
     *   }
     * 
     *   @Override public void onCreate(Bundle savedInstanceState) {
     *     super.onCreate(savedInstanceState);
     *     setContentView(R.layout.simple_activity);
     *     ButterKnife.inject(this);
     *     // TODO Use "injected" views...
     *   }
     * }
     *
     * 
     */
    @InjectView(id.tpi_header) TitlePageIndicator indicator;
    @InjectView(id.vp_pages) ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.carousel_view);

        pager.setAdapter(new BootstrapPagerAdapter(getResources(), getSupportFragmentManager()));

        indicator.setViewPager(pager);
        pager.setCurrentItem(1);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case id.timer:
                final Intent i = new Intent(this, BootstrapTimerActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
