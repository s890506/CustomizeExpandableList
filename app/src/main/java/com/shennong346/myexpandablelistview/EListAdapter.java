package com.shennong346.myexpandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lab506 on 15/3/4.
 */
public class EListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<Group> groups;

    public EListAdapter(Context context, ArrayList<Group> groups) {
        this.context = context;
        this.groups = groups;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        groups.get(groupPosition).getChildItem(childPosition);
        return null;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    public int getChildrenCount(int groupPosition) {
        return groups.get(groupPosition).getChildrenCount();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    /** 設定 Group 資料 */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        Group group = (Group) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.group_layout, null);
        }

        TextView tv = (TextView) convertView.findViewById(R.id.tvGroup);
        tv.setText(group.getTitle());

        return convertView;
    }

    /** 設定 Children 資料 */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        Child child = groups.get(groupPosition).getChildItem(childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.child_layout, null);
        }

        TextView tv = (TextView) convertView.findViewById(R.id.tvChild);
        tv.setText(child.getFullname());


        return convertView;
    }

}
