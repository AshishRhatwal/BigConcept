package mra.com.bigconcept;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private static final String TAG="ListDataActivity";
    DatabaseHelper databaseHelper;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView=(ListView)findViewById(R.id.list);
        databaseHelper=new DatabaseHelper(this);

        populatelistview();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this,"Clicked On List",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void populatelistview()
    {
        Cursor data=databaseHelper.getData();
        ArrayList<String> listdata=new ArrayList<>();
        try {
            while (data.moveToNext()) {
                listdata.add(data.getString(2));

            }
        }
        catch (Exception e)
        {
            Toast.makeText(ListActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();

        }

        ListAdapter adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listdata);
        listView.setAdapter(adapter);
    }
}
