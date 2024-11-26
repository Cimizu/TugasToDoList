package c14220131.paba.tugastodolist

import android.content.Intent
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
        var _editDeskripsi = findViewById<EditText>(R.id.editDeskripsi)
        var _editTanggal = findViewById<EditText>(R.id.editTanggal)
        var _editKategori = findViewById<EditText>(R.id.editKategori)
        var _editNama = findViewById<EditText>(R.id.editNama)
        var _btnSimpan = findViewById<Button>(R.id.btnSimpan)


        _btnSimpan.setOnClickListener {
            val deskripsi = _editDeskripsi.text.toString()
            val tanggal = _editTanggal.text.toString()
            val kategori = _editKategori.text.toString()
            val namaTask = _editNama.text.toString()

            val newTask = tasklist(
                judul = namaTask,
                tanggal = tanggal,
                kategori = kategori,
                deskripsi = deskripsi
            )

            // Kirim data kembali ke MainActivity
            val resultIntent = Intent()
            resultIntent.putExtra("newTask", newTask)
            setResult(RESULT_OK, resultIntent)
            finish()


//            val IntentwithData = Intent(this@addTask, MainActivity::class.java).apply {
//                putExtra("taskName", namaTask)
//                putExtra("taskDate", tanggal)
//                putExtra("taskCategory", kategori)
//                putExtra("taskDescription", deskripsi)
//            }
//            startActivity(IntentwithData)



        }

    }
}