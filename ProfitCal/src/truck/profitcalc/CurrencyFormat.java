package truck.profitcalc;

import android.text.Editable;
import android.text.TextWatcher;

public class CurrencyFormat implements TextWatcher {

    public void onTextChanged(CharSequence arg0, int start, int arg2,int arg3) {}

    public void beforeTextChanged(CharSequence arg0, int start,int arg2, int arg3) {}

    public void afterTextChanged(Editable arg0) {
        int length = arg0.length();
        if(length>0){
            if(nrOfDecimal(arg0.toString())>2)
                    arg0.delete(length-1, length);
        }

    }


    private int nrOfDecimal(String nr){
        int len = nr.length();
        int pos = len;
        for(int i=0 ; i<len; i++){
            if(nr.charAt(i)=='.'){
                pos=i+1;
                    break;
            }
        }
        return len-pos;
    }
}