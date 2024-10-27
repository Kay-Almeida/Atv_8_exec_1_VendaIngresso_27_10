package kailaine.mobile.atv_8_exec_1_vendaingresso_27_10;
/*
 *@author:<Kailaine Almeida de Souza RA: 1110482313026>
 */
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import kailaine.mobile.atv_8_exec_1_vendaingresso_27_10.model.Ingresso;
import kailaine.mobile.atv_8_exec_1_vendaingresso_27_10.model.IngressoVip;

public class SaidaActivity extends AppCompatActivity {

    private Ingresso ingresso;
    private IngressoVip ingressoVip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saida);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView tvSaida = findViewById(R.id.etSaida);
        tvSaida.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String tipo = bundle.getString("tipo");

        String cod = bundle.getString("cod");
        String funcao = bundle.getString("funcao");
        float preco = Float.parseFloat(bundle.getString("preco"));
        String valorFinal = bundle.getString("valorFinal");

        if(tipo.equals("VIP")){
            ingressoVip = new IngressoVip(cod, preco, funcao);
            tvSaida.setText(tipo+ "\n"+ ingressoVip.getCodIdentificador()+"\n"+ingressoVip.getValor()+"\n"+ingressoVip.getFuncao()+"\n"+valorFinal);
        }else{
            ingresso = new Ingresso(cod, preco);
            tvSaida.setText(tipo+ "\n"+ ingresso.getCodIdentificador()+"\n"+ingresso.getValor()+"\n"+valorFinal);
        }
        
        btnVoltar.setOnClickListener(op -> voltar());


    }

    private void voltar() {
        Intent i = new Intent (this, MainActivity.class);
        this.startActivity(i);
        this.finish();
    }
}