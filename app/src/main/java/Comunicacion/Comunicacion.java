package Comunicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.login.R;

public class Comunicacion extends AppCompatActivity {
    WebView miVisorWeb;
    String url = "http://www.proteccionanimalbogota.gov.co";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunicacion);
        this.setTitle(R.string.Comunidad);

        miVisorWeb = (WebView) findViewById(R.id.visorWeb);
        miVisorWeb.setWebViewClient(new WebViewClient());
        miVisorWeb.loadUrl(url);
    }

    public void volver(View view){
        finish();
    }
    //Impedir que el botón Atrás cierre la aplicación
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        WebView miVisorWeb;
        miVisorWeb = (WebView) findViewById(R.id.visorWeb);
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (miVisorWeb.canGoBack()) {
                        miVisorWeb.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}