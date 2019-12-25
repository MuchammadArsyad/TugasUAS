package polinema.ac.id.androiduistarter.fragments.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import polinema.ac.id.androiduistarter.R;
import polinema.ac.id.androiduistarter.fragments.fragments.JadwalFragment;
import polinema.ac.id.androiduistarter.fragments.fragments.StadionFragment;
import polinema.ac.id.androiduistarter.fragments.fragments.PemainFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    TextView jadwal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new JadwalFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
//        jadwal= findViewById(R.id.textView);
        // beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.action_stadion:
                fragment = new StadionFragment();
                break;
            case R.id.action_pemain:
                fragment = new PemainFragment();
                break;
            case R.id.action_jadwal:
                fragment = new JadwalFragment();
                break;
        }
        return loadFragment(fragment);
    }
    
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

//    public void buttonOnClick(View view) {
//        String test = jadwal.getText().toString();
//    }
}
