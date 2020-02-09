package id.dolano.pdt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Switch swcNightModeSwitch;

    ImageView imgPreview;

    TextView txtDescription;

    Button  btnSnipers,
            btnRifles,
            btnGrenades,
            btnPistols;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {}

        /* --- Get All Widgets --- */
        // -- Switches
        this.swcNightModeSwitch = (Switch)findViewById(R.id.swc_night_mode);

        // -- ImageViews
        this.imgPreview = (ImageView)findViewById(R.id.img_weapon_preview);

        // -- TextViews
        this.txtDescription =  (TextView)findViewById(R.id.txt_weapon_description);

        // -- Buttons
        this.btnSnipers  = (Button)findViewById(R.id.btn_sniper);
        this.btnRifles   = (Button)findViewById(R.id.btn_rifle);
        this.btnGrenades = (Button)findViewById(R.id.btn_grenade);
        this.btnPistols  = (Button)findViewById(R.id.btn_pistol);
        /* ----------------------- */
    }

    public void btnSnipersOnClick(View view){}
    public void btnRiflesOnClick(View view){}
    public void btnGrenadesOnClick(View view){}
    public void btnPistolsOnClick(View view){}
}
