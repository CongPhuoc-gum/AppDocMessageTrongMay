package com.phancongcoc;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.phancongcoc.model.Contact;

import java.util.ArrayList;

public class DanhBa extends AppCompatActivity {

    public static final int REQUEST_CODE_ASK_PERMISSIONS = 1001;

    ListView lvDanhBa;
    ArrayList<Contact> dsDanhBa;
    ArrayAdapter<Contact> adapterDanhBa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danh_ba);
        addControls();
        showALLContactFromDevice();
    }

    private void showALLContactFromDevice() {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        dsDanhBa.clear();
        while (cursor.moveToNext()) {
            String tenCotname = ContactsContract.Contacts.DISPLAY_NAME;
            String tenCotPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;
            int vitriCotname = cursor.getColumnIndex(tenCotname);
            int vitriCotPhone = cursor.getColumnIndex(tenCotPhone);
            String name = cursor.getString(vitriCotname);
            String phone = cursor.getString(vitriCotPhone);

            Contact contact = new Contact(phone, name);
            dsDanhBa.add(contact);
            adapterDanhBa.notifyDataSetChanged();
        }
        cursor.close();
    }

    private void addControls(){
        lvDanhBa = findViewById(R.id.lvDanhBa);
        dsDanhBa = new ArrayList<>();
        adapterDanhBa = new ArrayAdapter<>(
                DanhBa.this, android.R.layout.simple_list_item_1,dsDanhBa
        );
        lvDanhBa.setAdapter(adapterDanhBa);
    }
}