package androidedu.kodluyoruz.currencycalculate;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rozerin on 21.03.2017.
 */


public class Adapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Currency> mDovizListesi; // list arrayden bilgileri alan yer sadece currency bulunduran list kabul ediyor

    public Adapter(Activity activity, List<Currency> gunceldovız) {
        //XML'i alıp View'a çevirecek inflater'ı örnekleyelim
        mInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        //gösterilecek listeyi de alalım
        mDovizListesi = gunceldovız;
    }

    @Override
    public int getCount() {
        return mDovizListesi.size();
    }

    @Override
    public Currency getItem(int position) {
        //şöyle de olabilir: public Object getItem(int position)
        return mDovizListesi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View satirView;

        satirView = mInflater.inflate(R.id.listview_item, null);
        TextView doviz_ismi =
                (TextView) satirView.findViewById(R.id.listviem_item_dovizismi);


        TextView alisdegeri =
                (TextView) satirView.findViewById(R.id.listview_item_textview_alisdegeri);
        TextView
                satisdegeri =
                (TextView) satirView.findViewById(R.id.listview_item_textview_satisdegeri);


        Currency doviz = mDovizListesi.get(position);

        doviz_ismi.setText(doviz.getDoviz_ismi());
        satisdegeri.setText(doviz.getSatis());
        alisdegeri.setText(doviz.getAlis());


//        if (doviz.isDoviz_tipiMi()) {
//
//        }
//        else {
//
//        }
        return satirView;
    }
}