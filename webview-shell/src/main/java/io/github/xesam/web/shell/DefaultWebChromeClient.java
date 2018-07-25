package io.github.xesam.web.shell;

import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;

public class DefaultWebChromeClient extends WebChromeClient {
    @Override
    public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
        super.onGeolocationPermissionsShowPrompt(origin, callback);
        callback.invoke(origin, true, false);
    }
}
