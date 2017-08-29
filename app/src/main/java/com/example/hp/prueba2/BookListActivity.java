package com.example.hp.prueba2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hp.prueba2.Model.Book;
import com.example.hp.prueba2.adapter.BookAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookListActivity extends AppCompatActivity {
    private List<Book> mBooks;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        ButterKnife.bind(this);
        mBooks = Book.listAll(Book.class);

        BookAdapter adapter = new BookAdapter(this, mBooks);
        mRecyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

    }
}
