package com.example.hp.prueba2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hp.prueba2.Model.Book;
import com.example.hp.prueba2.adapter.BookAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public List<Book> listBooks;
    public BookAdapter adapter;
    private RecyclerView booksRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.addBookBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,BookNew.class);
                startActivity(intent);
            }
        });
        Button button1 = (Button) findViewById(R.id.allBooksBtn);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,BookListActivity.class);
                startActivity(intent);
            }
        });
        Button button2 = (Button) findViewById(R.id.borrarLibrosbtn);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book.deleteAll(Book.class);
                Toast.makeText(MainActivity.this, "Libro borrados", Toast.LENGTH_SHORT).show();

            }
        });
    }




}
