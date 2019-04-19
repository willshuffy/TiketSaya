package tiketsaya.willdev.com.tiketsaya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignInActivity extends AppCompatActivity {

    Button btn_sign_in;
    TextView btn_create_new_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btn_create_new_account = findViewById(R.id.btn_create_new_account);

        btn_create_new_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoregisterone = new Intent(SignInActivity.this,RegisterOneActivity.class);
                startActivity(gotoregisterone);
            }
        });

        btn_sign_in = findViewById(R.id.btn_sign_in);

        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotohome = new Intent(SignInActivity.this,HomeActivity.class);
                startActivity(gotohome);
            }
        });
    }
}
