package c14220131.paba.tugastodolist

import android.app.ComponentCaller
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private var arTask = arrayListOf<tasklist>()
    private lateinit var _rwTask : RecyclerView
    private lateinit var adapterTask: adapterRecView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        _rwTask = findViewById<RecyclerView>(R.id.rvJadwal)


        var _tambah =  findViewById<FloatingActionButton>(R.id.fab)
        _tambah.setOnClickListener{
            val intent = Intent(this@MainActivity, addTask::class.java)
            startActivityForResult(intent, 1) // Gunakan startActivityForResult
        }

        TampilkanData()



    }
    fun TampilkanData(){
        _rwTask.layoutManager = LinearLayoutManager(this)
        adapterTask = adapterRecView(arTask)
        _rwTask.adapter = adapterTask

        adapterTask.setOnItemClickCallback(object : adapterRecView.OnItemClickCallback {

            override fun delData(pos: Int) {
                AlertDialog.Builder(this@MainActivity)
                    .setTitle("HAPUS DATA")
                    .setMessage("Apakah Benar Data " + arTask[pos].judul + " akan dihapus ?")
                    .setPositiveButton(
                        "HAPUS", DialogInterface.OnClickListener{
                                dialog, which ->
                            arTask.removeAt(pos)
                            TampilkanData() // Beri tahu adapter bahwa item telah dihapus
                        }
                    )
                    .setNegativeButton(
                        "BATAL", DialogInterface.OnClickListener{
                                dialog, which ->
                            Toast.makeText(this@MainActivity, "Data Batal Dihapus", Toast.LENGTH_LONG)
                                .show()
                        }
                    ).show()
            }

        })

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            val newTask = data.getParcelableExtra<tasklist>("newTask")
            if (newTask != null) {
                arTask.add(newTask) // Tambahkan data ke array
                adapterTask.notifyItemInserted(arTask.size - 1) // Perbarui RecyclerView
            }
        }
    }
}