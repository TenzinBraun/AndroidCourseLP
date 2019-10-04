package fr.iutmindfuck.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListAnimation extends AppCompatActivity {
    String[] items={"smit", "Kamlesh", "UrmilPradip", "Sachin",
            "Milind", "Puja", "pankaj", "Diksha", "Mayur",
            "Shivam", "Deepali", "Lokesh", "Anshul", "Vasant"};

    /** Called when the activity is first created. */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_animation);

        ListView flightlist = (ListView)findViewById(R.id.smit_list);

        flightlist.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items));

        //setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
        //items));

        AnimationSet set = new AnimationSet(true);

        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(80);
        set.addAnimation(animation);

        animation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0.0f,Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, -1.0f,Animation.RELATIVE_TO_SELF, 0.0f
        );
        animation.setDuration(500);
        set.addAnimation(applyRotation(0,0,360));

        LayoutAnimationController controller =
                new LayoutAnimationController(set, 0.5f);
        controller.setDelay(1.0f);
        flightlist.setLayoutAnimation(controller);
        //flightlist.de
    }


    private Rotate3DAnimation applyRotation(int position, float start, float end) {

        // Find the center of the container

        final float centerX = 100.0f;//view.getWidth()/2.0f;
        final float centerY = 20.0f;//view.getHeight()/2.0f;

        // Create a new 3D rotation with the supplied parameter
        // The animation listener is used to trigger the next animation

        final Rotate3DAnimation rotation =
                new Rotate3DAnimation(start, end, centerX, centerY, 310.0f, true);

        rotation.setDuration(500);

        rotation.setFillAfter(true);

        rotation.setInterpolator(new AccelerateInterpolator());

        rotation.setAnimationListener(new DisplayNextView(position));

        return rotation;
    }

    private final class DisplayNextView implements Animation.AnimationListener {
        private final int mPosition;

        private DisplayNextView(int position) {
            mPosition = position;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {

        }

        public void onAnimationRepeat(Animation animation) {
        }
    }
}

