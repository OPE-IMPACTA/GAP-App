package br.com.fittipvldi.lmsapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Projeto::class), version = 1)
abstract class GAPDatabase: RoomDatabase() {
    abstract fun projetoDAO(): ProjetoDAO
}