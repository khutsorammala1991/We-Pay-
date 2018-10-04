package com.artitech.tsalano.tukisha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class HowToUseApp extends AppCompatActivity {

    int imageNO[]={R.drawable.app1,R.drawable.app2,R.drawable.app3,R.drawable.app4,R.drawable.app5,R.drawable.app6,R.drawable.app7,R.drawable.app8,R.drawable.app9,R.drawable.app10,R.drawable.app11,R.drawable.app12,R.drawable.app13,R.drawable.app14};

    int countImage = imageNO.length;
    int currentImage = -0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_use_app);

        Button nextimage = (Button ) findViewById(R.id.butNext);
        final ImageSwitcher imageSwitcher =(ImageSwitcher) findViewById (R.id.imageaChanger);

       imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
           @Override
           public View makeView() {

               ImageView imageView= new ImageView(getApplicationContext());
               imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
               imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT));
               return imageView;

           }
       });

       nextimage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               currentImage++;
               if (currentImage==countImage)
                   countImage=+1;
               imageSwitcher. setImageResource(imageNO[currentImage]);


           }
       });





        TextView login = (TextView ) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivity = new Intent(HowToUseApp.this,LoginActivity.class);
                startActivity(loginActivity);
            }
        });
        TextView  back = (TextView ) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivity = new Intent(HowToUseApp.this,HowToLogInActivity.class);
                startActivity(loginActivity);
            }
        });
    }
}
