package com.example.u2a6_diazgarciacristian

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class DialogoCambiarUsuario: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater;

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(inflater.inflate(R.layout.dialogocambiarusuario, null))
                // Add action buttons
                .setPositiveButton(R.string.cambiar,
                    DialogInterface.OnClickListener { dialog, id ->
                        // sign in the user ...
                        nombreUsuario = requireDialog().findViewById<TextView>(R.id.username).text.toString()
                        Toast.makeText(activity, "Nombre de usuario cambiado a $nombreUsuario", Toast.LENGTH_LONG).show()
                    })
                .setNegativeButton(R.string.cancelar,
                    DialogInterface.OnClickListener { dialog, id ->
                        Toast.makeText(activity, "Cambio de usuario cancelado", Toast.LENGTH_LONG).show()
                        getDialog()?.cancel()

                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}