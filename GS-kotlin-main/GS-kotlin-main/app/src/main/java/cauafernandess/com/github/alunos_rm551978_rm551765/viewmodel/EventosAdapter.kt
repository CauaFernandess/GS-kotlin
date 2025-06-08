package cauafernandess.com.github.alunos_rm551978_rm551765.viewmodel

import androidx.recyclerview.widget.RecyclerView
import cauafernandess.com.github.alunos_rm551978_rm551765.model.EventosModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import cauafernandess.com.github.alunos_rm551978_rm551765.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class EventosAdapter(private val onItemRemoved: (EventosModel) -> Unit) : RecyclerView.Adapter<EventosAdapter.EventosViewHolder>() {

    private var eventos = listOf<EventosModel>()

    inner class EventosViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewNomeLocal = view.findViewById<TextView>(R.id.textViewNomeLocal)
        val textViewTipoEvento = view.findViewById<TextView>(R.id.textViewTipoEvento)
        val textViewGrauImpacto = view.findViewById<TextView>(R.id.textViewGrauImpacto)
        val textViewDataEvento = view.findViewById<TextView>(R.id.textViewDataEvento)
        val textViewNumeroPessoas = view.findViewById<TextView>(R.id.textViewNumeroPessoas)
        val buttonExcluir = view.findViewById<Button>(R.id.buttonExcluir)

        fun bind(evento: EventosModel) {
            textViewNomeLocal.text = "Local: ${evento.nomeLocal}"
            textViewTipoEvento.text = "Tipo: ${evento.tipoEvento}"
            textViewGrauImpacto.text = "Impacto: ${evento.grauImpacto}"

            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val date = Date(evento.dataEvento)
            textViewDataEvento.text = "Data: ${dateFormat.format(date)}"

            textViewNumeroPessoas.text = "Pessoas Afetadas: ${evento.numeroPessoas}"

            buttonExcluir.setOnClickListener {
                onItemRemoved(evento)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventosViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return EventosViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventosViewHolder, position: Int) {
        val evento = (eventos[position])
        holder.bind(evento)
    }

    override fun getItemCount(): Int = eventos.size


fun updateEventos(newEventos: List<EventosModel>) {
        eventos = newEventos
        notifyDataSetChanged()
    }

}

