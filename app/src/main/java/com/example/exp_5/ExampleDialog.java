package com.example.exp_5;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ExampleDialog extends AppCompatDialogFragment {
    public EditText username,password;
    private ExampleDialogListener exampledialoglistener;
    @NonNull

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_layout,null);
        username=view.findViewById(R.id.editTextTextPersonName);
        password=view.findViewById(R.id.editTextTextPassword);
        builder.setView(view).setTitle("Login").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {}
        }).setPositiveButton("Submit", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String username1=username.getText().toString();
                String password1=password.getText().toString();
                exampledialoglistener.applyTexts(username1,password1);}});
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            exampledialoglistener=(ExampleDialogListener) context;
        }

        catch (ClassCastException e) {
            throw new ClassCastException(context +"must implement ExampleDialogListener");
        }
    }
    public interface ExampleDialogListener{
        void applyTexts(String username,String password);
    }
}