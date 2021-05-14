package br.com.fittipvldi.lmsapp

import android.graphics.drawable.Drawable
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL

object ProjetoService {

    val host = "https://fittipvldi.pythonanywhere.com"
    val TAG = "WS_LMSApp"

    fun getProjetos(): List<Projeto> {

        val url = "$host/projetos"
        val json = HttpHelper.get(url)

        Log.d(TAG, json)

        var projetos = parserJson<List<Projeto>>(json)

        return projetos

    //val clientes = listOf<String>("Bullest", "Santander", "Supera", "Banco Daycoval", "Banco Alpha")
    //var projetosNome = listOf<String>("Landpage", "Santander Caceis", "CRM4U", "Originals", "Alpha")
    //var fotos = listOf<String>(
    //"http://bullest.com.br/assets/img/logos/logo-bullest-banner.png",
    //"https://logodownload.org/wp-content/uploads/2017/05/santander-logo-1.png",
    //"http://crm4u.azurewebsites.net/Content/assets/dist/img/logo.png",
    //"https://institutomontanari.com.br/wp-content/uploads/2020/12/Banco-Daycoval-1.png",
    //"https://apamagis.com.br/institucional/wp-content/uploads/2019/05/BANCO-ALFA-1.jpg"
    //)

    //var imgs = listOf<Int>(
    //R.drawable.logo_bullest_blue,
    //R.drawable.santander,
    //R.drawable.crm,
    //R.drawable.daycoval,
    //R.drawable.alpha
    //)
//        var imgs = listOf<Integer>{R.drawable.logo_bullest_blue, R.}
    //var count:Long = 1
    //for (i in 0..4  ) {
    //val d = Projeto()
    //d.nome = projetosNome[i]
    //d.cliente = clientes[i]
    //d.foto = fotos[i]
    //d.id = count
    //d.img = imgs[i]
    //projetos.add(d)
    //count++
    //}
    //for (i in 0..4) {
    //val d = Projeto()
    //d.nome = projetosNome[i]
    //d.cliente = clientes[i]
    //d.foto = fotos[i]
    //d.id = count
    //projetos.add(d)
    //count++
    //}
    }

    fun getProjetosDB(): List<Projeto> {
        val dao = DatabaseManager.getProjetoDAO()
        return dao.findAll()
    }

    fun saveProjeto(projeto: Projeto) : String {
        val json = HttpHelper.post("$host/projetos", projeto.toJson())
        return json
    }

    fun saveProjetoDB(projeto: Projeto): String {
        val dao = DatabaseManager.getProjetoDAO()
        dao.insert(projeto)

        return "OK"
    }

    fun removeProjetoDB(projeto: Projeto) {
        val dao = DatabaseManager.getProjetoDAO()
        dao.delete(projeto)
    }

    inline fun <reified T> parserJson(json: String) : T{
        val type = object: TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}