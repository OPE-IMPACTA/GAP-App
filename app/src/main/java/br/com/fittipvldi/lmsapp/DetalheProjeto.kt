package br.com.fittipvldi.lmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhe_projeto.*

class DetalheProjeto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_projeto)

        val projeto = intent.extras?.getSerializable("projeto") as Projeto

        campoNome.text = projeto.nome
        campoCliente.text = projeto.cliente

        botaoRemover.setOnClickListener {
            Thread {
                ProjetoService.removeProjetoDB(projeto)
                runOnUiThread{
                    finish()
                }
            }.start()

        }

        Picasso.with(GAPApplication.getInstance().applicationContext).load(projeto.imagem).fit().into(campoImagem,
            object: com.squareup.picasso.Callback {
                override fun onSuccess() {
                    TODO("Not yet implemented")
                }

                override fun onError() {
                    Toast.makeText(GAPApplication.getInstance().applicationContext, "Erro", Toast.LENGTH_LONG).show()
                }
            })
        Toast.makeText(this, "Clicou projeto ${projeto.nome}", Toast.LENGTH_SHORT).show()
    }
}