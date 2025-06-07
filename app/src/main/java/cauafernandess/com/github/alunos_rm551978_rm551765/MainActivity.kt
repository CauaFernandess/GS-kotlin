package cauafernandess.com.github.alunos_rm551978_rm551765

import android.os.Bundle
import android.view.View
import android.view.ViewManager
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.RecyclerView
import cauafernandess.com.github.alunos_rm551978_rm551765.model.EventosModel
import cauafernandess.com.github.alunos_rm551978_rm551765.ui.theme.Alunos_RM551978_RM551765Theme
import cauafernandess.com.github.alunos_rm551978_rm551765.viewmodel.EventosAdapter
import cauafernandess.com.github.alunos_rm551978_rm551765.viewmodel.EventosViewModel
import cauafernandess.com.github.alunos_rm551978_rm551765.viewmodel.EventosViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: EventosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Eventos Extremos"

        val  recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val eventosAdapter = EventosAdapter { evento ->
            viewModel.removeEvento(evento)
        }
        recyclerView.adapter = eventosAdapter

        val  button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)
        button.setOnClickListener {
            if (editText.text.isEmpty()) {
                editText.error = "Campo obrigatório"
                return@setOnClickListener
            }

            viewModel.addEvento(editText.text.toString())
            editText.text.clear()
        }
        val eventosViewModelFactory = EventosViewModelFactory(application)
        viewModel = ViewModelProvider(this, eventosViewModelFactory).get(EventosViewModel::class.java)

        viewModel.eventosLiveData.observe(this){
            eventos -> eventosAdapter.updateEventos(eventos)
        }

    }
}

