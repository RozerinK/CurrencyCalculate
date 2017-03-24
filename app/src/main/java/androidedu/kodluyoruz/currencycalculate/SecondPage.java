package androidedu.kodluyoruz.currencycalculate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by rozerin on 20.03.2017.
 */

public class SecondPage extends Activity implements AdapterView.OnItemClickListener {
    final ListView listemiz = (ListView) findViewById(R.id.activity_second_page_currencylist);
    final List<Currency> gunceldoviz = new ArrayList<Currency>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        Intent i = getIntent();

        gunceldoviz.add(new Currency("USD", 3, 3));
        gunceldoviz.add(new Currency("EUR", 3, 3));
        gunceldoviz.add(new Currency("CHF", 3, 3));


        Adapter adaptorumuz = new Adapter(SecondPage.this, gunceldoviz);
        listemiz.setAdapter(adaptorumuz);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Currency passDoviz = gunceldoviz.get(position);
        Intent myIntent = new Intent(SecondPage.this, FirstPage.class);
        myIntent.putExtra("dovizismi", passDoviz.getDoviz_ismi());
        myIntent.putExtra("alis", passDoviz.getAlis());
        myIntent.putExtra("satis", passDoviz.getSatis());
        startActivity(myIntent);

    }
}


