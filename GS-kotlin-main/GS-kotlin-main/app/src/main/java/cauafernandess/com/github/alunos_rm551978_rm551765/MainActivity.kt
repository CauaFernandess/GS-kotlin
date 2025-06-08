package cauafernandess.com.github.alunos_rm551978_rm551765

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import cauafernandess.com.github.alunos_rm551978_rm551765.model.EventosModel
import cauafernandess.com.github.alunos_rm551978_rm551765.viewmodel.EventosAdapter
import cauafernandess.com.github.alunos_rm551978_rm551765.viewmodel.EventosViewModel
import cauafernandess.com.github.alunos_rm551978_rm551765.viewmodel.EventosViewModelFactory
import java.text.SimpleDateFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: EventosViewModel
    private lateinit var editTextNomeLocal: EditText
    private lateinit var editTextTipoEvento: EditText
    private lateinit var editTextGrauImpacto: EditText
    private lateinit var editTextDataEvento: EditText
    private lateinit var editTextNumeroPessoas: EditText
    private lateinit var buttonIncluir: Button
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Registro de Eventos Extremos"

        editTextNomeLocal = findViewById(R.id.editTextNomeLocal)
        editTextTipoEvento = findViewById(R.id.editTextTipoEvento)
        editTextGrauImpacto = findViewById(R.id.editTextGrauImpacto)
        editTextDataEvento = findViewById(R.id.editTextDataEvento)
        editTextNumeroPessoas = findViewById(R.id.editTextNumeroPessoas)
        buttonIncluir = findViewById(R.id.buttonIncluir)
        recyclerView = findViewById(R.id.recyclerView)

        val eventosAdapter = EventosAdapter { evento ->
            viewModel.removeEvento(evento)
        }
        recyclerView.adapter = eventosAdapter

        val eventosViewModelFactory = EventosViewModelFactory(application)
        viewModel = ViewModelProvider(this, eventosViewModelFactory).get(EventosViewModel::class.java)

        viewModel.eventosLiveData.observe(this) {
            eventos -> eventosAdapter.updateEventos(eventos)
        }

        buttonIncluir.setOnClickListener {
            addEvento()
        }
    }

    private fun addEvento() {
        val nomeLocal = editTextNomeLocal.text.toString().trim()
        val tipoEvento = editTextTipoEvento.text.toString().trim()
        val grauImpacto = editTextGrauImpacto.text.toString().trim()
        val dataEventoStr = editTextDataEvento.text.toString().trim()
        val numeroPessoasStr = editTextNumeroPessoas.text.toString().trim()

        if (nomeLocal.isEmpty()) {
            editTextNomeLocal.error = "Campo obrigatório"
            return
        }
        if (tipoEvento.isEmpty()) {
            editTextTipoEvento.error = "Campo obrigatório"
            return
        }
        if (grauImpacto.isEmpty()) {
            editTextGrauImpacto.error = "Campo obrigatório"
            return
        }
        if (dataEventoStr.isEmpty()) {
            editTextDataEvento.error = "Campo obrigatório"
            return
        }
        if (numeroPessoasStr.isEmpty()) {
            editTextNumeroPessoas.error = "Campo obrigatório"
            return
        }

        val dataEvento: Long
        try {
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val date = sdf.parse(dataEventoStr)
            dataEvento = date?.time ?: 0L
            if (dataEvento == 0L) {
                editTextDataEvento.error = "Formato de data inválido (DD/MM/AAAA)"
                return
            }
        } catch (e: Exception) {
            editTextDataEvento.error = "Formato de data inválido (DD/MM/AAAA)"
            return
        }

        val numeroPessoas: Int
        try {
            numeroPessoas = numeroPessoasStr.toInt()
            if (numeroPessoas <= 0) {
                editTextNumeroPessoas.error = "Deve ser maior que zero"
                return
            }
        } catch (e: NumberFormatException) {
            editTextNumeroPessoas.error = "Número inválido"
            return
        }

        val evento = EventosModel(
            nomeLocal = nomeLocal,
            tipoEvento = tipoEvento,
            grauImpacto = grauImpacto,
            dataEvento = dataEvento,
            numeroPessoas = numeroPessoas
        )
        viewModel.addEvento(evento)

        editTextNomeLocal.text.clear()
        editTextTipoEvento.text.clear()
        editTextGrauImpacto.text.clear()
        editTextDataEvento.text.clear()
        editTextNumeroPessoas.text.clear()

        Toast.makeText(this, "Evento incluído com sucesso!", Toast.LENGTH_SHORT).show()
    }
}

