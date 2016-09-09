package bistu.rookie.u_nity.androidproject_17;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private final static String SharedPreferencesFileName="config";

    private final static String Key_UserName="UserName";
    private final static String Key_UserNumber="UserNumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences preferences = getSharedPreferences(SharedPreferencesFileName, MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();

        Button writeButton=(Button)findViewById(R.id.WriteButton);
        Button btnRead=(Button)findViewById(R.id.ReadButton);
        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString(Key_UserName, "U-nity");
                editor.putInt(Key_UserNumber, 2014011456);
                editor.apply();
                Toast.makeText(MainActivity.this, "Write Success!", Toast.LENGTH_SHORT).show();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUserName = preferences.getString(Key_UserName, null);
                int numUserNumber = preferences.getInt(Key_UserNumber, 0);
                if (strUserName != null)
                    Toast.makeText(MainActivity.this, "User Name: " + strUserName + "\nUser Number: " + numUserNumber,
                            Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Something Wrong", Toast.LENGTH_LONG).show();
            }
        });
    }

}
