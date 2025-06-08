package cauafernandess.com.github.alunos_rm551978_rm551765.viewmodel

import androidx.recyclerview.widget.RecyclerView
import cauafernandess.com.github.alunos_rm551978_rm551765.model.EventosModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import cauafernandess.com.github.alunos_rm551978_rm551765.R


class EventosAdapter : RecyclerView.Adapter<EventosAdapter.ItemViewHolder>() {

    private val eventos = mutableListOf<EventosModel>()

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewEventoTipo = view.findViewById<TextView>(R.id.textViewEventoTipo)
        val textViewEventoLocal = view.findViewById<TextView>(R.id.textViewNome)
        val textViewEventoGrauImpacto = view.findViewById<TextView>(R.id.textViewEventoGrau)
        val textViewEventoData = view.findViewById<TextView>(R.id.textViewEventoData)
        val textViewEventoNumeroPessoas =
            view.findViewById<TextView>(R.id.textViewEventoPessoasAfetadas)
        val button = view.findViewById<ImageButton>(R.id.imageButton)

        fun  bind(evento: EventosModel){
            textViewEventoTipo.text = evento.tipoEvento
            textViewEventoLocal.text = evento.nomeLocal
            textViewEventoGrauImpacto.text = evento.grauImpacto
            textViewEventoData.text = evento.dataEvento.toString()
            textViewEventoNumeroPessoas.text = evento.numeroPessoas.toString()

            button.setOnClickListener {
                evento.onRemove(evento)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }
    override fun getItemCount(): Int = eventos.size
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val evento = eventos[position]
        holder.bind(evento)
    }
    fun addEvento(evento: EventosModel) {
        eventos.add(evento)
        notifyDataSetChanged()

}
    fun removeEvento(evento: EventosModel) {
        eventos.remove(evento)
        notifyDataSetChanged()
    }
}








