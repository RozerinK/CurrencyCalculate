package androidedu.kodluyoruz.currencycalculate;

/**
 * Created by rozerin on 21.03.2017.
 */


public class Currency {
    private String doviz_ismi;
    private String alis;
    private String satis;
    private boolean doviz_tipiMi;

    public Currency(String doviz_ismi, String alis, String satis) {
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

    public String getAlis() {
        return alis;
    }

    public void setAlis(String alis) {
        this.alis = alis;
    }

    public String getSatis() {
        return satis;
    }

    public void setSatis(String alis) {
        this.satis = satis;
    }

//    public boolean isDoviz_tipiMi() {
//        return doviz_tipiMi;
//    }
//    public void setDoviz_tipiMi() {
//        this.doviz_tipiMi = doviz_tipiMi;
//    }

}
