package androidedu.kodluyoruz.currencycalculate;

/**
 * Created by rozerin on 21.03.2017.
 */


public class Currency {
    private String doviz_ismi;
    private int alis;
    private int satis;
    private boolean doviz_tipiMi;

    public Currency(String doviz_ismi, int alis, int satis) {
        super();
        this.doviz_ismi = doviz_ismi;
        this.alis = alis;
        this.satis = satis;
        //  this.doviz_tipiMi = doviz_tipiMi;
    }

    @Override
    public String toString() {
        return doviz_ismi;
    }

    public String getDoviz_ismi() {
        return doviz_ismi;
    }

    public void setDoviz_ismi(String doviz_ismi) {
        this.doviz_ismi = doviz_ismi;
    }

    public int getAlis() {
        return alis;
    }

    public void setAlis(int alis) {
        this.alis = alis;
    }

    public int getSatis() {
        return satis;
    }

    public void setSatis(int alis) {
        this.satis = satis;
    }

//    public boolean isDoviz_tipiMi() {
//        return doviz_tipiMi;
//    }
//    public void setDoviz_tipiMi() {
//        this.doviz_tipiMi = doviz_tipiMi;
//    }

}
