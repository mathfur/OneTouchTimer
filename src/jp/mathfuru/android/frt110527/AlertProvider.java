class TimerView{ void flash(){} }

// AlertProvider(timerView).do_alert(300,10)で10/300時のアラート(バイブ、画面の点滅)行う
class AlertProvider
{
	TimerView timerView;
	AlertProvider(TimerView timerView_)
	{
		timerView = timerView_;
	}

	void do_vibratorAlert(int maxSec, int currentSec)
	{
		switch(currentSec)
		{
			case 0:
				//vibrator.vibrate(new long[]{100,100,100,100}); /* TODO: あやしい*/
			case 5:
				//vibrator.vibrate(new long[]{100,100,100,100}); /* TODO: あやしい*/
		}
	}

	void do_flashAlert(int maxSec, int currentSec)
	{
		switch(currentSec)
		{
			case 0:
				timerView.flash(); /* TODO */
			case 5:
				timerView.flash(); /* TODO */
		}
	}
		
	void do_alerts(int maxSec, int currentSec)
	{
		do_vibratorAlert(maxSec,currentSec);
		do_flashAlert(maxSec,currentSec);
	}
}
