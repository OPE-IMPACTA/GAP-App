package br.com.fittipvldi.lmsapp

import android.graphics.drawable.Drawable
import com.google.gson.GsonBuilder
import java.io.Serializable

class Projeto: Serializable {

    var id: Long = 0
    var nome = ""
    var cliente = ""
    var imagem = ""

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }

}