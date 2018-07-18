package cn.zengmingyang.ado.jetpackdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val customFrameLayoutView = findViewById<CustomFrameLayoutView>(R.id.fl)
        lifecycle.addObserver(customFrameLayoutView)
    }
}
