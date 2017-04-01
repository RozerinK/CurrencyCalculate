package androidedu.kodluyoruz.currencycalculate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by rozerin on 20.03.2017.
 */

public class SecondPage extends Activity {

    final List<Currency> gunceldoviz = new ArrayList<Currency>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        Intent i = getIntent();

        gunceldoviz.add(new Currency("USD", "3", "4"));
        gunceldoviz.add(new Currency("EUR", "1", "2"));
        gunceldoviz.add(new Currency("CHF", "9", "5"));

        final ListView listemiz = (ListView) findViewById(R.id.activity_second_page_currencylist);
        Adapter adaptorumuz = new Adapter(SecondPage.this, gunceldoviz);
        listemiz.setAdapter(adaptorumuz);

        listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView parentView, View v, int position, long id) {

                Currency passDoviz = (Currency) parentView.getItemAtPosition(position);
                Log.e(passDoviz.getDoviz_ismi(), "onItemClick: ");
                Intent myIntent = new Intent(SecondPage.this, FirstPage.class);

                myIntent.putExtra("doviz", String.valueOf(passDoviz.getDoviz_ismi()));
                Log.e("doviz.i", "doviz");
                myIntent.putExtra("xx", String.valueOf(passDoviz.getAlis()));
                myIntent.putExtra("satis", String.valueOf(passDoviz.getSatis()));
                Log.e("doviz.i", "alis");
                Log.e("doviz.i", "satis");
                // setResult(Activity.RESULT_OK,myIntent);
                startActivity(myIntent);
                finish();
            }


        });


    }


}