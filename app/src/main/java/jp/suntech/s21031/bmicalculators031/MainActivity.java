package jp.suntech.s21031.bmicalculators031;

import static java.lang.Float.parseFloat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClickBtnListener listener = new ClickBtnListener();

        Button btCalc = findViewById(R.id.btnCalc);
        btCalc.setOnClickListener(listener);
        Button btClear = findViewById(R.id.btnClear);
        btClear.setOnClickListener(listener);
    }

    private class ClickBtnListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {

            EditText age = findViewById(R.id.etAge);
            EditText height = findViewById(R.id.etHeight);
            EditText weight = findViewById(R.id.etWeight);
           // String strA = (String)(""+age.getText());
            String strH = (String)(""+height.getText());
            String strW = (String)(""+weight.getText());
            //int numA = Integer.parseInt(strA);
            float numH = parseFloat(strH);
            float numW = parseFloat(strW);

            TextView resultBMI = findViewById(R.id.resultBMI);
            TextView bestWeight = findViewById(R.id.bestWeight);
            TextView msgBMI = findViewById(R.id.msgBMI);
            TextView msgWeight = findViewById(R.id.msgWeight);
            TextView kilogram = findViewById(R.id.resultKG);

            int id = view.getId();
            switch(id){
                case R.id.btnCalc:
                    /*if(numA<16){
                        ConfirmDialogFragment dialogFragment = new ConfirmDialogFragment();
                        dialogFragment.show(getSupportFragmentManager(),"ConfirmDialogFragment");
                    }*/
                    //else{
                        float bmi = 10000*numW/numH/numH;
                        resultBMI.setText(String.format("%.1f",bmi));
                        float bestW = 22*numH*numH/10000;
                        bestWeight.setText(String.format("%.1f",bestW));

                        msgBMI.setText(R.string.msg_bmi);
                        msgWeight.setText(R.string.msg_weight);
                        kilogram.setText(R.string.kilogram);
                    //}
                    break;
                case R.id.btnClear:
                    age.setText("");
                    height.setText("");
                    weight.setText("");
                    resultBMI.setText("");
                    bestWeight.setText("");
                    msgBMI.setText("");
                    msgWeight.setText("");
                    kilogram.setText("");
                    break;
            }
        }
    }

    /*public class ConfirmDialogFragment extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle saveInstanceState){

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(R.string.dlg_title);
            builder.setMessage(R.string.dlg_msg);20

            builder.setPositiveButton(R.string.dlg_btn, new DialogButtonClickListener());
            AlertDialog dialog = builder.create();
            return dialog;
        }

        private class DialogButtonClickListener implements DialogInterface.OnClickListener{

            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        EditText age = findViewById(R.id.etAge);
                        EditText height = findViewById(R.id.etHeight);
                        EditText weight = findViewById(R.id.etWeight);
                        age.setText("");
                        height.setText("");
                        weight.setText("");
                        break;
                }
            }
        }
    }*/
}