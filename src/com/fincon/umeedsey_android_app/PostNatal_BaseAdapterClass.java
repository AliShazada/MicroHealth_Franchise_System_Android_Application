package com.fincon.umeedsey_android_app;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PostNatal_BaseAdapterClass extends BaseAdapter {
	private static ArrayList<SearchResults_Postnatal> searchArrayList;

	private LayoutInflater mInflater;

	public PostNatal_BaseAdapterClass(Context context,
			ArrayList<SearchResults_Postnatal> results) {
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
			convertView = mInflater.inflate(R.layout.postnatal_row_view, null);
			holder = new ViewHolder();
			holder.txtName = (TextView) convertView
					.findViewById(R.id.name_postnatalList);
			holder.txtGardianName = (TextView) convertView
					.findViewById(R.id.gardian_postnatalList);

			// //
			holder.txtLMP = (TextView) convertView
					.findViewById(R.id.prenatallist_lmp_postnatalList);
			holder.txtEDD = (TextView) convertView
					.findViewById(R.id.prenatallist_edd_postnatalList);
			holder.txtWeekNo = (TextView) convertView
					.findViewById(R.id.prenatallist_weekno_postnatalList);
			holder.txtMrNumber = (TextView) convertView
					.findViewById(R.id.prenatallist_MrNumber_postnatalList);
			
			holder.txtDeliveryStatus = (TextView) convertView
					.findViewById(R.id.prenatallist_delivery_postnatalList);

			// //

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.txtName.setText(searchArrayList.get(position)
				.getName_postnatal());
		holder.txtGardianName.setText(searchArrayList.get(position)
				.getGardianname_postnatal());
		

		holder.txtLMP.setText(searchArrayList.get(position).getLMP_postnatal());
		holder.txtEDD.setText(searchArrayList.get(position).getEDD_postnatal());
		holder.txtWeekNo.setText(searchArrayList.get(position)
				.getWeekNo_postnatal());
		holder.txtMrNumber.setText(searchArrayList.get(position)
				.getMrNumber_postnatal());
		
		holder.txtDeliveryStatus .setText("Delivery : " +searchArrayList.get(position)
				.getDelivery_postnatal());

		return convertView;
	}

	static class ViewHolder {
		TextView txtName;
		TextView txtCityState;
		TextView txtPhone;

		TextView txtGardianName;

		TextView txtLMP;
		TextView txtEDD;
		TextView txtWeekNo;
		TextView txtMrNumber;
		
		TextView txtDeliveryStatus;
	}

}