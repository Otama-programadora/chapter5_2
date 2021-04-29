@file:Suppress("DEPRECATION")

package com.example.chapter5_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        val pref = PreferenceManager.getDefaultSharedPreferences(this)

        //getメソッド("キー名", デフォルト値(""))で共有プリファレンスからデータ取得。該当データがなければデフォルト値が返ってくる
        val company = pref.getString("company", "")
        val postal = pref.getString("postal", "")
        val address = pref.getString("address", "")
        val tel = pref.getString("tel", "")
        val fax = pref.getString("fax", "")
        val email = pref.getString("email", "")
        val url = pref.getString("url", "")
        val position = pref.getString("position", "")
        val name = pref.getString("name", "")

        //TextViewのtextプロパティにデータを置く
        companyText.text = company
        postalText.text = postal
        addressText.text = address
        telText.text = tel
        faxText.text = fax
        emailText.text = email
        urlText.text = url
        positionText.text = position
        nameText.text = name
    }

    //メニューを表示するための関数
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.edit -> {
                //「編集」ボタンが押されたらEditActivityに遷移
                val intent = Intent(this, EditActivity::class.java)
                //::class.javaでクラスのインスタンスを取得
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}