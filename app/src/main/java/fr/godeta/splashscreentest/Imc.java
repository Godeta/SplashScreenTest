package fr.godeta.splashscreentest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Imc extends AppCompatActivity {

    // La chaîne de caractères par défaut
    private final String defaut = "Vous devez cliquer sur le bouton « Calculer l'IMC » pour obtenir un résultat.";
    // La chaîne de caractères de la megafonction
    private final String megaString = "Vous faites un poids parfait ! Wahou ! Trop fort ! On dirait Brad Pitt (si vous êtes un homme)/Angelina Jolie (si vous êtes une femme)/Willy (si vous êtes un orque) !";

    CheckBox Cbox;
    RadioGroup Rg;
    EditText poidsInput;
    EditText tailleInput;
    Button ImcCalc;
    Button reset;
    TextView result;
    TextView result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
        //initialisation
        Cbox = findViewById(R.id.Cbox);
        Rg = findViewById(R.id.rg2);
        poidsInput = findViewById(R.id.poidsInput);
        tailleInput = findViewById(R.id.tailleInput);
        ImcCalc = findViewById(R.id.ImcCalcButton);
        reset = findViewById(R.id.ResetButton);
        result = findViewById(R.id.result);
        result2 = findViewById(R.id.result2);

        //calcul de l'imc lors d'un clic sur le bouton, on récupère les valeurs, message avec toast si on a un 0, affichage dans result sinon
        ImcCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //récupération du texte et retranscription en float
            String poids = poidsInput.getText().toString();
            String taille = tailleInput.getText().toString();
            float p = Float.valueOf(poids);
            float t = Float.valueOf(taille);
            if(Rg.getCheckedRadioButtonId() == R.id.centi){//si on a mis notre taille en centimètres
                t/=100;//on divise t par 100 pour le calcul
            }
            //si on a bien des valeurs de poids et taille postives on calcule l'IMC
            if (p >0 && t >0){
                result.setText("Resultat : "+ p/(t*t));
            }
            else { //sinon petit message d'erreur
                Toast.makeText(Imc.this, "Taille ou poids incorrect !", Toast.LENGTH_SHORT).show();
            }
            }
        });

        //si on clique sur la checkbox changement de text de result2
        Cbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Cbox.isChecked()){
                    result2.setText(megaString);
                }
                else {
                    result2.setText(defaut);
                }
            }
        });

        //reset des valeurs dans les editabletext lors d'un clic sur le bouton
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tailleInput.getText().clear();
                poidsInput.getText().clear();
            }
        });
    }
}
