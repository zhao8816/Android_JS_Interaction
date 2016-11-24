package com.example.android_js;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends Activity {

	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//连接到控件
		webView = (WebView) findViewById(R.id.webView);
		//设置
		webView.setWebViewClient(new WebViewClient());
		//设置支持JavaScript，因为要调用js的代码
		webView.getSettings().setJavaScriptEnabled(true);
		//提供一个接口，供JavaScript调用Android的方法
		webView.addJavascriptInterface(new Object(){
			@android.webkit.JavascriptInterface
			//自定义一个方法，做测试，供JavaScript调用
			public void javaMethod(){
				Toast.makeText(MainActivity.this, "java代码......", 0).show();
			}
		}, "javaCode");//"javaCode"---此方法的标示，与页面上javascript:window.javaCode.javaMethod()相对应
		//加载已经写好的HTML5页面
		webView.loadUrl("http://192.168.191.1:8080/day09.html");
	}
	
	//设置按钮的点击方法，证明Android可以调用JavaScript里的方法
	public void callJavaScriopt(View v){
		//调用JavaScript里的方法
		webView.loadUrl("javascript:callJava()");
	}
}
