package com.example.activitythree



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //图片id设置为数组
        val pic= intArrayOf(R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d)


        //初始化控件,两个button，一个imageview
        val btn_pre: Button = findViewById(R.id.button_previous)//局部变量不应该包括下划线
        val btn_next: Button = findViewById(R.id.button_next)
        val iv:ImageView=findViewById(R.id.iv_show)
        val tv:TextView=findViewById(R.id.tv_show)
        //放入第一张图片
        iv.setImageResource(pic[0])



        var index=0//标志第几张照片

        //设置点击事件,button1
        btn_pre.setOnClickListener {
            //注释toast// Toast.makeText(this, "上一张图片", Toast.LENGTH_SHORT).show()
            when(index){
                0-> {
                    iv.setImageResource(pic[3])
                    tv.text = "第四张图片"
                    }
                1-> {
                    iv.setImageResource(pic[0])
                    tv.text = "第一张图片"
                    }
                2-> {
                    iv.setImageResource(pic[1])
                    tv.text = "第二张图片"
                }
                3-> {
                    iv.setImageResource(pic[2])
                    tv.text = "第三张图片"
                }
            }
            if(index==0){
                index=3
            }
            else index++

        }
        //设置点击事件button2
        btn_next.setOnClickListener {
           //注释toast // Toast.makeText(this, "下一张图片", Toast.LENGTH_SHORT).show()

            when(index){
                0-> {iv.setImageResource(pic[1])
                    tv.text = "第二张图片"
                }
                1-> {iv.setImageResource(pic[2])
                    tv.text = "第三张图片"
                }
                2-> {
                    iv.setImageResource(pic[3])
                    tv.text = "第四张图片"
                }
                3-> {
                    iv.setImageResource(pic[0])
                    tv.text = "第一张图片"
                }
            }
            if(index==3){
                index=0
            }
            else index++
        }




    }
}
