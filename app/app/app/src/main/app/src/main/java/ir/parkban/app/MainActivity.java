package ir.parkban.app;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity extends Activity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showSplash();

        new android.os.Handler().postDelayed(
                this::openSite,
                900
        );
    }

    private void showSplash() {

        TextView splash = new TextView(this);

        splash.setText("🅿️\nپارک‌بان");
        splash.setTextColor(Color.WHITE);
        splash.setTextSize(30);
        splash.setGravity(Gravity.CENTER);
        splash.setBackgroundColor(
                Color.rgb(6, 27, 53)
        );

        setContentView(splash);
    }

    private void openSite() {

        webView = new WebView(this);

        WebSettings settings = webView.getSettings();

        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);

        webView.setWebViewClient(
                new WebViewClient()
        );

        webView.loadUrl(
                "http://park-ban.ir/"
        );

        setContentView(webView);
    }

    @Override
    public void onBackPressed() {

        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
