package cn.zengmingyang.ado.jetpackdemo

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

class CustomeView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE) fun onCreate(){

    }
}