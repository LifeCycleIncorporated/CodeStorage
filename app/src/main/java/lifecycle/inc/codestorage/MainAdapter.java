package lifecycle.inc.codestorage;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    //Initialize variable
    Activity activity;
    ArrayList<String> arrayList;

    //Create constructor
    public MainAdapter(Activity activity,ArrayList<String> arrayList){
        this.activity = activity;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Initialize view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.drawer_item,parent,false);

        //Return holder view
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Set text on text view
        holder.textView.setText(arrayList.get(position));

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get clicked item position
                int position = holder.getAdapterPosition();

                //Check condition
                switch (position){
                    case 0:
                        // When position is equal 0
                        // Redirect to home page
                        activity.startActivity(new Intent(activity,MainActivity.class)
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    case 1:
                        // When position is equal 0
                        // Redirect to home page
                        activity.startActivity(new Intent(activity,SingInSingUp_Activity.class)
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;

                    case 2:
                        //When position is equal to 1
                        //Redirect to dashboard page
                        activity.startActivity(new Intent(activity,SQLite_Activity.class)
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;

                    case 3:
                        //When position is equal to 1
                        //Redirect to dashboard page
                        activity.startActivity(new Intent(activity,Custom_ListView_Activity.class)
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;

                     case 4:
                        //When position is equal to 1
                        //Redirect to dashboard page
                        activity.startActivity(new Intent(activity, ListView_Only_Activity.class)
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;

                    case 5:
                        //When position is equal to 1
                        //Redirect to dashboard page
                        activity.startActivity(new Intent().setAction(Intent.ACTION_SEND)
                                .putExtra(Intent.EXTRA_TEXT,"body text")
                                .setType("text/plain")
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;

                    case 7:
                        //When position is equal to 1
                        //Redirect to dashboard page

                    {
                        Intent intent = new Intent().setAction(Intent.ACTION_SEND);
                        intent .putExtra(Intent.EXTRA_TEXT,"Text Details");
                            intent .setType("text/plain");
                            intent = Intent.createChooser(intent,"Share");
                            intent  .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            activity.startActivity(intent);
                    }
                        break;




                    case 6:
                        //When position is equal to 2
                        //Redirect to about page
                        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                        //Set title
                        builder.setTitle("Logout");
                        //Set massage
                        builder.setMessage("Are you sure?");
                        //Positive yes button
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Finish all activity
                                activity.finish();
                                //Exit app
                                System.exit(0);
                            }
                        });
                        //Negative cancel button
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Dismiss dialog
                                dialogInterface.dismiss();
                            }
                        });
                        //Show dialog
                        builder.show();
                        break;


                }
            }
        });
    }

    private FragmentManager getFragmentManager() {
        return null;
    }

    @Override
    public int getItemCount() {
        //Return array list size
        return arrayList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //Initialize variable
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Assign variable
            textView=itemView.findViewById(R.id.text_viewId);
        }
    }

}
