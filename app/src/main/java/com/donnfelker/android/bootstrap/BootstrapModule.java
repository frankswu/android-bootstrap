package com.donnfelker.android.bootstrap;

import android.accounts.AccountManager;
import android.content.Context;

import com.donnfelker.android.bootstrap.authenticator.BootstrapAuthenticatorActivity;
import com.donnfelker.android.bootstrap.authenticator.LogoutService;
import com.donnfelker.android.bootstrap.core.CheckIn;
import com.donnfelker.android.bootstrap.core.TimerService;
import com.donnfelker.android.bootstrap.ui.BootstrapTimerActivity;
import com.donnfelker.android.bootstrap.ui.CarouselActivity;
import com.donnfelker.android.bootstrap.ui.CheckInsListFragment;
import com.donnfelker.android.bootstrap.ui.ItemListFragment;
import com.donnfelker.android.bootstrap.ui.NewsActivity;
import com.donnfelker.android.bootstrap.ui.NewsListFragment;
import com.donnfelker.android.bootstrap.ui.UserActivity;
import com.donnfelker.android.bootstrap.ui.UserListFragment;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module for setting up provides statements.
 * Register all of your entry points below.
 *
 * [ERROR] COMPILATION ERROR:
 * [ERROR]: Graph validation failed: You have these unused @Provider methods:
 *       1. coffee.DripCoffeeModule.provideChiller()
 *       Set library=true in your module to disable this check.
 * If your module's bindings will be used outside of the listed injects then mark the module as a library.
 */
@Module
(
        complete = false,
        library = true,
        injects = {
                BootstrapApplication.class,
                BootstrapAuthenticatorActivity.class,
                CarouselActivity.class,
                BootstrapTimerActivity.class,
                CheckInsListFragment.class,
                NewsActivity.class,
                NewsListFragment.class,
                UserActivity.class,
                UserListFragment.class,
                TimerService.class
        }

)
public class BootstrapModule  {

    @Singleton
    @Provides
    Bus provideOttoBus() {
        return new Bus();
    }

    @Provides
    @Singleton
    LogoutService provideLogoutService(final Context context, final AccountManager accountManager) {
        return new LogoutService(context, accountManager);
    }

}
