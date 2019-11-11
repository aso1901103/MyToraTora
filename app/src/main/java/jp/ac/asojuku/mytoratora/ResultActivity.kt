package jp.ac.asojuku.mytoratora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    //kiyomasa,oba,toraを表す定数を定義する
    val kiyomasa = 0; val ba = 1;val tora = 2;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
    }

    override fun onResume() {
        super.onResume()
        //じゃんけんで選んだView部品のidをインテントから取り出し
        val id = intent.getIntExtra("MY_CHOICE",0)
        //前の画面で選んだ手を保持する定数を定義する
        val myHand:Int;
        //idの値によって処理を分岐、自分のじゃんけん画像を切り替える
        myHand = when(id){
            R.id.kiyomasa -> {MyChoice.setImageResource(R.drawable.kiyomasa);kiyomasa}
            R.id.ba -> {MyChoice.setImageResource(R.drawable.oba);ba}
            R.id.tora -> {MyChoice.setImageResource(R.drawable.tora);tora}
            else -> kiyomasa
        }
        //コンピューターの手をランダムに決める
        val comHand = (Math.random()*3).toInt();//メソッドで組み立てた手を採用する
        //コンピューターの手に合わせてコンピューターの画像を切り替える
        when(comHand){
            kiyomasa -> ComChoice.setImageResource(R.drawable.kiyomasa)
            ba -> ComChoice.setImageResource(R.drawable.oba)
            tora -> ComChoice.setImageResource(R.drawable.tora)
        }
        val gameResult = (comHand - myHand + 3) % 3
        //計算結果に合わせて勝敗メッセージを切り替える
        when(gameResult){
            0-> ResultView.setText(R.string.result_draw)
            1-> ResultView.setText(R.string.result_win)
            2-> ResultView.setText(R.string.result_lose)
        }
        //戻るボタンにタップされた時の処理を設定する
        backButton.setOnClickListener{this.finish()}//戻るボタンが押されたら結果画面を破棄する

        //勝敗とじゃんけんで出した手を保存する
        //this.saveData(myHand,comHand,gameResult);//引数：ユーザーの手、コンピューターの手、勝敗を渡す
    }
}
