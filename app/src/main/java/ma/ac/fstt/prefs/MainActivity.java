package ma.ac.fstt.prefs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtL, txtP;
    CheckBox chkS;
    Button btnE;
    SharedPreferences prf;

    private void getPrefs()
    {
        txtL.setText(prf.getString("l","?"));
        txtP.setText(prf.getString("p","?"));

    }

    private void savePrefs() {

        SharedPreferences.Editor edt = prf.edit();

        edt.putString("l",
                txtL.getText().toString());
        edt.putString("p",
                txtP.getText().toString());
        edt.apply();

    }


    public void doEnter(View v) {

      if (chkS.isChecked())
          savePrefs();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtL = findViewById(R.id.txtLogin);
        txtP = findViewById(R.id.txtPwd);
        chkS = findViewById(R.id.chkSave);
        btnE = findViewById(R.id.btnEnter);

        prf = this.getSharedPreferences("MyPrefs",MODE_PRIVATE);

        getPrefs();

    }
}
