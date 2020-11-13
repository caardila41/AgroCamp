package com.ard.agrocampo.ui.NoticiasF;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ard.agrocampo.R;

public class NoticiasF extends Fragment {

    private NoticiasViewModel mViewModel;

    public static NoticiasF newInstance() {
        return new NoticiasF();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.noticias_fragment, container, false);
        WebView webView =(WebView) root.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);//Habilita Javascript
        webView.setWebViewClient(new WebViewClient());//Permite abrir la vista en la app
        webView.loadUrl("https://www.eltiempo.com/noticias/agricultura");
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NoticiasViewModel.class);
        // TODO: Use the ViewModel
    }

}