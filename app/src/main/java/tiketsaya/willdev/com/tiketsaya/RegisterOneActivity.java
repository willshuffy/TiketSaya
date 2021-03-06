package tiketsaya.willdev.com.tiketsaya;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterOneActivity extends AppCompatActivity {

    LinearLayout btn_back;
    Button btn_continue;
    EditText username, password, email_address;
    DatabaseReference reference;

    String USERNAME_KEY = "usernamekey";
    String usernmae_key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_one);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email_address = findViewById(R.id.email_address);

        btn_continue =findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //menyimpan data pada local storage (handphone)
                SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(usernmae_key, username.getText().toString());
                editor.apply();


                // Simpan ke database
                reference = FirebaseDatabase.getInstance().getReference()
                        .child("Users").child(username.getText().toString());
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().child("username").setValue(username.getText().toString());
                        dataSnapshot.getRef().child("password").setValue(password.getText().toString());
                        dataSnapshot.getRef().child("email_address").setValue(email_address.getText().toString());
                        dataSnapshot.getRef().child("user_balance").setValue(1000);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });




//                // test username masuk dengan toast
//                Toast.makeText(getApplicationContext(), "Username : " +
//                        username.getText().toString(), Toast.LENGTH_SHORT).show();



                //Pindah Activity
                Intent gotonextregister = new Intent(RegisterOneActivity.this,RegisterTwoActivity.class);
                startActivity(gotonextregister);
            }
        });

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backtosignin = new Intent(RegisterOneActivity.this,SignInActivity.class);
                startActivity(backtosignin);
            }
        });

    }
}
