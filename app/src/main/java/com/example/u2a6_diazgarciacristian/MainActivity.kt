package com.example.u2a6_diazgarciacristian

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.u2a6_diazgarciacristian.R.id.imgV1 as imgV11
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {
    private val nombreUsuario = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txt: ImageView = findViewById(imgV11)
        registerForContextMenu(txt)
    }

    override fun onCreateOptionsMenu (menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menudeopciones, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.MnOp1 -> {
                true
            }
            R.id.MnOp2 -> {
                true
            }
            R.id.MnOp3 -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menucontextual, menu)
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.MnOp1 -> {
                if(nombreUsuario != "") {
                    findViewById<TextView>(R.id.textView).setText("Nombre de usuario: " + nombreUsuario)
                }else{
                    findViewById<TextView>(R.id.textView).setText("No se ha establecido un nombre de usuario.")
                }

                true
            }
            R.id.MnOp2 -> {
                findViewById<TextView>(R.id.textView).setText("Fecha actual: " + LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a")))

                true
            }
            R.id.MnOp3 -> {
                findViewById<TextView>(R.id.textView).setText("Nombre del autor de la app: Cristian\nCurso: 2ºDAM; Asignatura: PMDM")
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }/*
    fun showPopup(v: View) {
        val popup = PopupMenu(this, v)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.menuemergente, popup.menu)
        popup.show()
    }*/
    fun showMenu(v: View) {
        PopupMenu(this, v).apply {
            // MainActivity implements OnMenuItemClickListener
            setOnMenuItemClickListener(/* listener = */ this@MainActivity)
            inflate(R.menu.menuemergente)
            show()
        }
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.MnOp1 -> {
                var txv1= findViewById<TextView>(R.id.textView).apply {
                    isVisible = true
                }
                true
            }
            R.id.MnOp2 -> {
                var txv1= findViewById<TextView>(R.id.textView).apply {
                    isVisible = false
                }
                true
            }
            else -> false
        }
    }
}