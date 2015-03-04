package com.shennong346.myexpandablelistview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    ArrayList<Group> groups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        groups = new ArrayList<Group>();
        SetGroup();
        ExpandableListView listView = (ExpandableListView) findViewById(R.id.listView);
        EListAdapter adapter = new EListAdapter(this, groups);
        listView.setAdapter(adapter);
    }

    private void SetGroup() {

        String[] item1 = {"AAA","BBB","CCC"};
        String[][] item2 = {{"A1","A2"},
                            {"B1","B2"},
                            {"C1","C2"}};

        for(int i=0;i<item1.length;i++){

            Group group = new Group(i+"", item1[i]);

            for(int j=0;j<item2[i].length;j++){
                Child child = new Child(item2[i][j]);
                group.addChildrenItem(child);
            }
            groups.add(group);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
