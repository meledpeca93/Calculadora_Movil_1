package com.uth.calculadora;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

final class Pantalla {
    private Pantalla() { }
    static void preparar(AppCompatActivity actividad, int layout) {
        EdgeToEdge.enable(actividad);
        actividad.setContentView(layout);
        View vista = actividad.findViewById(R.id.main);
        ViewCompat.setOnApplyWindowInsetsListener(vista, (v, insets) -> {
            Insets barras = insets.getInsets(WindowInsetsCompat.Type.systemBars()
                    | WindowInsetsCompat.Type.ime());
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom);
            return insets;
        });
        ViewCompat.requestApplyInsets(vista);
    }
}
