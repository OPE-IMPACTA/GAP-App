package br.com.fittipvldi.lmsapp

import androidx.room.Room

object DatabaseManager {
    private var dbInstance: GAPDatabase

    init {
        val context = GAPApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            context,
            GAPDatabase::class.java,
            "gap.sqlite"
        ).build()
    }

    fun getProjetoDAO(): ProjetoDAO {
        return dbInstance.projetoDAO()
    }

}