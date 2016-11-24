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
		//���ӵ��ؼ�
		webView = (WebView) findViewById(R.id.webView);
		//����
		webView.setWebViewClient(new WebViewClient());
		//����֧��JavaScript����ΪҪ����js�Ĵ���
		webView.getSettings().setJavaScriptEnabled(true);
		//�ṩһ���ӿڣ���JavaScript����Android�ķ���
		webView.addJavascriptInterface(new Object(){
			@android.webkit.JavascriptInterface
			//�Զ���һ�������������ԣ���JavaScript����
			public void javaMethod(){
				Toast.makeText(MainActivity.this, "java����......", 0).show();
			}
		}, "javaCode");//"javaCode"---�˷����ı�ʾ����ҳ����javascript:window.javaCode.javaMethod()���Ӧ
		//�����Ѿ�д�õ�HTML5ҳ��
		webView.loadUrl("http://192.168.191.1:8080/day09.html");
	}
	
	//���ð�ť�ĵ��������֤��Android���Ե���JavaScript��ķ���
	public void callJavaScriopt(View v){
		//����JavaScript��ķ���
		webView.loadUrl("javascript:callJava()");
	}
}
