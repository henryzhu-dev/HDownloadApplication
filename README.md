## 说明

此库下载apk、文件等相关下载功能


## Download
------


```gradle
repositories {
  mavenCentral()
}

dependencies {
  implementation 'io.github.henryzhu-dev:lib_download:1.0.0'
}
```

## ProGuard
-------
Nothing needs to be done

## Use
-------

```kotlin
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
```

## License
-------
The Apache License, Version 2.0. See the [LICENSE][http://www.apache.org/licenses/LICENSE-2.0.txt] for details.

end
