package com.example.l;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class webView_Stories extends AppCompatActivity {
    WebView web_stories ;
    Button btn_sound ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view__stories);
        web_stories =(WebView) findViewById(R.id.webView_stories);

        Intent data = getIntent();
        int page = data.getExtras().getInt("page");
        page++;
        web_stories.loadUrl("https://www.facebook.com" );
        Toast.makeText(this,"test",Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"test6",Toast.LENGTH_LONG).show();
    }
}
