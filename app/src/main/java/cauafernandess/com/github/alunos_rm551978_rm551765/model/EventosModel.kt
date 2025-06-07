package cauafernandess.com.github.alunos_rm551978_rm551765.model

import android.icu.util.LocaleData
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EventosModel(

    val tipoEvento: String,
    val nomeLocal: String  ,
    val grauImpacto: String ,
    val dataEvento: Long ,
    val numeroPessoas: Int
)