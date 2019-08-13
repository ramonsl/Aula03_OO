package com.example.aula03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtToast;
    Button btnToast;
    SeekBar seekAvaliacao;
    RatingBar rtbAvaliavao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtToast = findViewById(R.id.edtToast);
        btnToast = findViewById(R.id.btnToast);
        rtbAvaliavao = findViewById(R.id.rtbAvaliavao);
        seekAvaliacao = findViewById(R.id.seekAvaliacao);


        seekAvaliacao.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int valor=0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    valor=progress;
                    criarToast(Integer.valueOf(valor).toString());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                edtToast.setText(Integer.valueOf(valor).toString());
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                edtToast.setText(Integer.valueOf(valor).toString());

            }
        });


        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtToast.length()!=0) {
                    Toast.makeText(MainActivity.this, edtToast.getText().toString(), Toast.LENGTH_LONG).show();
                } else{
                    criarToast("Preencha o campo");
                }

            }
        });


    rtbAvaliavao.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            criarToast(Float.toString(rating));
        }
    });

    }

   public void criarToast(String texto){
       Toast.makeText(MainActivity.this, texto, Toast.LENGTH_LONG).show();
   }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id =item.getItemId();
        if(id == R.id.action_add){
            criarToast("Botão add clicado");
        }

        if(id == R.id.action_rem){
            criarToast("Botão rem clicado");
        }
        return true;


    }
}
