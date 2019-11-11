
package jp.ac.asojuku.mytoratora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        //ボタンがクリックされたら処理を呼び出し
        kiyomasa.setOnClickListener{onJankenButtonTapped(it);}
        ba.setOnClickListener{onJankenButtonTapped(it);}
        tora.setOnClickListener{onJankenButtonTapped(it);}
    }

    //ボタンがクリックされたら呼び出される処理
    fun onJankenButtonTapped(view: View?){
        //画面遷移のためのインテントのインスタンスを作る
        val intent = Intent(this,ResultActivity::class.java)
        //インテントにおまけ情報(Extra)でどのボタンを選んだかを設定する
        intent.putExtra("MY_CHOICE",view?.id)
        //OSにインテントを引き渡して画面遷移を実行してもらう
        startActivity(intent)
    }
}
