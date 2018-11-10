package io.github.landerlyoung.kotlin.mpp

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import io.github.landerlyoung.kotlin.mpp.io.github.landerlyoung.kotlin.mpp.zhihudaily.ZhihuDailyRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.text).let {
            it.text = createApplicationScreenMessage()
            Snackbar.make(it, createApplicationScreenMessage(), Snackbar.LENGTH_SHORT)
                    .show()
        }

        GlobalScope.launch {
            println(ZhihuDailyRepository.getLatestStories())
            println(ZhihuDailyRepository.getStoryContent(3892357))
        }
    }
}
