package com.desigggggnn.firstone.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.desigggggnn.firstone.R;


public class AwardFragment extends Fragment {
    WebView mWebView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_award, container, false);
        mWebView = (WebView) v.findViewById(R.id.webView);
        mWebView.loadUrl("http://jajjiashoknagar.in/demo/Appview/awards");

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebView.setWebViewClient(new WebViewClient());

        return v;
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_award, container, false);
    }
}