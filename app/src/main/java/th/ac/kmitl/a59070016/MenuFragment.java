package th.ac.kmitl.a59070016;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import th.ac.kmitl.a59070016.Post_Comment.PostFragment;


import java.util.ArrayList;

public class MenuFragment extends Fragment {
    private ArrayList<String> nameMenus = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container ,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ListView menu_listview = getActivity().findViewById(R.id.menu_listview);
        MenuAdapter menuAdapter = new MenuAdapter(getActivity(),R.layout.fragement_menu_item,nameMenus);
        menu_listview.setAdapter(menuAdapter);
        menuAdapter.clear();

        nameMenus.add("PROFILE SETUP");
        nameMenus.add("MY FRIENDS");
        nameMenus.add("SIGN OUT");

        menuAdapter.notifyDataSetChanged();


        //shared Preferences
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("my_pref", Context.MODE_PRIVATE);
        String username = "Nawin Phunsawat";
        sharedPreferences.edit().putString("username" , username).commit();

        menu_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String _menu = nameMenus.get(position);
                if(_menu.equals("PROFILE SETUP")){

                }else if(_menu.equals("MY FRIENDS")){
                  
                }else if(_menu.equals("SIGN OUT")){
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_view, new LoginFragment()).addToBackStack(null).commit();
                }
            }
        });


    }
}
