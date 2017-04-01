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
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static androidedu.kodluyoruz.currencycalculate.R.id.spinner;  // doğru bir kullanım mı ?

public class FirstPage extends AppCompatActivity implements View.OnClickListener, TextWatcher, AdapterView.OnItemSelectedListener {

    public boolean islem_tipi;
    public double alis_degeri;
    public double satis_degeri;
    private String doviz_turu;
    //
    private EditText tlSigned = null;
    private EditText tlDecimal;
    private EditText dovizSigned;
    private EditText dovizDecimal;
    private TextView dovizIsmi;
    private Button btnChangeCurrency;
    private Spinner spinner;

    public double getAlis_degeri() {
        return alis_degeri;
    }

    public void setAlis_degeri(double alis_degeri) {
        this.alis_degeri = alis_degeri;
    }

    public double getSatis_degeri() {
        return satis_degeri;
    }

    public void setSatis_degeri(double satis_degeri) {
        this.satis_degeri = satis_degeri;
    }

    public String getDoviz_turu() {
        return doviz_turu;
    }

    public void setDoviz_turu(String doviz_turu) {
        this.doviz_turu = doviz_turu;
    }
//    public int tl_signed_alan;
//    public int tl_decimal_alan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        initView();
        initEvent();
    }


    public void initView() {


        spinner = (Spinner) findViewById(R.id.spinner);


        tlSigned = (EditText) findViewById(R.id.activity_first_page_tlSigned);
        tlDecimal = (EditText) findViewById(R.id.activity_first_page__tlDecimal);
        dovizSigned = (EditText) findViewById(R.id.activity_first_page_dovizSigned);
        dovizDecimal = (EditText) findViewById(R.id.activity_first_page_dovizDecimal);
        dovizIsmi = (TextView) findViewById(R.id.activity_first_page_dovizIsmi);
        btnChangeCurrency = (Button) findViewById(R.id.activity_first_page_buttonchangecurrency);


    }

    public void initEvent() {

        btnChangeCurrency.setOnClickListener(this);
        tlSigned.addTextChangedListener(this);
        tlDecimal.addTextChangedListener(this);
        ArrayAdapter spinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(this);

    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        Log.e(tlSigned.getText().toString(), "onTextChanged: ");
        if (String.valueOf(tlSigned.getText()).trim().startsWith("0")) {
            if (String.valueOf(tlSigned.getText()).trim().length() == 1) {
                tlSigned.setText("");
            } else {
                tlSigned.setText(tlSigned.getText().subSequence(1, tlSigned.getText().length()));
            }

        }

        CalculateCurrency();

    }


    public void CalculateCurrency() {
        double totalAmount = Double.valueOf(String.valueOf(tlSigned.getText()) + "." + String.valueOf(tlDecimal.getText()));
        if (islem_tipi == true) {
            dovizSigned.setText(String.valueOf(totalAmount * satis_degeri).split("//.")[0]);
            dovizDecimal.setText(String.valueOf(totalAmount * satis_degeri).split("//.")[1]);
        } else {
            dovizSigned.setText(String.valueOf(totalAmount * alis_degeri).split("//.")[0]);
            dovizDecimal.setText(String.valueOf(totalAmount * alis_degeri).split("//.")[1]);
        }
            }

    @Override
    public void afterTextChanged(Editable s) {
//        if(s.hashCode() == tlSigned.getText().hashCode()){ // burada iki adet edittexttehn hangisinin değiştiğini kontrol edebilirsin
//
//        }
//        else(s.hashCode() == tlDecimal.getText().hashCode()){
//
//        }
    }


    @Override
    public void onClick(View v) {

        Intent intent = new Intent(FirstPage.this, SecondPage.class);
        startActivity(intent);
        finish();


    }


    @Override
    protected void onResume() {
        super.onResume();
        Intent myIntent = (FirstPage.this).getIntent();

//        alis_degeri = myIntent.getExtras().getString("alis");
//        satis_degeri = myIntent.getExtras().getString("satis");
        //  String s = myIntent.getExtras().getString("doviz");
        //  dovizIsmi.setText(s);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        islem_tipi = position == 0;
        // CalculateCurrency();
//
//
//        if (islem_tipi == "Alış") { // parent.getItemAtPosition(position).toString() // böyle yapma çünkü String değerleri
//            AlisHesapla(alis_degeri);                                   // değiştirmek istediğinde bu alanları edit etmen zor olacaktır.
//        } else if (islem_tipi == "Satış") {
//            SatisHesapla(satis_degeri);
//        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}





