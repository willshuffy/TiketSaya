package tiketsaya.willdev.com.tiketsaya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TicketCheckoutActivity extends AppCompatActivity {

    Button btn_pay_now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_checkout);

        btn_pay_now = findViewById(R.id.btn_pay_now);
        btn_pay_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotosuccessticket = new Intent(TicketCheckoutActivity.this,SuccessBuyTicketActivity.class);
                startActivity(gotosuccessticket);

            }
        });
    }
}
