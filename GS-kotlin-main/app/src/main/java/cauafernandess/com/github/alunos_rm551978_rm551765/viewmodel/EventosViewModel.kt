package cauafernandess.com.github.alunos_rm551978_rm551765.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import cauafernandess.com.github.alunos_rm551978_rm551765.model.EventosModel
import cauafernandess.com.github.alunos_rm551978_rm551765.data.EventosDao
import cauafernandess.com.github.alunos_rm551978_rm551765.data.EventosDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EventosViewModel(application: Application) : AndroidViewModel(application){

    private val eventosDao: EventosDao

    val eventosLiveData: LiveData<List<EventosModel>>

    init {
        val database = Room.databaseBuilder(
            getApplication(),
            EventosDatabase::class.java,
            "eventos_database"
        ).build()
        eventosDao = database.eventosDao()
        eventosLiveData = eventosDao.getAll()
    }

    fun addEvento(evento: EventosModel){
        viewModelScope.launch(Dispatchers.IO){
            eventosDao.insert(evento)
        }
    }

    fun removeEvento(evento: EventosModel){
        viewModelScope.launch(Dispatchers.IO) {
            eventosDao.delete(evento)
        }
    }
}

