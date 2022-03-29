package ensermuff.vcu.edu.cmsc475demo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatDialogFragment;

import ensermuff.vcu.edu.cmsc475demo.Activities.GameActivity;
import ensermuff.vcu.edu.cmsc475demo.Activities.InformationActivity;
import ensermuff.vcu.edu.cmsc475demo.Activities.MainActivity;

public class MenuDialog extends AppCompatDialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Test")
                .setMessage("Menu stuff")
                .setPositiveButton("Want to Leave?", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent startIntent = new Intent(getActivity(), MainActivity.class);
                        startActivity(startIntent);
                    }
                });
        return builder.create();
    }

//    public void openDialog(){
//        final Dialog dialog = new Dialog(getContext());
//        dialog.setContentView(R.layout.menudialog);
//        dialog.setTitle(R.string.dialog_title);
//        dialog.show();
//    }

//  public Dialog onCreateDialog(Bundle savedInstanceState){
//      AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.MenuDialog);//
//      builder.setTitle(R.string.dialog_title);
//      builder.setMessage("TESTING!");
//      return builder.create();
//  }
}

