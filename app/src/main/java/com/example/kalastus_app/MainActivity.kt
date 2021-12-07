package com.example.kalastus_app
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isVisible
import com.google.android.material.button.MaterialButtonToggleGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_fourth.*
import kotlinx.android.synthetic.main.fragment_fourth.btg_theme
import kotlinx.android.synthetic.main.fragment_fourth.buttonKalaennatys
import kotlinx.android.synthetic.main.fragment_fourth.buttonKalavale
import kotlinx.android.synthetic.main.fragment_fourth.buttonKalavalikko
import android.content.SharedPreferences
import java.util.ArrayList
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val appSettingPrefs: SharedPreferences = getSharedPreferences("AppSettingPrefs", 0)
        val sharedPrefsEdit: SharedPreferences.Editor = appSettingPrefs.edit()
        val isNightModeOn: Boolean = appSettingPrefs.getBoolean("NightMode", true)
supportFragmentManager.beginTransaction().replace(R.id.flFragment,FourthFragment()).commit()


       /*btg_theme.addOnButtonCheckedListener(object : MaterialButtonToggleGroup.OnButtonCheckedListener {
            override fun onButtonChecked(
                group: MaterialButtonToggleGroup?,
                selectedBtnId: Int,
                isChecked: Boolean
            ) {
                val theme = when (selectedBtnId) {
                    R.id.btn_Light -> AppCompatDelegate.MODE_NIGHT_NO
                    else -> AppCompatDelegate.MODE_NIGHT_YES
                }
                Log.d(TAG, "isChecked: $isChecked theme:$theme")
                AppCompatDelegate.setDefaultNightMode(theme)
            }

        })*/

        /*buttonKalavalikko.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.flFragment,FirstFragment()).commit()
        }

        buttonKalaennatys.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.flFragment,SecondFragment()).commit()
        }

        buttonKalavale.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.flFragment,ThirdFragment()).commit()
        }*/



    }
}