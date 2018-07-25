package io.github.xesam.web.shell;

import android.content.Context;
import android.webkit.WebSettings;

public interface SettingInitializer {
    void init(Context context, WebSettings webSettings);
}
