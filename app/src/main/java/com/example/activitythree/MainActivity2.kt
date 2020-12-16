package com.example.activitythree


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    private val mHanWordDirectory = listOf("一", "二", "三", "四")
    private val mPics = intArrayOf(R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d)
    private var mIndex = 0

    private var mIv: ImageView? = null
    private var mTv: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 驼峰命名法
        val btnPre: Button = findViewById(R.id.button_previous)
        val btnNext: Button = findViewById(R.id.button_next)
        mIv = findViewById(R.id.iv_show)
        mTv = findViewById(R.id.tv_show)

        // 既然index 是位置标识符，为什么访问数组的时候不直接用index 呢？
        mIv?.setImageResource(mPics[mIndex])


        // index == 0 说明我们要展示 pics 中 0 位置的图
        // index == 1 说明我们要展示 pics 中 1 位置的图
        // 以此类推
        // 因为index 就是代表了我们要展示的图片的标号，所以点击事件只负责对 index 做加减法就可以
        // 展示图片的逻辑单独封装到一个方法中
        // 代码量减少，逻辑也变得更清晰了


        btnPre.setOnClickListener {
            if (mIndex == 0) {
                mIndex = 3
            } else {
                mIndex--
            }

            changeImage()
        }

        //设置点击事件button2
        btnNext.setOnClickListener {
            if (mIndex == 3) {
                mIndex = 0
            } else {
                mIndex++
            }
            changeImage()
        }
    }

    private fun changeImage() {
        if (mIndex < mPics.size) { // 防止数组越界
            mIv?.setImageResource(mPics[mIndex])
            mTv?.text = "第${mHanWordDirectory[mIndex]}张图片"
        }
    }
}
