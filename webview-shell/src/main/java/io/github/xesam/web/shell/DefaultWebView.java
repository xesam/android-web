package io.github.xesam.web.shell;

import android.os.Build;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DefaultWebView {
    private WebView mWebView;

    public DefaultWebView(WebView webView) {
        mWebView = webView;
    }

    public DefaultWebView webviewClient(WebViewClient client) {
        mWebView.setWebViewClient(client);
        return this;
    }

    public DefaultWebView webChromeClient(WebChromeClient client) {
        mWebView.setWebChromeClient(client);
        return this;
    }

    public DefaultWebView initSettings(SettingInitializer initializer) {
        initializer.init(mWebView.getContext(), mWebView.getSettings());
        return this;
    }

    public DefaultWebView debug(boolean debug) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && debug) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        return this;
    }
}
