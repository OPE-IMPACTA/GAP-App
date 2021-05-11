package br.com.fittipvldi.lmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_projeto.*

class ProjetoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projeto)

        salvar.setOnClickListener {
            val textNome = nome.text.toString()
            val textCliente = cliente.text.toString()
            val textImagem = imagem.text.toString()

            val p  = Projeto()
            p.nome = textNome
            p.cliente = textCliente
            p.imagem = textImagem

            Thread {
                ProjetoService.saveProjeto(p)
                runOnUiThread{
                    finish()
                }
            }.start()
        }
    }
}