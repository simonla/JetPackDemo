package cn.zengmingyang.ado.jetpackdemo

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log

import java.util.Random

class PersonViewModel : ViewModel() {

    var person: MutableLiveData<Person> = MutableLiveData()

    private var thread: Thread? = null

    fun startUpdate() {
        thread = Thread(Runnable {
            val random = Random()
            while (true) {
                if (Thread.currentThread().isInterrupted) {
                    break
                }
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    Thread.currentThread().interrupt()
                }
                person.postValue(Person(random.nextInt(99)))
            }
        })
        thread?.start()
    }

    fun stopUpdate() {
        thread?.interrupt()
    }
}
