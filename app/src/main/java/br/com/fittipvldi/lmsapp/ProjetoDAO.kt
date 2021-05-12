package br.com.fittipvldi.lmsapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProjetoDAO {

    @Query("SELECT * FROM projeto WHERE id = :id")
    fun getById(id: Long): Projeto?

    @Query("SELECT * FROM projeto")
    fun findAll(): List<Projeto>

    @Insert
    fun insert(projeto: Projeto)

    @Delete
    fun delete(projeto: Projeto)

}