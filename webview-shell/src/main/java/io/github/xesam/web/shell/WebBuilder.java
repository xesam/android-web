package io.github.xesam.web.shell;

import android.os.Build;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebBuilder {
    private WebView mWebView;

    public WebBuilder(WebView webView) {
        mWebView = webView;
    }

    public WebBuilder webviewClient(WebViewClient client) {
        mWebView.setWebViewClient(client);
        return this;
    }

    public WebBuilder webChromeClient(WebChromeClient client) {
        mWebView.setWebChromeClient(client);
        return this;
    }

    public WebBuilder initSettings(SettingInitializer initializer) {
        initializer.init(mWebView.getContext(), mWebView.getSettings());
        return this;
    }

    public WebBuilder debug(boolean debug) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && debug) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        return this;
    }
}
