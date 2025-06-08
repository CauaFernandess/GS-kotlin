package cauafernandess.com.github.alunos_rm551978_rm551765.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import cauafernandess.com.github.alunos_rm551978_rm551765.model.EventosModel

@Dao
interface EventosDao {

    @Query("SELECT * FROM EventosModel")
    fun getAll(): LiveData<List<EventosModel>>

    @Insert
    fun insert(item: EventosModel)

    @Delete
    fun delete(item: EventosModel)
}
