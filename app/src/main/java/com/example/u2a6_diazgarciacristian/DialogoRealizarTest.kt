package com.example.u2a6_diazgarciacristian

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogoRealizarTest: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle(R.string.pregunta)
                .setItems(R.array.respuestas){ dialog, which ->
                    resultadosPrevios[i] = "${resources.getStringArray(R.array.respuestas)[which]}"
                    i +=1
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}