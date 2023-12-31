/**
 * Copyright 2020. Huawei Technologies Co., Ltd. All rights reserved.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.ClarifAI.main.sample.audio.activity.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ClarifAI.main.sample.audio.activity.entity.GridViewItem;
import com.huawei.mlkit.sample.R;

import java.util.ArrayList;


public class GridViewAdapter extends BaseAdapter {
    private final static String TAG = GridViewAdapter.class.getName();

    private Context mContext;

    private ArrayList<GridViewItem> mDataList;

    public GridViewAdapter(ArrayList<GridViewItem> dataList, Context mContext) {
        super();
        this.mDataList = dataList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return this.mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.mContext).inflate(R.layout.gridview_item, null);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.image_item);
            holder.textView = convertView.findViewById(R.id.text_item);
            holder.imageNew = convertView.findViewById(R.id.icon_new);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        GridViewItem item = this.mDataList.get(position);
        if(position == 1){
            holder.imageNew.setBackgroundResource(R.drawable.icon_new);
        } else {
            holder.imageNew.setBackground(null);
        }
        holder.imageView.setImageResource(item.getResourceId());
        holder.textView.setText(item.getStringId());
        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;

        ImageView imageNew;

        TextView textView;
    }
}
