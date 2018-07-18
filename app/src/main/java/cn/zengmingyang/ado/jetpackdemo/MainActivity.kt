package cn.zengmingyang.ado.jetpackdemo

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PersonViewModel
    private var isUpdate = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.tv)
        val button = findViewById<Button>(R.id.bt)
        // 拿到viewModel，应该是反射创建的
        viewModel = ViewModelProviders.of(this).get(PersonViewModel::class.java)

        val personObserver = Observer<Person> { person ->
            textView.text = (person?.age ?: 0).toString()
        }
        // 开始观察
        viewModel.person.observe(this, personObserver)

        button.setOnClickListener {
            isUpdate = if (!isUpdate) {
                viewModel.startUpdate()
                button.text = "暂停"
                true
            } else {
                viewModel.stopUpdate()
                button.text = "开始"
                false
            }
        }
    }
}
