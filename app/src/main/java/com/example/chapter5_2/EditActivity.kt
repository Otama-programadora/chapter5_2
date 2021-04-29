@file:Suppress("DEPRECATION")

package com.example.chapter5_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_edit.*

@Suppress("DEPRECATION")
class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

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

        //setText()メソッドで各EditTextに文字列をセット
        companyEdit.setText(company)
        postalEdit.setText(postal)
        addressEdit.setText(address)
        telEdit.setText(tel)
        faxEdit.setText(fax)
        emailEdit.setText(email)
        urlEdit.setText(url)
        positionEdit.setText(position)
        nameEdit.setText(name)

        saveBtn.setOnClickListener {
            //「保存」ボタンが押されたらデータ保存関数を呼出す
            saveData()
            //EditActivityを終了してMainActivityに戻る
            finish()
        }
        cancelBtn.setOnClickListener {
            finish()
        }
    }

    //共有プリファレンスにデータを保存する関数
    private fun saveData(){
        //getDefaultSharedPreferences()メソッドでSharedPreferencesオブジェクトを取得
        val pref = PreferenceManager.getDefaultSharedPreferences(this)

        //edit()メソッドでSharedPreferences.Editorオブジェクトを取得
        val editor = pref.edit()

        //putメソッド("キー名", データ)でデータ書き込み
        editor.putString("company", companyEdit.text.toString())
            .putString("postal", postalEdit.text.toString())
            .putString("address", addressEdit.text.toString())
            .putString("tel", telEdit.text.toString())
            .putString("fax", faxEdit.text.toString())
            .putString("email", emailEdit.text.toString())
            .putString("url", urlEdit.text.toString())
            .putString("position", positionEdit.text.toString())
            .putString("name", nameEdit.text.toString())
            .apply() //非同期で共有プリファレンスに保存
    }
}