package tiketsaya.willdev.com.tiketsaya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TiketDetailActivity extends AppCompatActivity {

    Button btn_buy_ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiket_detail);

        btn_buy_ticket =findViewById(R.id.btn_buy_ticket);
        btn_buy_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotocheckout = new Intent(TiketDetailActivity.this,TicketCheckoutActivity.class);
                startActivity(gotocheckout);
            }
        });
    }
}
