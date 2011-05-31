package jp.mathfuru.android.frt110527;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.util.*;
import java.util.*;
import java.lang.*;

public class Frt110527 extends Activity // implements View.OnClickListener
{
	//AlertProvider alert;
	Timer timer;
	int rest = 10;
	int maxTime = 300;
	boolean drawFlag = false;
	LinearLayout base;
	TextView bar;
	TextView restTime;
	TextView indicator;

	@Override
		public void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.main);

			base = (LinearLayout) findViewById(R.id.base);
			bar = (TextView) findViewById(R.id.bar);
			restTime = (TextView) findViewById(R.id.restTime);
			indicator = (TextView) findViewById(R.id.indicator);

			base.setOnTouchListener(new View.OnTouchListener(){
				public boolean onTouch(View v,MotionEvent e){
					// Log.v("getX()",Float.toString(e.getX()));
					// Log.v("getY()",Float.toString(e.getY()));
					// bar.setHeight( (int) e.getY() );
					maxTime = (int) ((float)10*(Math.pow(2,0.02*e.getX())));
					rest = maxTime;
					Log.v("rest",Integer.toString(rest));
					Log.v("maxTime",Integer.toString(maxTime));
					reflesh();
					return true;
				}
			});

			timer = new Timer();
			final Handler handler = new Handler();
			// alert = new AlertProvider((Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE));
			// 1秒ごとにrestを減らしてinvalidateで描画する
			timer.schedule(new TimerTask(){
				@Override
				public void run() {
					handler.post( new Runnable(){
						public void run(){
							// マイナスも有り
							rest -= 1;
							reflesh();
						}
					});
				}
			}, 0, 1000);
		}
	
	private void reflesh()
	{
		bar.setBackgroundColor(Color.rgb((int)(getPercent()*256),0,(int)((1-getPercent())*256)));
		if( drawFlag )
		{
			//alert.do_alerts(maxTime,rest);
			drawFlag = false;
		}
		bar.setHeight( (int)(getPercent()*base.getHeight()) );
		restTime.setText(toTimeString(rest));
	}

	private String toTimeString(int t)
	{
		int sec = t % 60;
		int min = (t - sec)/60;
		String result = String.format("%02d:%02d",min,sec);
		Log.v("toTimeString()",result);
		return result;
	}

	// バーの高さ
	private float getPercent()
	{
		float result = ((float)rest)/maxTime;
		Log.v("getPercent()",Float.toString(result));
		return result;
	}
}
