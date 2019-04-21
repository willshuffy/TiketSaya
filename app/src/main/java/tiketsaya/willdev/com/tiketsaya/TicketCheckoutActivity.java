package tiketsaya.willdev.com.tiketsaya;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TicketCheckoutActivity extends AppCompatActivity {

    Button btn_pay_now, btnmines, btnplus;
    TextView textjumlahticket, texttotalharga, textmybalance;
    Integer valuejumlahticket = 1;
    Integer mybalance = 200;
    Integer valuetotalharga = 0;
    Integer valuehargatiket = 75;
    ImageView allert_payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_checkout);

        //load element
        btn_pay_now = findViewById(R.id.btn_pay_now);
        btnplus = findViewById(R.id.btnplus);
        btnmines = findViewById(R.id.btnmines);

        textjumlahticket = findViewById(R.id.textjumlahticket);
        texttotalharga = findViewById(R.id.texttotalharga);
        textmybalance = findViewById(R.id.textmybalance);

        allert_payment = findViewById(R.id.allert_payment);

        //setting value baru untuk beberapa komponent
        textjumlahticket.setText(valuejumlahticket.toString());
        textmybalance.setText("US$ "+ mybalance+"");
        valuetotalharga = valuehargatiket * valuejumlahticket;
        texttotalharga.setText("US$ "+ valuetotalharga+"");

        //Hide btn mines secara default
        btnmines.animate().alpha(0).setDuration(300).start();
        btnmines.setEnabled(false);

        allert_payment.setVisibility(View.GONE);

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valuejumlahticket+=1;
                textjumlahticket.setText(valuejumlahticket.toString());
                if (valuejumlahticket > 1){
                    btnmines.animate().alpha(1).setDuration(300).start();
                    btnmines.setEnabled(true);
                }
                valuetotalharga = valuehargatiket * valuejumlahticket;
                texttotalharga.setText("US$ "+ valuetotalharga+"");
                if (valuetotalharga > mybalance){
                    btn_pay_now.animate().translationY(250)
                            .alpha(0).setDuration(350).start();
                    btn_pay_now.setEnabled(false);
                    textmybalance.setTextColor(Color.parseColor("#D1206B"));
                    allert_payment.setVisibility(View.VISIBLE);
                }
            }
        });

        btnmines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valuejumlahticket-=1;
                textjumlahticket.setText(valuejumlahticket.toString());
                if (valuejumlahticket < 2){
                    btnmines.animate().alpha(0).setDuration(300).start();
                    btnmines.setEnabled(false);
                }
                valuetotalharga = valuehargatiket * valuejumlahticket;
                texttotalharga.setText("US$ "+ valuetotalharga+"");
                if (valuetotalharga < mybalance){
                    btn_pay_now.animate().translationY(0)
                            .alpha(1).setDuration(350).start();
                    btn_pay_now.setEnabled(true);
                    textmybalance.setTextColor(Color.parseColor("#203DD1"));
                    allert_payment.setVisibility(View.GONE);
                }
            }
        });

        btn_pay_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotosuccessticket = new Intent(TicketCheckoutActivity.this,SuccessBuyTicketActivity.class);
                startActivity(gotosuccessticket);

            }
        });
    }
}
