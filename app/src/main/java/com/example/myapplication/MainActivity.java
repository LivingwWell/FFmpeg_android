package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnProtocol, btnCodec, btnFilter, btnFormat;
    private TextView tvInfo;
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCodec=findViewById(R.id.btn_codec);
        btnProtocol=findViewById(R.id.btn_protocol);
        btnFilter=findViewById(R.id.btn_filter);
        btnFormat=findViewById(R.id.btn_format);
        tvInfo=findViewById(R.id.tv_info);
        btnProtocol.setOnClickListener(this);
        btnCodec.setOnClickListener(this);
        btnFilter.setOnClickListener(this);
        btnFormat.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_protocol:
                tvInfo.setText(urlprotocolinfo());
                break;
            case R.id.btn_format:
                tvInfo.setText(avformatinfo());
                break;
            case R.id.btn_codec:
                tvInfo.setText(avcodecinfo());
                break;
            case R.id.btn_filter:
                tvInfo.setText(avfilterinfo());
                break;
            default:
                break;
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

    public native String urlprotocolinfo();

    public native String avformatinfo();

    public native String avcodecinfo();

    public native String avfilterinfo();
}
