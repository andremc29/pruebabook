package com.example.hp.prueba2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.prueba2.Model.Book;

import java.util.List;

import static com.example.hp.prueba2.R.id.tituloEt;

public class BookNew extends AppCompatActivity {
    private EditText autor;
    private EditText titulo;
    private TextView porcentaje;
    private EditText comentario;
    private SeekBar porcentajeSb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_new);
        autor = (EditText) findViewById(R.id.authorEt);
        titulo = (EditText) findViewById(tituloEt);
        porcentaje = (TextView) findViewById(R.id.porcentajeTv);
        final SeekBar porcentajeSb = (SeekBar) findViewById(R.id.porcentajeSb);
        comentario= (EditText) findViewById(R.id.commentEt);
        String porcent = porcentajeSb.getProgress()+"";
        porcentaje.setText(porcent);
        porcentajeSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            String progress = i + "";
            porcentaje.setText(progress);

        }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        Button grabarbtn = (Button) findViewById(R.id.saveBtn);
        grabarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String nomautor = autor.getText().toString();
                String nomtitulo = titulo.getText().toString();
                String nomcomentario = comentario.getText().toString();
                int numporcentaje = porcentajeSb.getProgress();

                if (nomtitulo == null ||  nomtitulo.isEmpty())
                {
                    Toast.makeText(BookNew.this, "Ingrese Titulo", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(nomautor == null || nomautor.isEmpty())
                {
                    nomautor="Autor Desconocido";
                }

                if (nomcomentario == null || nomcomentario.isEmpty())
                {
                    nomcomentario = "Sin comentarios";

                }

                List<Book> savedBooks = Book.find(Book.class, "autor = ? and  titulo = ?", nomautor,nomtitulo);
                if (savedBooks.size() != 0)
                {
                    Toast.makeText(BookNew.this, "Libro ya existe", Toast.LENGTH_SHORT).show();
                    return;
                }
                Book book = new Book();
                book.setAutor(nomautor);
                book.setTitulo(nomtitulo);
                book.setPorcentaje(numporcentaje);
                book.setComentario(nomcomentario);
                book.save();
                Toast.makeText(BookNew.this, "Libro incluido", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
