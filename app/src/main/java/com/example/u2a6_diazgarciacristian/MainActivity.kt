package com.example.u2a6_diazgarciacristian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import com.example.u2a6_diazgarciacristian.R.id.imgV1 as imgV11
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
var nombreUsuario = ""
var i = 0
var resultadosPrevios = Array(100) { "" }
class MainActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.topAppBar))
        val txt: ImageView = findViewById(imgV11)
        registerForContextMenu(txt)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menudeopciones, menu)
        return true
    }
    fun realizarTest(view: View) {
        val dialog = DialogoRealizarTest()
        dialog.show(supportFragmentManager, "DialogoRealizarTest")
    }
    fun cambiarUsuario(view: View) {
        val dialog = DialogoCambiarUsuario()
        dialog.show(supportFragmentManager, "DialogoCambiarUsuario")
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.MnOp1 -> {
                findViewById<TextView>(R.id.textView).apply {
                    var j = 0
                    text = "Resultados: "
                    while(j<i){
                        text = "$text \n ${resultadosPrevios[j]}"
                        j+=1
                    }
                    if(j == 0){
                        text = "No has realizado ningún test"
                    }
                }
                true
            }
            R.id.MnOp2 -> {
                findViewById<TextView>(R.id.textView).apply {
                    text = "Te aconsejo que te vayas ¡¡¡A ESTUDIAR, QUE VAS A SUSPENDERLO TODOOOOO!!!"
                }
                true
            }
            R.id.MnOp3 -> {
                findViewById<TextView>(R.id.textView).apply {
                    text = "Fecha de lanzamiento: 23/11/2023; Versión: 1.0.0; IDE: Android Studio; Guia de usuario: No hay :)"
                }
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
                    findViewById<TextView>(R.id.textView).setText(getString(R.string.mncttopc1_2))
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
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
        return when (item.itemId) {

            else -> false
        }
    }
}