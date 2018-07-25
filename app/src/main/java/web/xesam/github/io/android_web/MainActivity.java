package web.xesam.github.io.android_web;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import io.github.xesam.web.shell.DefaultWebChromeClient;
import io.github.xesam.web.shell.DefaultSettingInitializer;
import io.github.xesam.web.shell.DefaultWebView;
import io.github.xesam.web.shell.DefaultWebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView vWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vWeb = findViewById(R.id.web);
        new DefaultWebView(vWeb)
                .initSettings(new DefaultSettingInitializer())
                .webviewClient(new DefaultWebViewClient())
                .webChromeClient(new DefaultWebChromeClient())
                .debug(true);
    }
}
