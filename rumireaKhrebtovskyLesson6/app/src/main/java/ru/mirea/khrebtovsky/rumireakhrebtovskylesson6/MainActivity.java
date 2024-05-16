package ru.mirea.khrebtovsky.rumireakhrebtovskylesson6;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String PREF_NAME = "ru.mirea.khrebtovsky.lesson6";
    private static final String KEY_GROUP = "group";
    private static final String KEY_NUMBER = "number";
    private static final String KEY_FAVORITE = "favorite";

    private SharedPreferences settingsPreferences;
    private EditText groupEditText, numberEditText, favoriteEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settingsPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        groupEditText = findViewById(R.id.groupEditText);
        numberEditText = findViewById(R.id.numberEditText);
        favoriteEditText = findViewById(R.id.favoriteEditText);
        Button saveButton = findViewById(R.id.saveButton);

        loadStoredData();

        saveButton.setOnClickListener(v -> saveData());
    }

    private void saveData() {
        String group = groupEditText.getText().toString();
        int number = Integer.parseInt(numberEditText.getText().toString());
        String favorite = favoriteEditText.getText().toString();

        SharedPreferences.Editor editor = settingsPreferences.edit();
        editor.putString(KEY_GROUP, group);
        editor.putInt(KEY_NUMBER, number);
        editor.putString(KEY_FAVORITE, favorite);
        editor.apply();
    }

    private void loadStoredData() {
        String savedGroup = settingsPreferences.getString(KEY_GROUP, "");
        int savedNumber = settingsPreferences.getInt(KEY_NUMBER, 0);
        String savedFavorite = settingsPreferences.getString(KEY_FAVORITE, "");

        groupEditText.setText(savedGroup);
        numberEditText.setText(String.valueOf(savedNumber));
        favoriteEditText.setText(savedFavorite);
    }
}
