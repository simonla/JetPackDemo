package cn.zengmingyang.ado.jetpackdemo

import android.arch.lifecycle.*
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.FrameLayout

class CustomFrameLayoutView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), LifecycleObserver, LifecycleOwner {

    private val lifecycleRegistry = LifecycleRegistry(this)

    override fun getLifecycle(): Lifecycle = lifecycleRegistry

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        val lifecycleObserverTest = LifecycleObserverTest()
        lifecycle.addObserver(lifecycleObserverTest)
        Log.d(this.javaClass.simpleName, "onCreate")
        lifecycleRegistry.markState(Lifecycle.State.CREATED)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.d(this.javaClass.simpleName, "onResume")
        lifecycleRegistry.markState(Lifecycle.State.RESUMED)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.d(this.javaClass.simpleName, "onDestroy")
        lifecycleRegistry.markState(Lifecycle.State.DESTROYED)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.d(this.javaClass.simpleName, "onPause")
    }
}