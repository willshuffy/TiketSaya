package tiketsaya.willdev.com.tiketsaya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SuccessBuyTicketActivity extends AppCompatActivity {

    Button btn_my_dashboard, btn_view_ticket;
    Animation app_splash, btt, top_to_bottom;
    TextView app_title, app_subtitle;
    ImageView icon_success_ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_buy_ticket);

        //load element
        btn_my_dashboard = findViewById(R.id.btn_my_dashboard);
        btn_view_ticket = findViewById(R.id.btn_view_ticket);
        app_title = findViewById(R.id.app_title);
        app_subtitle = findViewById(R.id.app_subtitle);
        icon_success_ticket = findViewById(R.id.icon_success_ticket);

        //load animation
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);
        top_to_bottom = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom);

        //run animation
        icon_success_ticket.startAnimation(app_splash);

        app_title.startAnimation(top_to_bottom);
        app_subtitle.startAnimation(top_to_bottom);

        btn_view_ticket.startAnimation(btt);
        btn_my_dashboard.startAnimation(btt);

        btn_my_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotomydashboard = new Intent(SuccessBuyTicketActivity.this,HomeActivity.class);
                startActivity(gotomydashboard);

            }
        });
    }
}
