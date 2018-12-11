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
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by LAB203_13 on 20/8/2561.
 */
public class RegisterFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    boolean checkPassword(String passwrod, String rePassword){
        if(passwrod.length() >= 6){
            if(passwrod.equals(rePassword)) {
                return true;
            }else{
                Toast.makeText(getActivity(),"Password ไม่ตรงกัน", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getActivity(),"Password ต้องมากกว่า 6 ตัวอักษร", Toast.LENGTH_SHORT).show();
        }
        return false;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        Button signUpButton = (Button) getView().findViewById(R.id.sign_up_button_sign_up_page);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView email = (TextView) getView().findViewById(R.id.email_sign_up_page);
                TextView age1 = (TextView) getView().findViewById(R.id.age);
                TextView rePassword = (TextView) getView().findViewById(R.id.re_password_id_sign_up_page);

                String emailStr = email.getText().toString();
                String age = age1.getText().toString();
                String rePasswordStr = rePassword.getText().toString();



                if(emailStr.isEmpty() || age.isEmpty() || rePasswordStr.isEmpty()){
                    Toast.makeText(getActivity(),"กรุณาระบุข้อมูลให้ครบถ้วน",Toast.LENGTH_SHORT).show();
                    Log.i("REGISTER", "Field Name is Empyty");
                }else if(emailStr.length()<6 || emailStr.length()>12){
                    Toast.makeText(getActivity(), "user นี้มีอยู่ในระบบแล้ว", Toast.LENGTH_SHORT).show();
                    Log.i("REGISTER","USER ALREADY EXITS");
                }else{
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_view, new LoginFragment()).addToBackStack(null).commit();
                }
            }
        });


    }
}