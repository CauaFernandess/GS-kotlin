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

    private val eventosDao: EventosDao = TODO()

    val eventosLiveData: LiveData<List<EventosModel>>
init {
    val database = Room.databaseBuilder(
        getApplication(),
        EventosDatabase::class.java,
        "eventos_databse"

    ).build()
    eventosDao = database.eventosDao()
    eventosLiveData = eventosDao.getAll()
}

    fun addEvento(evento: String){

        viewModelScope.launch(Dispatchers.IO){
            val novoEvento = EventosModel(
                tipoEvento = evento,
                nomeLocal = "FIAP",
                grauImpacto = "ALTO",
                dataEvento = 6/6/2025,
                numeroPessoas = 0
            )
            eventosDao.insert(novoEvento)
        }
    }

    fun removeEvento(evento: EventosModel){
        viewModelScope.launch(Dispatchers.IO) {
            eventosDao.delete(evento)
        }
    }











}