package cauafernandess.com.github.alunos_rm551978_rm551765.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import cauafernandess.com.github.alunos_rm551978_rm551765.model.EventosModel
import java.util.Date

class  EventosViewModel(application: Application) : ViewModel() {
    private var eventos = mutableListOf<EventosModel>()

    fun addEvento(nomeLocal: String, tipoEvento: String, grauImpacto: String, dataEvento: Date, numeroPessoas: Int) {
        val evento = EventosModel(
            tipoEvento,
            nomeLocal,
            grauImpacto,
            dataEvento,
            numeroPessoas,
            onRemove = ::removeEvento)
        eventos.add(evento)
    }
    private fun removeEvento(evento: EventosModel) {
        eventos.remove(evento)
    }
}










