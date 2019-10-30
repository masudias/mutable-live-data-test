package com.example.livedata;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {

    private UserViewModel model;
    private TextView nameTextView;
    private Button someButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameTextView = findViewById(R.id.name);
        someButton = findViewById(R.id.button);

        // Get the ViewModel.
        model = ViewModelProviders.of(this).get(UserViewModel.class);

        // Create the observer which updates the UI.
        final Observer<User> nameObserver = new Observer<User>() {
            @Override
            public void onChanged(@Nullable final User user) {
                // Update the UI, in this case, a TextView.
                nameTextView.setText(user.getName());
            }
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.getUser().observe(this, nameObserver);

        someButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String anotherName = "John Doe";
                model.setName(anotherName);
            }
        });
    }
}