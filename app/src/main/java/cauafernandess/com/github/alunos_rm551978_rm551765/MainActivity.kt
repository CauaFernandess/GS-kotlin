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
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val  toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Registros de Eventos bem Etremos =)"
        val  recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val eventosAdapter = EventosAdapter()
        recyclerView.adapter = eventosAdapter
        val button = findViewById<Button>(R.id.button)
        val editTextLocal = findViewById<EditText>(R.id.editTextNome)
        val editTextTipo = findViewById<EditText>(R.id.editTextTipo)
        val editTextData = findViewById<EditText>(R.id.editTextData)
        val editTextPessoas = findViewById<EditText>(R.id.editTextPessoasAfetadas)
        val dataCorreta = SimpleDateFormat("dd/MM/yyyy")
        
        button.setOnClickListener { 
            if (editTextData.text.isEmpty()) {
                editTextData.error = "Campo obrigatório"
                return@setOnClickListener
            }
            if (editTextLocal.text.isEmpty()) {
                editTextLocal.error = "Campo obrigatório"
                return@setOnClickListener
            }
            if (editTextTipo.text.isEmpty()) {
                editTextTipo.error = "Campo obrigatório"
                return@setOnClickListener
            }
            if (editTextPessoas.text.isEmpty()) {
                editTextPessoas.error = "Campo obrigatório"
                return@setOnClickListener
            }
            val evento = EventosModel(
                editTextTipo.toString(),
                editTextPessoas.text.toString().toInt().toString(),
                dataCorreta.parse(editTextData.text.toString()).toString(),
                onRemove = { eventosAdapter.removeEvento(it) },
                dataEvento = TODO(),
                numeroPessoas = TODO()
            )
            eventosAdapter.addEvento(evento)
            editTextPessoas.text.clear()
            editTextTipo.text.clear()
            editTextLocal.text.clear()
            editTextData.text.clear()
        }
    }
}
        
                
            
            
            
        
        
    

