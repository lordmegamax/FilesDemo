package com.lmmx.FilesDemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.*;

public class MyActivity extends Activity {
    private static final String TAG = "FilesDemo";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void readFile(View ignored) {
        Log.d(TAG, "Reading file...");

        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileInputStream fis = openFileInput("thefile.txt");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
            String line;
            if ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            Log.d(TAG, "File content: " + stringBuilder.toString());
        } catch (FileNotFoundException e) {
            Log.d(TAG, "FileNotFoundException");
        } catch (IOException e) {
            Log.d(TAG, "IOException");
        }
    }

    public void writeFile(View ignored) {
        Log.d(TAG, "Writing file...");

        String text = "This is the content of our file";
        FileOutputStream fos = null;
        try {
            fos = openFileOutput("thefile.txt", Context.MODE_PRIVATE);

            fos.write(text.getBytes());
            fos.flush();
            fos.close();

            Log.d(TAG, "File was written to disk.");
        } catch (FileNotFoundException e) {
            Log.d(TAG, "FileNotFoundException");
        } catch (IOException e) {
            Log.d(TAG, "IOException");
        }
    }
}
