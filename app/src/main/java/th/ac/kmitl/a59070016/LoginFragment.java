package th.ac.kmitl.a59070016;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import th.ac.kmitl.a59070016.Post_Comment.PostFragment;


public class LoginFragment extends Fragment {

    EditText user_id,user_password;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initLogin();
    }

    public void initLogin(){
        Button login_btn = getActivity().findViewById(R.id.login_button);
        user_id = getActivity().findViewById(R.id.user_id);
        user_password = getActivity().findViewById(R.id.password_id);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = user_id.getText().toString();
                String password = user_password.getText().toString();
                if(username.equals("") || password.equals("")){
                    Log.i("LOGIN","USER OR PASSWORD IS EMPTY");
                    Toast.makeText(getActivity(), "กรุณาระบุ Username หรือ Password",Toast.LENGTH_SHORT).show();
                }
                else{
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_view, new MenuFragment()).addToBackStack(null).commit();
                }
            }
        });
        TextView signUpButton = (TextView) getView().findViewById(R.id.sign_up_button);
        signUpButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_view, new RegisterFragment()).addToBackStack(null).commit();
            }
        });

    }

}
