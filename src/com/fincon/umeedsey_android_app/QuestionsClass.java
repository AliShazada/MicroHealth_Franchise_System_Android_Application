package com.fincon.umeedsey_android_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class QuestionsClass extends Activity {

	Spinner Sp_ArtificialBreath, Sp_BabyKept, SP_BreastFeeding,
			SP_BabyGivingBath;
	Button BTN_Save;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.questions);

		Sp_ArtificialBreath = (Spinner) findViewById(R.id.spinner2_Artificial_bgiviing_questions);
		Sp_BabyKept = (Spinner) findViewById(R.id.spinner2_baby_kept_warm_questions);
		SP_BreastFeeding = (Spinner) findViewById(R.id.spinner2_breastfeeding_apgar);
		SP_BabyGivingBath = (Spinner) findViewById(R.id.spinner2_baby_bath_apgar);

		BTN_Save = (Button) findViewById(R.id.button_save_questions);

		BTN_Save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				if (Sp_ArtificialBreath.getSelectedItem().toString()
						.equals("No Answer")
						|| Sp_BabyKept.getSelectedItem().toString()
								.equals("No Answer")
						|| SP_BreastFeeding.getSelectedItem().toString()
								.equals("No Answer")
						|| SP_BabyGivingBath.getSelectedItem().toString()
								.equals("No Answer")) {
					Toast.makeText(QuestionsClass.this,
							"All the Drop Downs are not selected",
							Toast.LENGTH_LONG).show();
				} else {
					
					Toast.makeText(QuestionsClass.this,
							"Saved ! ..",
							Toast.LENGTH_LONG).show();

					Intent i = new Intent(QuestionsClass.this,
							PostNatal_ListViewClass.class);
					
					startActivity(i);

				}

			}
		});

	}
}
