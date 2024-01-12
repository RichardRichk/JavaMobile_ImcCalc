package com.example.imccalc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.imccalc.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private TextView classification;
    private String txtClassification;
    private Button btnCalc;

    private AppBarConfiguration appBarConfiguration;
private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityMainBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

    result = findViewById(R.id.txt_result);
    classification = findViewById(R.id.txt_class);
    btnCalc = findViewById(R.id.btn_exibir);

    btnCalc.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){calcIMC();}

        public void calcIMC(){
            EditText inpAlt = findViewById(R.id.input_altura);
            EditText inpPeso = findViewById(R.id.input_peso);

            double valueAlt = Double.parseDouble(inpAlt.getText().toString());
            double valuePeso = Double.parseDouble(inpPeso.getText().toString());

            double calcResult = valuePeso/(valueAlt*valueAlt);

            if (calcResult < 18.5){
                txtClassification = "Magrelo vagabundo, Vai treina!!!!";
            } else if (calcResult <24.9){
                txtClassification = "Padrao ne!!!";
            } else if (calcResult <29.9) {
                txtClassification = "Ta ficando grandinho em!!";
            } else if (calcResult <39.9){
                txtClassification = "Oh La Em Casa, acabou o bolo!!!";
            } else{
                txtClassification = "Thais CARLAAAAAAAAAAAAAAAAAAA!!!!!";
            }

            result.setText(String.valueOf(calcResult));
            result.setVisibility(View.VISIBLE);

            classification.setText((String.valueOf(txtClassification)));
            classification.setVisibility(View.VISIBLE);


        }
    });


    }
}