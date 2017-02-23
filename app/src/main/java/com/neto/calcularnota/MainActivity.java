package com.neto.calcularnota;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText nota1;
    private EditText nota2;
    private EditText edad;
    private TextView result;
    private TextView result_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nota1 = (EditText) findViewById(R.id.edt_nota1);
        nota2 = (EditText) findViewById(R.id.edt_nota2);
        edad = (EditText) findViewById(R.id.edt_edad);
        result = (TextView) findViewById(R.id.result);
        result_value = (TextView) findViewById(R.id.result_value);


    }


    public void calcular(View v) {

        try {
            double n1 = Double.parseDouble(nota1.getText().toString());
            double n2 = Double.parseDouble(nota2.getText().toString());
            double ed = Double.parseDouble(edad.getText().toString());
            double media = (0.4 * n1) + (0.6 * ((n2 * 0.95) + (ed * 0.05)));
            result.setVisibility(View.VISIBLE);
            result_value.setText(String.format("%.2f", media));
            if (media >= 5) {
                Toast.makeText(this, "Parabéns, você foi aprovado!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Desculpe, mas você foi reprovado!", Toast.LENGTH_LONG).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onBackPressed() {
        ExitDialog exitDialog = new ExitDialog();
        exitDialog.show(getFragmentManager(), "exit");
    }

    public void limpar(View view) {
        nota1.setText(null);
        nota2.setText(null);
        edad.setText(null);
        result.setVisibility(View.GONE);
        result_value.setText(null);

    }
}
