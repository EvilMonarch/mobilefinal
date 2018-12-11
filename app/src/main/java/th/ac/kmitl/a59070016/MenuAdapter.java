package th.ac.kmitl.a59070016;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<String> menuListArrayList;

    public MenuAdapter(@NonNull Context context, int resource, @NonNull ArrayList objects) {
        super(context, resource, objects);
        this.context = context;
        this.menuListArrayList = (ArrayList<String>) objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, ViewGroup parent) {
        View menu_item;
        menu_item = LayoutInflater.from(context).inflate(R.layout.fragement_menu_item, parent,false);
        TextView menu_name = menu_item.findViewById(R.id.menu_name);
        menu_name.setText(menuListArrayList.get(position));
        return menu_item;
    }
}
