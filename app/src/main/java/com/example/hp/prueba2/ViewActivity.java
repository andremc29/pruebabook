package com.example.hp.prueba2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.hp.prueba2.Model.Book;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        long idBook = getIntent().getLongExtra("libro",0);
        Book rowId = Book.findById(Book.class, idBook);

        TextView tituloTv = (TextView) findViewById(R.id.tituloEt);
        TextView autorTv = (TextView) findViewById(R.id.autorEt);
        SeekBar porcentajeSb = (SeekBar) findViewById(R.id.porcentajeSb);
        TextView comentarioTv = (TextView) findViewById(R.id.comentarioEt);
        TextView porcentajeTv = (TextView) findViewById(R.id.porcentajeEt);

        tituloTv.setText(rowId.getTitulo());
        autorTv.setText(String.valueOf(rowId.getAutor()));
        porcentajeTv.setText(String.valueOf(rowId.getPorcentaje()));
        comentarioTv.setText(rowId.getComentario());
        porcentajeSb.setProgress(rowId.getPorcentaje());


    }
}
