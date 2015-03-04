package com.shennong346.myexpandablelistview;

import java.util.ArrayList;

/**
 * Created by lab506 on 15/3/4.
 */
public class Group {
    private String id;
    private String title;
    private ArrayList<Child> children;

    public Group(String id, String title) {
        this.id = id;
        this.title = title;
        children = new ArrayList<Child>();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void addChildrenItem(Child child) {
        children.add(child);
    }

    public int getChildrenCount() {
        return children.size();
    }

    public Child getChildItem(int index) {
        return children.get(index);
    }
}
