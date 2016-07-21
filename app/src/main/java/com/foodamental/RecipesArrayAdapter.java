package com.foodamental;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by Madhow on 18/07/2016.
 */
public class RecipesArrayAdapter extends ArrayAdapter<RecipeItem>{

    public RecipesArrayAdapter(Context context, int resource, List<RecipeItem> objects) {
        super(context, resource, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView==null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.recipe_row_layout,parent,false);
        }
        RecipesListViewHolder rlvh = (RecipesListViewHolder) convertView.getTag();
        if(rlvh==null)
        {
            rlvh = new RecipesListViewHolder();
            rlvh.image = (ImageView) convertView.findViewById(R.id.imageRecipe);
            rlvh.Title = (TextView) convertView.findViewById(R.id.RecipeNameInList);
            convertView.setTag(rlvh);
        }

        RecipeItem item = getItem(position);

        rlvh.Title.setText(item.getName());
        rlvh.image.setImageBitmap(item.getImage());
        return convertView;
    }
}