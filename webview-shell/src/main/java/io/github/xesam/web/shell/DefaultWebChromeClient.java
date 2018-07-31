package io.github.xesam.web.shell;

import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;

public class DefaultWebChromeClient extends WebChromeClient {
    @Override
    public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
        super.onGeolocationPermissionsShowPrompt(origin, callback);
        callback.invoke(origin, true, false);
    }

    @Override
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage != null) {
            Log.d("DefaultWebChromeClient", "");
            ConsoleMessage.MessageLevel messageLevel = consoleMessage.messageLevel();
            String tag = "DefaultWebChromeClient";
            String msg = buildConsoleMessage(consoleMessage);
            switch (messageLevel) {
                case TIP:
                    Log.v(tag, msg);
                    break;
                case LOG:
                    Log.i(tag, msg);
                    break;
                case DEBUG:
                    Log.d(tag, msg);
                    break;
                case WARNING:
                    Log.w(tag, msg);
                    break;
                case ERROR:
                    Log.e(tag, msg);
                    break;
            }

        }
        return super.onConsoleMessage(consoleMessage);
    }

    private String buildConsoleMessage(ConsoleMessage message) {
        return message.lineNumber() + ";" + message.sourceId() + ";" + message.message();
    }
}
