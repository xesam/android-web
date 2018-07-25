package io.github.xesam.web.shell;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;

public class DefaultSettingInitializer implements SettingInitializer {

    public DefaultSettingInitializer() {
    }

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    public void init(Context context, WebSettings webSettings) {
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheMaxSize(1024 * 1024 * 5);
        String appCachePath = context.getCacheDir().getAbsolutePath();
        webSettings.setAppCachePath(appCachePath);
        webSettings.setAllowFileAccess(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSaveFormData(true);
        webSettings.setSupportZoom(true);
        webSettings.setSupportMultipleWindows(true);
        webSettings.setDefaultTextEncodingName("utf-8");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
    }
}
