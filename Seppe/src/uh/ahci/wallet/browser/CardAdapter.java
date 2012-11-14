package uh.ahci.wallet.browser;

import java.util.ArrayList;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import uh.ahci.R;
import uh.ahci.wallet.card.Card;

public class CardAdapter extends BaseAdapter {
	private static ArrayList<Card> _cards = null;
	private LayoutInflater _inflater;

	public CardAdapter(Context context, ArrayList<Card> results) {
		_cards = results;
		_inflater = LayoutInflater.from(context);
	}

	public int getCount() {
		return _cards.size();
	}

	public Object getItem(int position) {
		return _cards.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = _inflater.inflate(R.layout.cardbrowserrow, null);
			holder = new ViewHolder();
			holder.name = (TextView) convertView.findViewById(R.id.name);
			holder.extraInfo = (TextView) convertView.findViewById(R.id.extraInfo);
			holder.logo = (ImageView) convertView.findViewById(R.id.logo);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		Card card = _cards.get(position);
		holder.name.setText(card.getStore().getName());
		holder.extraInfo.setText(card.getExtraInfo());
		holder.logo.setImageBitmap(Bitmap.createScaledBitmap(card.getStore().getLogo().getBitmap(), 100, 100, true));

		return convertView;
	}

	static class ViewHolder {
		TextView name;
		ImageView logo;
		TextView extraInfo;
	}
}
