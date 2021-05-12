package br.com.fittipvldi.lmsapp

import android.graphics.drawable.Drawable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable

@Entity(tableName = "projeto")
class Projeto: Serializable {

    @PrimaryKey
    var id: Long = 0
    var nome = ""
    var cliente = ""
    var imagem = ""

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }

}