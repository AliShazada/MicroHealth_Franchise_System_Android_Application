package com.fincon.umeedsey_android_app;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyCustomBaseAdapter extends BaseAdapter {
	private static ArrayList<SearchResults> searchArrayList;

	private LayoutInflater mInflater;

	public MyCustomBaseAdapter(Context context, ArrayList<SearchResults> results) {
		searchArrayList = results;
		mInflater = LayoutInflater.from(context);
	}

	public int getCount() {
		return searchArrayList.size();
	}

	public Object getItem(int position) {
		return searchArrayList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.custom_row_view, null);
			holder = new ViewHolder();
			holder.txtName = (TextView) convertView.findViewById(R.id.name);
			holder.txtGardianName = (TextView) convertView
					.findViewById(R.id.gardian_prenatalList);

			// //
			holder.txtLMP = (TextView) convertView
					.findViewById(R.id.prenatallist_lmp);
			holder.txtEDD = (TextView) convertView
					.findViewById(R.id.prenatallist_edd);
			holder.txtWeekNo = (TextView) convertView
					.findViewById(R.id.prenatallist_weekno);
			holder.txtMrNumber = (TextView) convertView
					.findViewById(R.id.prenatallist_MrNumber);

			// //

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.txtName.setText(searchArrayList.get(position).getName());
		holder.txtLMP.setText(searchArrayList.get(position).getLMP());
		holder.txtEDD.setText(searchArrayList.get(position).getEDD());
		holder.txtWeekNo.setText(searchArrayList.get(position).getWeekNo());
		holder.txtMrNumber.setText(searchArrayList.get(position).getMrNumber());

		return convertView;
	}

	static class ViewHolder {
		TextView txtName;
		TextView txtGardianName;
		TextView txtLMP;
		TextView txtEDD;
		TextView txtWeekNo;
		TextView txtMrNumber;
	}

}