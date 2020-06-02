package sg.edu.rp.c346.id19043996.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS, tvOCBC, tvUOB;

    String click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);
        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);

        click = "";

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the Bank");

        getMenuInflater().inflate(R.menu.menu_main, menu);

        if (v.getId() == tvDBS.getId()) {
            click = "DBS";
        } else if (v.getId() == tvOCBC.getId()) {
            click = "OCBC";
        } else if (v.getId() == tvOCBC.getId()) {
            click = "UOB";
        } else {
            click = "";
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //website is being clicked on
        if (item.getItemId() == 0) {
            if (click.equalsIgnoreCase("DBS")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.sg"));
                startActivity(intent);
            } else if (click.equalsIgnoreCase("OCBC")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.sg"));
                startActivity(intent);
            } else if (click.equalsIgnoreCase("UOB")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.sg"));
                startActivity(intent);
            }
        } else if (item.getItemId() == 1) {
            if (click.equalsIgnoreCase("DBS")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel: " + "1800 1111 111"));
                startActivity(intent);
            } else if (click.equalsIgnoreCase("OCBC")) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + "1800 3633 333"));
                startActivity(intent);
            } else if (click.equalsIgnoreCase("UOB")) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + "1800 2222 121"));
                startActivity(intent);
            }
            return super.onContextItemSelected(item);
        }

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;

        }
        return super.onOptionsItemSelected(item);
    }
}






