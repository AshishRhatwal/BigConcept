package mra.com.bigconcept;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewuserActivity extends AppCompatActivity {
    EditText name,num,email;
    Button reg;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newuser);

        name=(EditText)findViewById(R.id.uname);
        num=(EditText)findViewById(R.id.number);
        email=(EditText)findViewById(R.id.email);
        reg=(Button)findViewById(R.id.LoginUser);
        databaseHelper=new DatabaseHelper(this);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = name.getText().toString();
                String newnum=num.getText().toString();
                String newEmail=email.getText().toString();
                try {
                    if (name.length() != 0 ) {
                        AddData(newEntry);
                        AddData(newnum);
                        AddData(newEmail);
                        name.setText("");
                        num.setText("");
                        email.setText("");
                        Toast.makeText(NewuserActivity.this,"Sucessfull..",Toast.LENGTH_SHORT).show();

                    } else {

                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(NewuserActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }

                }


        });
    }

    public void AddData(String newEntry)
    {
        boolean insertData=databaseHelper.addData(newEntry);
    }
}
