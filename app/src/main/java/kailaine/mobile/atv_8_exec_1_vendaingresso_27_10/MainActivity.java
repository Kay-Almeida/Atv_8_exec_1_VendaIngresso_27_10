package kailaine.mobile.atv_8_exec_1_vendaingresso_27_10;
/*
 *@author:<Kailaine Almeida de Souza RA: 1110482313026>
 */
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import kailaine.mobile.atv_8_exec_1_vendaingresso_27_10.model.Ingresso;
import kailaine.mobile.atv_8_exec_1_vendaingresso_27_10.model.IngressoVip;

public class MainActivity extends AppCompatActivity {

    private EditText etCod, etValor, etFuncao;
    private TextView tvInfo;
    private Button btnComprar;
    private CheckBox cbVIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etCod = findViewById(R.id.etCod);
        etValor = findViewById(R.id.etValor);
        etFuncao = findViewById(R.id.etFuncao);
        tvInfo = findViewById(R.id.tvInfo);
        btnComprar = findViewById(R.id.btnComprar);
        cbVIP = findViewById(R.id.cbVIP);

        btnComprar.setOnClickListener(op -> calcular());
    }

    private void calcular() {
        float taxa = (float) 15.50F;
        String cod = etCod.getText().toString();
        float preco = Float.parseFloat(etValor.getText().toString());
        float valorFinal;
        Bundle bundle = new Bundle();

        if(cbVIP.isChecked()){
            String funcao = etFuncao.getText().toString();
            Ingresso ingresso = new IngressoVip(cod, preco, funcao);
            valorFinal = ingresso.valorfinal(taxa);
            bundle.putString("funcao", funcao);
            bundle.putString("valorFinal", String.valueOf(valorFinal));
            bundle.putString("tipo", "VIP");
        }else{
            Ingresso ingresso = new Ingresso(cod, preco);
            valorFinal =ingresso.valorfinal(taxa);
            bundle.putString("valorFinal", String.valueOf(valorFinal));
            bundle.putString("tipo", "Normal");
        }

        bundle.putString("preco", String.valueOf(preco));
        bundle.putString("cod", cod);

        troca(bundle);
    }

    private void troca(Bundle bundle) {
        Intent i = new Intent(this, SaidaActivity.class);
        i.putExtras(bundle);
        this.startActivity(i);
        this.finish();
    }
}