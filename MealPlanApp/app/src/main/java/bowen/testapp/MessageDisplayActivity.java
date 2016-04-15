package bowen.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MessageDisplayActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "bowenjin";
    public static final String EXTRA_RETURN = "leeroy";
    private String mMessage;
    private TextView mTextView;
    private EditText mEditText;
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_display);
        mMessage = getIntent().getStringExtra(EXTRA_MESSAGE);
        mTextView = (TextView)findViewById(R.id.message_view);
        mTextView.setText(mMessage);
        mButton = (Button)findViewById(R.id.return_button);
        mButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mEditText = (EditText)findViewById(R.id.return_message);
                String message = mEditText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra(EXTRA_RETURN, message);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
