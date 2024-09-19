package com.example.lab_2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTextNumber=findViewById<EditText>(R.id.editTextNumber)
        val Btn=findViewById<Button>(R.id.button)

        Btn.setOnClickListener{
            val n=editTextNumber.text.toString().toFloatOrNull()
            var x:Int= 1
            if(n!=null)
            {
                var summ:Float=0.0f
                var voskl:Int=1
                var kol:Int=0
                while(n<1.0/voskl)
                {
                    summ=0.0f
                    kol+=1
                    x+=2
                    for(i in 1..x step 2)
                    {
                        voskl=1
                        for(y in 1..i)
                        {
                            voskl*=y
                        }
                        summ=1.0f/voskl+summ
                    }
                }
                var Slag:Float=1.0f/voskl
                Toast.makeText(this,"Сумма:$summ\n Последнее слагаемое:$Slag\n Кол-во повторений:$kol",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this,"Вы не ввели число",Toast.LENGTH_LONG).show()
            }
        }
    }
}