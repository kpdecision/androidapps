package truck.profitcalc;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends Activity {
Button calculate;
EditText setkm,setkmpl,setfrieght,settrip,settoll,setmisc,setsalary,setfuelrate;
public Float km,kmpl,frieghtrate,trip,toll,misc,salary,fuelrate,frieghtamt,totincom,fuelconsumed,fuelcostpermth,totalexpense,totalsavings;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 AdView mAdView = (AdView)findViewById(R.id.adView);
		    AdRequest adRequest = new AdRequest.Builder().build();
		    mAdView.loadAd(adRequest);
		calculate=(Button)findViewById(R.id.calculate);
		setkm=(EditText)findViewById(R.id.settotalkm);
		setkmpl=(EditText)findViewById(R.id.setkmpl);
		setfrieght=(EditText)findViewById(R.id.setFreightrate);
		settrip=(EditText)findViewById(R.id.seTotaltripperMonth);
		settoll=(EditText)findViewById(R.id.settollcharge);
		setmisc=(EditText)findViewById(R.id.setMiscellaneous);
		setsalary=(EditText)findViewById(R.id.setDriverSalary);
		setfuelrate=(EditText)findViewById(R.id.setFuelrate);
		CurrencyFormat watcher = new CurrencyFormat();
		setkm.addTextChangedListener(watcher);
		setkmpl.addTextChangedListener(watcher);
		settrip.addTextChangedListener(watcher);
		setfrieght.addTextChangedListener(watcher);
		settoll.addTextChangedListener(watcher);
		setmisc.addTextChangedListener(watcher);
		setsalary.addTextChangedListener(watcher);
		setfuelrate.addTextChangedListener(watcher);
		try {
			km=Float.parseFloat(setkm.getText().toString());
			kmpl=Float.parseFloat(setkmpl.getText().toString());
			frieghtrate=Float.parseFloat(setfrieght.getText().toString());
			trip=Float.parseFloat(settrip.getText().toString());
			toll=Float.parseFloat(settoll.getText().toString());
			misc=Float.parseFloat(setmisc.getText().toString());
			salary=Float.parseFloat(setsalary.getText().toString());
			fuelrate=Float.parseFloat(setfuelrate.getText().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setfuelrate.setOnEditorActionListener(new EditText.OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				if ((actionId == EditorInfo.IME_ACTION_DONE)) {
					// Do your stuff here
					checkempty();
				}
				return true;
			}
		});
		calculate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				checkempty();
		
			}
		});
	}

	protected void checkempty() {
		// TODO Auto-generated method stub
		if (setkm.getText().toString().equals("")) {
			
			Toast toast = Toast.makeText(getApplicationContext(), "Enter Km ",Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
		} else if (setkmpl.getText().toString().equals("")) {
			
			Toast toast = Toast.makeText(getApplicationContext(), "Enter Kmpl",Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
		} 
else if (setfrieght.getText().toString().equals("")) {
			
			Toast toast = Toast.makeText(getApplicationContext(), "Enter Frieght Rate",Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
		}else if (settrip.getText().toString().equals("")) {
			
			Toast toast = Toast.makeText(getApplicationContext(), "Enter Trip",Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
		}else if (settoll.getText().toString().equals("")) {
			
			Toast toast = Toast.makeText(getApplicationContext(), "Enter Toll Charges",Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
		}
else if (setmisc.getText().toString().equals("")) {
			
			Toast toast = Toast.makeText(getApplicationContext(), "Enter Misc Charges",Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
		}else if (setsalary.getText().toString().equals("")) {
			
			Toast toast = Toast.makeText(getApplicationContext(), "Enter Driver Salary",Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
		}else if (setfuelrate.getText().toString().equals("")) {
			
			Toast toast = Toast.makeText(getApplicationContext(), "Enter Fuel Rate/Litre",Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
		}else {
			showResult();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	void calculate(){
		
		frieghtamt=frieghtrate*km;
		totincom=trip*frieghtamt;
		fuelconsumed=km/kmpl;
		fuelcostpermth=fuelrate*fuelconsumed*trip;
		totalexpense=fuelcostpermth+salary+toll+misc;
		totalsavings=totincom-totalexpense;
		
		
	}
	void showResult()
	{
		
		
		try {
			km=Float.parseFloat(setkm.getText().toString());
			kmpl=Float.parseFloat(setkmpl.getText().toString());
			frieghtrate=Float.parseFloat(setfrieght.getText().toString());
			trip=Float.parseFloat(settrip.getText().toString());
			toll=Float.parseFloat(settoll.getText().toString());
			misc=Float.parseFloat(setmisc.getText().toString());
			salary=Float.parseFloat(setsalary.getText().toString());
			fuelrate=Float.parseFloat(setfuelrate.getText().toString());
			calculate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final Dialog dialogbox = new Dialog(MainActivity.this);
		dialogbox.requestWindowFeature(Window.FEATURE_LEFT_ICON);
		dialogbox.setContentView(R.layout.test);
		dialogbox.setTitle("info");

		dialogbox.setCancelable(false);
		TextView freightrate = (TextView) dialogbox
				.findViewById(R.id.setfrieght);
		TextView income = (TextView) dialogbox
				.findViewById(R.id.totalincome);
		TextView fuel = (TextView) dialogbox
				.findViewById(R.id.totalfuel);
		TextView fuelcost = (TextView) dialogbox
				.findViewById(R.id.setfuelcost);
		TextView expense = (TextView) dialogbox
				.findViewById(R.id.setexpense);
		TextView savings = (TextView) dialogbox
				.findViewById(R.id.setsavings);
		freightrate.setText(String.valueOf(frieghtamt));
		income.setText(String.valueOf(totincom));
		fuel.setText(String.valueOf(fuelconsumed));
		fuelcost.setText(String.valueOf(fuelcostpermth));
		expense.setText(String.valueOf(totalexpense));
		savings.setText(String.valueOf(totalsavings));


		Button ok = (Button) dialogbox.findViewById(R.id.Ok);
		ok.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialogbox.dismiss();
				//Toast.makeText(getBaseContext(), " "+km+","+kmpl+","+frieghtrate+","+trip+","+toll+","+misc+","+salary+","+fuelrate, Toast.LENGTH_LONG).show();
			}
		});
		
		dialogbox.show();
		dialogbox.setFeatureDrawableResource(Window.FEATURE_LEFT_ICON,
				R.drawable.info);
		
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == event.KEYCODE_BACK) {
		
			 final Dialog dialogbox = new Dialog(MainActivity.this);
			 dialogbox.requestWindowFeature(Window.FEATURE_LEFT_ICON);
 			 dialogbox.setContentView(R.layout.exit);
            dialogbox.setTitle("info");
          
             dialogbox.setCancelable(false);
             TextView message=(TextView)dialogbox.findViewById(R.id.alertmsg);
             message.setText("Are you sure you want to exit?");
             
             Button ok = (Button) dialogbox.findViewById(R.id.cadbtnOk);
             ok.setOnClickListener(new OnClickListener() {
             @Override
             public void onClick(View v) {
            	 
            	 System.exit(0);
					
            	 

					finish();
             }
             });
             Button cancel = (Button) dialogbox.findViewById(R.id.cadbtnCancel);
             cancel.setOnClickListener(new OnClickListener() {
             @Override
             public void onClick(View v) {
                 dialogbox.dismiss();
             }
             });
             dialogbox.show();
			 dialogbox.setFeatureDrawableResource(Window.FEATURE_LEFT_ICON, R.drawable.info);

		
		}

		return super.onKeyDown(keyCode, event);
	}
}
