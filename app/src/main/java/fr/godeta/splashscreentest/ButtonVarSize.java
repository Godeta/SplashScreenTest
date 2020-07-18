package fr.godeta.splashscreentest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class ButtonVarSize extends AppCompatActivity {

    private Button butt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_var_size);
        butt = (Button) findViewById(R.id.bouton);
        butt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Comme l'évènement nous donne la vue concernée par le toucher, on le récupère et on le caste en Button
                Button bouton = (Button)v;

                // On récupère la largeur du bouton
                int largeur = bouton.getWidth();
                // On récupère la hauteur du bouton
                int hauteur = bouton.getHeight();

                // On récupère la coordonnée sur l'abscisse (X) de l'évènement
                float x = event.getX();
                // On récupère la coordonnée sur l'ordonnée (Y) de l'évènement
                float y = event.getY();

                // Puis on change la taille du texte selon la formule indiquée dans l'énoncé
                bouton.setTextSize((Math.abs(x - largeur / 2) + Math.abs(y - hauteur / 2))/5);
                // Le toucher est fini, on veut continuer à détecter les touchers d'après
                return true;
            }
        });

    }
}
