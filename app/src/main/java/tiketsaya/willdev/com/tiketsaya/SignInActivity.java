package tiketsaya.willdev.com.tiketsaya;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignInActivity extends AppCompatActivity {

    Button btn_sign_in;
    TextView btn_create_new_account;
    EditText xusername, xpassword;

    DatabaseReference reference;

    String USERNAME_KEY = "usernamekey";
    String usernmae_key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btn_create_new_account = findViewById(R.id.btn_create_new_account);
        btn_sign_in = findViewById(R.id.btn_sign_in);
        xusername = findViewById(R.id.xusername);
        xpassword = findViewById(R.id.xpassword);

        btn_create_new_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoregisterone = new Intent(SignInActivity.this,RegisterOneActivity.class);
                startActivity(gotoregisterone);
            }
        });



        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String username = xusername.getText().toString();
                final String password = xpassword.getText().toString();

                reference = FirebaseDatabase.getInstance().getReference()
                        .child("Users").child(username);

                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()){


                            //ambil data password dari firebase
                            String passwordFromFirebase = dataSnapshot.child("password").getValue().toString();

                            //validasi password dengan password firebase
                            if (password.equals(passwordFromFirebase)){

                                //simpan username (key) pada local
                                SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString(usernmae_key, xusername.getText().toString());
                                editor.apply();

                                //Toast welcome saat berhasil login
                                Toast.makeText(getApplicationContext(), "Welcome " + username + "  ^_^", Toast.LENGTH_SHORT).show();

                                //berpindah activity saat berhasil login
                                Intent gotohome = new Intent(SignInActivity.this,HomeActivity.class);
                                startActivity(gotohome);
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "Password salah !", Toast.LENGTH_SHORT).show();
                            }




                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Username tidak ada !", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "Database Error !", Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });
    }
}
