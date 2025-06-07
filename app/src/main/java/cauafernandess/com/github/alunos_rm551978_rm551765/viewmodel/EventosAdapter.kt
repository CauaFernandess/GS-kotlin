package cauafernandess.com.github.alunos_rm551978_rm551765.viewmodel

import androidx.recyclerview.widget.RecyclerView
import cauafernandess.com.github.alunos_rm551978_rm551765.model.EventosModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import cauafernandess.com.github.alunos_rm551978_rm551765.R


class EventosAdapter(private val onItemRemoved: (EventosModel) -> Unit) : RecyclerView.Adapter<EventosAdapter.EventosViewHolder>() {

    private var eventos = listOf<EventosModel>()

    inner class EventosViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.textViewItem)
        val button = view.findViewById<ImageButton>(R.id.imageButton)

        fun bind(evento: EventosModel) {
            textView.text = evento.tipoEvento
            button.setOnClickListener {
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