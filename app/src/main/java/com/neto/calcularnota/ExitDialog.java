package com.neto.calcularnota;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;


public class ExitDialog extends DialogFragment implements DialogInterface.OnClickListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle("Pergunta")
                .setMessage("Você deseja realmente sair?")
                .setPositiveButton("Sim", this)
                .setNegativeButton("Não", this);
        return dialog.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE) {
            getActivity().finish();
        } else {

        }
    }
}
