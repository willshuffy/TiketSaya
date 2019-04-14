package tiketsaya.willdev.com.tiketsaya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GetStartedActivity extends AppCompatActivity {

    Button btn_sign_in, btn_new_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        btn_sign_in = findViewById(R.id.btn_sign_in);
        btn_new_account = findViewById(R.id.btn_new_account);

        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotosign = new Intent(GetStartedActivity.this,SignInActivity.class);
                startActivity(gotosign);
            }
        });

        btn_new_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoregisterone = new Intent(GetStartedActivity.this,RegisterOneActivity.class);
                startActivity(gotoregisterone);
            }
        });
    }
}
