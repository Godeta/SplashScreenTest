package fr.godeta.splashscreentest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test = (RadioGroup) findViewById(R.id.radiogroup1);
        test.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // This will get the radiobutton that has changed in its check state
                RadioButton checkedRadioButton = (RadioButton)group.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();
                // If the radiobutton that has changed in check state is now checked...
                if (isChecked)
                {
                    // Changes the textview's text to "Checked: example radiobutton text"
                    checkedRadioButton.setText("Checked DESKA !" + " id :" + checkedId);
                }
                int id = checkedId;
                if(id == -1) {
                    //pas de boutton selectionné

                    Log.i("myActivity", "OH MY GOOOOOOD !!!!");
                }
                else if (id == 1){
                    //démarrer une page pour un bouton qui grossi ou retreci
                    Intent intent = new Intent(getApplicationContext(),ButtonVarSize.class);
                    startActivity(intent);
                    finish();
                }

                else if (id == 3){
                    //démarrer une page pour l'imc
                    Intent intent = new Intent(getApplicationContext(),Imc.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    //boutton 1 ou 2
                    Log.i("myActivity", "L'id est : " + id);
                }
            }
        });

    }
}
