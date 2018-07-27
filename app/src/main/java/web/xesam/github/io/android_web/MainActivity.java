package web.xesam.github.io.android_web;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import io.github.xesam.web.shell.DefaultSettingInitializer;
import io.github.xesam.web.shell.WebBuilder;
import io.github.xesam.web.shell.DefaultWebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView vWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vWeb = findViewById(R.id.web);
        new WebBuilder(vWeb)
                .initSettings(new DefaultSettingInitializer())
                .webviewClient(new DefaultWebViewClient())
                .webChromeClient(new WebChromeClient() {
                    @Override
                    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                        Log.e("onJsPrompt", url);
                        Log.e("onJsPrompt", message);
                        Log.e("onJsPrompt", defaultValue);
                        result.confirm("return from native");
                        return true;
                    }

                    @Override
                    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
//                        return super.onJsAlert(view, url, message, result);
                        Log.e("onJsPrompt", url);
                        Log.e("onJsPrompt", message);
                        result.cancel();
                        return true;
                    }

                    @Override
                    public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
                        return super.onJsConfirm(view, url, message, result);
                    }
                })
                .debug(true);

        vWeb.loadUrl("file:///android_asset/index.html");
    }
}
