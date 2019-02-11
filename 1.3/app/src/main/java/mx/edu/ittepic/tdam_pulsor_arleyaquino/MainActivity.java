package mx.edu.ittepic.tdam_pulsor_arleyaquino;

import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    Button pulsar;
    TextView numero;
    CountDownTimer t;
    float i=1, a;
    double c=0;
    String estado;
    DecimalFormat df;
    int x=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pulsar=findViewById(R.id.pulsar);
        numero=findViewById(R.id.numero);

        estado=pulsar.getText().toString();

aleatorio();
        pulsar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    x=x+1;
                    if(x==1){
                        t = new CountDownTimer(1000, 200) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                DecimalFormat df = new DecimalFormat("0.0");
                                String y = df.format(i+=0.1);
                                if (i>=1 && i<3)pulsar.setText(y);
                                else i=1;


                            }
                            @Override
                            public void onFinish() {
                                start();
                            }

                        }; t.start();
                    }

                    if(x==2)validar();
            }
        });
    }

    private void validar() {
            t.cancel();  x=0;
            if(pulsar.getText().equals(numero.getText())){
                final AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                alerta.setTitle("HAZ GANADO").setMessage("")
                        .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                pulsar.setText("INICIAR");
                                aleatorio();
                            }
                        })
                        .show();
                return;
            }

            AlertDialog.Builder alerta1 = new AlertDialog.Builder(MainActivity.this);
            alerta1.setTitle("HAZ PERDIDO").setMessage("")
                    .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            pulsar.setText("INICIAR");
                            aleatorio();
                        }
                    })
                    .show();

    }

    private void aleatorio() {
        Random rand = new Random();
        c = 1+(3-1)* rand.nextDouble();
        DecimalFormat df = new DecimalFormat("0.0");
        String aaa=df.format(c);
        numero.setText(aaa);
    }
}
