package nerallan.com.chat.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import nerallan.com.chat.Adapter.DataAdapter;
import nerallan.com.chat.R;

public class MainActivity extends AppCompatActivity {

    private static int MAX_MESSAGE_LENGTH = 100;

    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("messages");

    EditText mEditTextMessage;
    Button mSendButton;
    RecyclerView mMessagesRecycler;

//    List<ChatModel> chatModels = new ArrayList<>();
    ArrayList<String> messages = new ArrayList<>();


    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //view objects
    private TextView textViewUserEmail;
    private Button buttonLogout;
    private FirebaseUser user;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSendButton = findViewById(R.id.send_message_button);
        mEditTextMessage = findViewById(R.id.message_input);
        mMessagesRecycler = findViewById(R.id.messages_recycler);

        // how to display data through adapter
        mMessagesRecycler.setLayoutManager(new LinearLayoutManager(this));
        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        //getting current user
        user = firebaseAuth.getCurrentUser();
        //initializing views
        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);

        //displaying logged in user name
        //textViewUserEmail.setText("Welcome "+user.getEmail());

//        final ChatModel chatModel = new ChatModel();


        final DataAdapter dataAdapter = new DataAdapter(this, messages);
        mMessagesRecycler.setAdapter(dataAdapter);

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = mEditTextMessage.getText().toString();
                if (msg.equals("")){
                    Toast.makeText(getApplicationContext(), "Введите сообщение!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (msg.length() > MAX_MESSAGE_LENGTH){
                    Toast.makeText(getApplicationContext(), "Сообщение слишком большое!", Toast.LENGTH_SHORT).show();
                    return;
                }
//                chatModel.setMessageText(msg);
//                Calendar calendar = Calendar.getInstance();
//                SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm");
//                String strDate = mdformat.format(calendar.getTime());
//
//                chatModel.setMessageTime(strDate);
//                chatModel.setMessageUser(firebaseAuth.getCurrentUser().toString());

                myRef.push().setValue(user.getEmail() + "      " + msg + "       " + getCurrentTime(view));
                mEditTextMessage.setText("");
                //getCurrentTime(view);
            }
        });
//        chatModels.add(chatModel);
        myRef.addChildEventListener(new ChildEventListener() {

            // calls when push message in db(collection messages)
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String msg = dataSnapshot.getValue(String.class);
                messages.add(msg);
                // notify adapter that new message added to update view
                dataAdapter.notifyDataSetChanged();
                // for correct recycler scrolling
                mMessagesRecycler.smoothScrollToPosition(messages.size());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    public String getCurrentTime(View view){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm");
        String strDate = mdformat.format(calendar.getTime());
        //displayTime(strDate);
        return strDate;
    }
//    private void displayTime(String time){
//        TextView textView = (TextView) findViewById(R.id.sender);
//        textView.setText(time);
//    }
}