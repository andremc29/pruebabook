package com.example.hp.prueba2.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.prueba2.Model.Book;
import com.example.hp.prueba2.R;
import com.example.hp.prueba2.ViewActivity;

import java.util.List;

/**
 * Created by HP on 26-08-2017.
 */

    public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

        private Book[] mBooks;
        private Context mContext;
        public BookAdapter(Context context, List<Book> books)
        {
            mContext = context;
            mBooks = books.toArray(new Book[books.size()]);
        }

        @Override
        public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book, parent, false);
            BookViewHolder viewHolder = new BookViewHolder(view);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(BookViewHolder holder, int position) {
            holder.bindBook(mBooks[position]);

        }

        @Override
        public int getItemCount() {
            return mBooks.length;
        }

        public class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
        {

            public TextView autorTv;
            public TextView mTituloLabel;
            public String mComentario;
            public int mPorcentaje;
            public long id;

            public BookViewHolder(View itemView)
            {
                super(itemView);

                autorTv = (TextView) itemView.findViewById(R.id.autorTextView);
                mTituloLabel = (TextView) itemView.findViewById(R.id.tituloTextView);

                itemView.setOnClickListener(this);
            }

            public void bindBook(Book book)
            {
                autorTv.setText(book.getAutor());
                mTituloLabel.setText(book.getTitulo());
                mComentario = book.getComentario();
                mPorcentaje = book.getPorcentaje();
                id = book.getId();
            }

            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(mContext, ViewActivity.class);
                intent.putExtra("libro",id);
                mContext.startActivity(intent);

            }
        }
    }
