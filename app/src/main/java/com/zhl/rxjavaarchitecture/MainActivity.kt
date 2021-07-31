package com.zhl.rxjavaarchitecture

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.zhl.libdownload.DownloadBean
import com.zhl.libdownload.DownloadListener
import com.zhl.libdownload.HDownloadManager
import java.io.File
import java.lang.ref.WeakReference

/**
 *    author : zhuhl
 *    date   : 2021/7/31
 *    desc   :
 *    refer  :
 */
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val tvProgress = findViewById<TextView>(R.id.tvProgress)

        Log.d("下载框架", "进入app，" + Thread.currentThread().id)


        val url =
            "https://imtt.dd.qq.com/16891/apk/E939470073DC87C5A7BFC6109D58041C.apk?fsname=com.snda.wifilocating_4.6.82_210728.apk&csr=1bbd"

        button.setOnClickListener {
            HDownloadManager.init(packageName + ".fileProvider")
                .setDownLoadBean(
                    DownloadBean(
                        WeakReference(this),
                        "文件下载",
                        url
                    )
                )
                .startDownload(object : DownloadListener {
                    override fun onDownloadFailed(msg: String) {
                        tvProgress.text = "下载失败：$msg"
                    }

                    override fun onDownloadProgress(progress: Double) {
                        tvProgress.text = "下载进度：$progress"
                    }

                    override fun onDownloadSuccess(file: File) {
                        tvProgress.text = "下载完成：" + file.absolutePath

                    }
                })
        }
    }

}