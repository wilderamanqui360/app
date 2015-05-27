package com.example.administrator.miprimeraplicacion;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by Administrator on 21/05/2015.
 */
public class ActividadPrincipal extends Activity {

    Button btnProcesar;
    ProgressBar progressBar;

    private static final int AVANCE = 10;
    Handler handler = new Handler();
    private int mavance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO
        setContentView(R.layout.actividadprincipal);

        btnProcesar = (Button) findViewById(R.id.btnProcesar);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mavance = 0;
        new Thread(new Runnable() {
            int fin = 100;

            @Override
            public void run() {
                int i = 0;

                while (mavance < fin) {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d(getLocalClassName(), "" + i);
                    mavance = i+ i * AVANCE;
                    i++;

                    progressBar.setProgress(mavance);
                    /*handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(mavance);
                        }
                    });*/
                }


            }
        }).start();

        /*btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActividadPrincipal.this,"onclick de : " + btnProcesar.getText(),Toast.LENGTH_SHORT).show();
            }
        });*/


    }


    public void procesarBoton(View view) {

        Toast.makeText(ActividadPrincipal.this, "onclick de : " + btnProcesar.getText(), Toast.LENGTH_SHORT).show();
    }
}
