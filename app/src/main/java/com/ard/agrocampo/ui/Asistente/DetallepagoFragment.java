package com.ard.agrocampo.ui.Asistente;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ard.agrocampo.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetallepagoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetallepagoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    WebView webViewt;

    public DetallepagoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetallepagoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetallepagoFragment newInstance(String param1, String param2) {
        DetallepagoFragment fragment = new DetallepagoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_detallepago, container, false);

        webViewt =(WebView) root.findViewById(R.id.webViewtienda);
        webViewt.getSettings().setJavaScriptEnabled(true);//Habilita Javascript
        webViewt.setWebViewClient(new WebViewClient());//Permite abrir la vista en la app
        webViewt.loadUrl("https://mpago.li/2Lp2Sbw");

        return root;
    }
}