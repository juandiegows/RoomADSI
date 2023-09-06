package com.example.roomadsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.roomadsi.database.AppDatabase
import com.example.roomadsi.models.Gender
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoroutineScope(Dispatchers.IO).launch {
          var count =  AppDatabase.GetDataBase(this@MainActivity).genderDAO().get().size
            runOnUiThread{
                Toast.makeText(this@MainActivity, "$count", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
