package androidedu.kodluyoruz.currencycalculate;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
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

public class FirstPage extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    public String islem_tipi;
    public int alis_degeri;
    public int satis_degeri;
    public String doviz_ismi;
    //
    EditText tlSigned;
    EditText tlDecimal;
    EditText dovizSigned;
    EditText dovizDecimal;
//    public int tl_signed_alan;
//    public int tl_decimal_alan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        initView();
    }


    public void initView() {


        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        TextView tlTutarı = (TextView) findViewById(R.id.activity_first_page_tlTutarı);
        tlSigned = (EditText) findViewById(R.id.activity_first_page_tlSigned);
        TextView comma1 = (TextView) findViewById(R.id.activity_first_page_comma1);
        tlDecimal = (EditText) findViewById(R.id.activity_first_page__tlDecimal);
        TextView tlIsmi = (TextView) findViewById(R.id.activity_first_page_TL);

        TextView dovizTutarı = (TextView) findViewById(R.id.activity_first_page_dovizTutarı);
        dovizSigned = (EditText) findViewById(R.id.activity_first_page_dovizSigned);
        TextView comma = (TextView) findViewById(R.id.activity_first_page_comma);
        dovizDecimal = (EditText) findViewById(R.id.activity_first_page_dovizDecimal);
        TextView dovizIsmi = (TextView) findViewById(R.id.activity_first_page_dovizIsmi);


//        tl_signed_alan = Integer.parseInt(tlSigned.getText().toString());
//        tl_decimal_alan = Integer.parseInt(tlDecimal.getText().toString());
        Button btnChangeCurrency = (Button) findViewById(R.id.activity_first_page_buttonchangecurrency);
        btnChangeCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstPage.this, SecondPage.class);
                startActivity(intent);
                finish();
            }
        });



    }

    public void initEvent(final Spinner spinner) {
        //passNext.setOnClickListener(this);


//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//               // islem_tipi = spinner.getSelectedItem().toString();
////                // diğer sayfadan aldığın döviz cinsini doviz_ismi değişkenne burada ata
//                if (islem_tipi == "Alış") { // parent.getItemAtPosition(position).toString()
//                    AlisHesapla(alis_degeri);
//                } else if (islem_tipi == "Satış") {
//                    SatisHesapla(satis_degeri);
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//
//
//  });
        tlSigned.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                islem_tipi = spinner.getSelectedItem().toString();
                Intent myIntent = FirstPage.this.getIntent();
                alis_degeri = myIntent.getExtras().getInt("alis");
                satis_degeri = myIntent.getExtras().getInt("satis");
                doviz_ismi = myIntent.getExtras().getString("dovizismi");

                if (Integer.parseInt(s.toString()) != 00) {
                    if (islem_tipi == "Alış") { // parent.getItemAtPosition(position).toString()
                        AlisHesapla(alis_degeri);
                    } else if (islem_tipi == "Satış") {
                        SatisHesapla(satis_degeri);
                    }

                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {

            }


        });
    }


    public void AlisHesapla(int alis_degeri) {
        int x = Integer.parseInt(tlSigned.getText().toString());
        dovizSigned.setText(x * alis_degeri);


    }

    public void SatisHesapla(int satis_degeri) {
        int x = Integer.parseInt(tlSigned.getText().toString());
        dovizSigned.setText(x * satis_degeri);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onClick(View v) {

    }
}





