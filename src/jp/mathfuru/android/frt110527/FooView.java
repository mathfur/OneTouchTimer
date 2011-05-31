package jp.mathfuru.android.frt110527;

import android.content.*;
import android.view.*;
import android.graphics.*;

class FooView extends View
{
	FooView(Context context) {
		super(context);
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		Paint p = new Paint();
		p.setColor(Color.WHITE);
		canvas.drawText("Foo2230",0,0,p);
	}
}
