package id.dolano.pdt2;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Switch swcNightModeSwitch;

    ImageView imgPreview;

    TextView txtDescription;

    Button  btnSnipers,
            btnRifles,
            btnGrenades,
            btnPistols;

    /*
     * 0 - Default
     * 1 - AWP
     * 2 - SSG
     * 3 - AK47
     * 4 - M4A4
     * 5 - HE
     * 6 - Smoke
     * 7 - USPS
     * 8 - P250
     */
    int currentWeapon = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (InitApplication.getInstance().isNightModeEnabled()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        setContentView(R.layout.activity_main);

        /* --- Hide Top Bar --- */
        try{
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {}
        /* ---------------------- */


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

        /* --- Change The Night Mode Switch to corresponding state --- */
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
            swcNightModeSwitch.setChecked(true);
        /* ----------------------------------------------------------- */

        /* --- Night Mode Switch Listeners --- */
        swcNightModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    InitApplication.getInstance().setIsNightModeEnabled(true);
                } else {
                    InitApplication.getInstance().setIsNightModeEnabled(false);
                }

                Intent intent = getIntent();
                intent.putExtra("lastWeapon", currentWeapon);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                startActivity(intent);
            }
        });
        /* ------------------------------------ */

        /* Prevent Preview to reset to default values */
        this.currentWeapon = getIntent().getIntExtra("lastWeapon", 0);
        this.changePreview();
        /* ------------------------------------------ */
    }

    /* --- Changes Current Preview (Image and TextView) --- */
    public void changePreview(){
        @DrawableRes int img;
        @StringRes int txt;
        switch(this.currentWeapon){
            default:
            case 0: // Default
                img = R.drawable.preview_default;
                txt = R.string.desc_default;
                break;
            case 1: // AWP
                img = R.drawable.w_awp;
                txt = R.string.desc_awp;
                break;
            case 2: // SSG
                img = R.drawable.w_ssg08;
                txt = R.string.desc_ssg08;
                break;
            case 3: // AK47
                img = R.drawable.w_ak47;
                txt = R.string.desc_ak47;
                break;
            case 4:
                img = R.drawable.w_m4a4;
                txt = R.string.desc_m4a4;
                break;
            case 5:
                img = R.drawable.g_he;
                txt = R.string.desc_he;
                break;
            case 6:
                img = R.drawable.g_smoke;
                txt = R.string.desc_smoke;
                break;
            case 7:
                img = R.drawable.w_usps;
                txt = R.string.desc_usps;
                break;
            case 8:
                img = R.drawable.w_p250;
                txt = R.string.desc_p250;
                break;
        }

        this.imgPreview.setImageResource(img);
        this.txtDescription.setText(txt);
    }
    /* ----------------------_*/

    /* --- Button On Click Listeners --- */
    /*
     * save current state of preview and immediately call
     * changePreview() to change current preview
     */
    boolean snipersStatus = false;
    public void btnSnipersOnClick(View view){
        this.snipersStatus = !this.snipersStatus;
        this.currentWeapon = this.snipersStatus ? 1 : 2 ;
        this.changePreview();
    }

    boolean riflesStatus = false;
    public void btnRiflesOnClick(View view){
        this.riflesStatus = !this.riflesStatus;
        this.currentWeapon = this.riflesStatus ? 3 : 4 ;
        this.changePreview();
    }

    boolean grenadesStatus = false;
    public void btnGrenadesOnClick(View view){
        this.grenadesStatus = !this.grenadesStatus;
        this.currentWeapon = this.grenadesStatus ? 5 : 6 ;
        this.changePreview();
    }

    boolean pistolStatus = false;
    public void btnPistolsOnClick(View view){
        this.pistolStatus = !this.pistolStatus;
        this.currentWeapon = this.pistolStatus ? 7 : 8 ;
        this.changePreview();
    }
    /* --------------- */
}
