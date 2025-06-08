package cauafernandess.com.github.alunos_rm551978_rm551765.data

import androidx.room.Database
import androidx.room.RoomDatabase
import cauafernandess.com.github.alunos_rm551978_rm551765.R
import cauafernandess.com.github.alunos_rm551978_rm551765.model.EventosModel


@Database(entities = [EventosModel::class], version = 1)
abstract class EventosDatabase : RoomDatabase() {

    abstract fun eventosDao(): EventosDao
}