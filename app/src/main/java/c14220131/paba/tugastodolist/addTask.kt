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

        val isEditMode = intent.getBooleanExtra("editMode", false)
        val task = intent.getParcelableExtra<tasklist>("task")
        val taskIndex = intent.getIntExtra("taskIndex", -1)


        if (isEditMode) {
            title = "Edit Task"
            task?.let {
                _editNama.setText(it.judul)
                _editTanggal.setText(it.tanggal)
                _editKategori.setText(it.kategori)
                _editDeskripsi.setText(it.deskripsi)
            }
        } else {
            title = "Add Task"
        }

        _btnSimpan.setOnClickListener {
            val updatedTask = tasklist(
                judul = _editNama.text.toString(),
                tanggal = _editTanggal.text.toString(),
                kategori = _editKategori.text.toString(),
                deskripsi = _editDeskripsi.text.toString()
            )

            val resultIntent = Intent()
            resultIntent.putExtra("updatedTask", updatedTask)
            if (isEditMode) resultIntent.putExtra("taskIndex", taskIndex)

            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}