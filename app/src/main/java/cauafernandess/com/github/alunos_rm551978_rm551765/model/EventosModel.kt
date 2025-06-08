package cauafernandess.com.github.alunos_rm551978_rm551765.model

import android.icu.util.LocaleData
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class EventosModel(

    val tipoEvento: String,
    val nomeLocal: String  ,
    val grauImpacto: String ,
    val dataEvento: Date ,
    val numeroPessoas: Int,
    val onRemove: (EventosModel) -> Unit = {_ ->  }
)