package com.your.package;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by worfu on 21/12/14.
 * thanks jarroba.
 */
abstract class UniversalCustomListAdapter extends BaseAdapter {
    private int listItemLayoutId;
    private Context context;
    private ArrayList<?> listItems;

    public UniversalCustomListAdapter(Context context, int listItemLayoutId, ArrayList<?> listItems) {
        super();
        this.context = context;
        this.listItemLayoutId = listItemLayoutId;
        this.listItems = listItems;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(listItemLayoutId, null);
        }
        onItem(listItems.get(position), view);
        return view;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /** Devuelve cada una de las entradas con cada una de las vistas a la que debe de ser asociada
     * @param listItems La entrada que será la asociada a la view. La entrada es del tipo del paquete/handler
     * @param view View particular que contendrá los datos del paquete/handler
     */
    public abstract void onItem (Object listItem, View view);
}
