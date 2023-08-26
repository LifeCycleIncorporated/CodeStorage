package lifecycle.inc.codestorage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    private String[] country_name;
    int[] flags;
    Context context;

    private LayoutInflater inflater;

    CustomAdapter(Context context, String[] country_name, int[] flags){

        this.context=context;
        this.country_name = country_name;
        this.flags=flags;
    }

    @Override  //////// country name is closed
    public int getCount() { return flags.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View views, ViewGroup viewGroup) {

        if (views==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            views = inflater.inflate(R.layout.simple_layout_for_list_view,viewGroup,false);
        }

        ImageView imageView = views.findViewById(R.id.simpleImageViewId);
        imageView.setImageResource(flags[i]);

        TextView textView = views.findViewById(R.id.simpleTextViewId);
        textView.setText(country_name[i]);

        return views;


    }
}
