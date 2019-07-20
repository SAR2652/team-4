package com.example.jay.jeevika;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class FishAdapter extends ArrayAdapter<Fish> {

    public FishAdapter(Context context, ArrayList<Fish> fishes) {
        super(context, 0, fishes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.seller_list_content, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Fish currentFish = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView sellerNameText = (TextView) listItemView.findViewById(R.id.sellerNameText);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        sellerNameText.setText(currentFish.getSellerNameText());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView sellerNumberText = (TextView) listItemView.findViewById(R.id.sellerNumberText);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        sellerNumberText.setText(currentFish.getSellerNumberText());

        TextView sellerPriceText = (TextView) listItemView.findViewById(R.id.sellerPriceText);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        sellerPriceText.setText(currentFish.getSellerPriceText());

        TextView sellerStarRatingText = (TextView) listItemView.findViewById(R.id.sellerStarRatingText);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        sellerStarRatingText.setText(currentFish.getSellerStarRatingText());

        TextView sellerDistanceText = (TextView) listItemView.findViewById(R.id.sellerDistanceText);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        sellerDistanceText.setText(currentFish.getSellerDistanceText());




        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
