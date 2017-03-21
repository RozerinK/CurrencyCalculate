package androidedu.kodluyoruz.currencycalculate;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static androidedu.kodluyoruz.currencycalculate.R.id.spinner;  // doğru bir kullanım mı ?

public class FirstPage extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, TextWatcher {

    public String islem_tipi;
    public int alis_degeri;
    public int satis_degeri;
    public String doviz_ismi;
    public int tl_signed_alan;
    public int tl_decimal_alan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        initView();
    }


    public void initView() {


        Spinner spinner = (Spinner) findViewById(spinner);

        TextView tlTutarı = (TextView) findViewById(R.id.activity_first_page_tlTutarı);
        EditText tlSigned = (EditText) findViewById(R.id.activity_first_page_tlSigned);
        TextView comma1 = (TextView) findViewById(R.id.activity_first_page_comma1);
        EditText tlDecimal = (EditText) findViewById(R.id.activity_first_page__tlDecimal);
        TextView tlIsmi = (TextView) findViewById(R.id.activity_first_page_TL);

        TextView dovizTutarı = (TextView) findViewById(R.id.activity_first_page_dovizTutarı);
        EditText dovizSigned = (EditText) findViewById(R.id.activity_first_page_dovizSigned);
        TextView comma = (TextView) findViewById(R.id.activity_first_page_comma);
        EditText dovizDecimal = (EditText) findViewById(R.id.activity_first_page_dovizDecimal);
        TextView dovizIsmi = (TextView) findViewById(R.id.activity_first_page_dovizIsmi);
        Button passNext = (Button) findViewById(R.id.activity_first_page_passNext);

        tl_signed_alan = Integer.parseInt(tlSigned.getText().toString());
        tl_decimal_alan = Integer.parseInt(tlDecimal.getText().toString());
        Button btnChangeCurrency = (Button) findViewById(R.id.activity_first_page_buttonchangecurrency);

        initEvent(passNext, spinner);

    }

    public void initEvent(Button passNext, final Spinner spinner) {
        passNext.setOnClickListener(this);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                islem_tipi = spinner.getSelectedItem().toString();
                // diğer sayfadan aldığın döviz cinsini doviz_ismi değişkenne burada ata
                if (islem_tipi == "Alış") { // parent.getItemAtPosition(position).toString()
                    AlisHesapla(doviz_ismi);
                } else if (islem_tipi == "Satış") {
                    SatisHesapla(doviz_ismi);
                }
            }


        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(FirstPage.this, SecondPage.class);
        startActivity(intent);
    }


    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        getActivity().getIntent().getExtras().to
        if (tl_signed_alan != 00 && tl_decimal_alan != 0) {

        }
    }

    public void AlisHesapla(doviz_ismi,) {
        if (doviz_ismi == "USD")
        =tl_signed_alan
    }

    public void SatisHesapla(doviz_ismi,) {
        if (doviz_ismi == "USD")
    }
}

