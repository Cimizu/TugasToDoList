package c14220131.paba.tugastodolist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class addTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_task)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var _editDeskrisp = findViewById<EditText>(R.id.editDeskripsi)
        var _editTanggal = findViewById<EditText>(R.id.editTanggal)
        var _editKategori = findViewById<EditText>(R.id.editKategori)
        var _editNama = findViewById<EditText>(R.id.editNama)
        var _btnSimpan = findViewById<Button>(R.id.btnSimpan)

        val isEdut = intent.hasExtra("taskIndex")

        _btnSimpan.setOnClickListener{

        }

    }
}