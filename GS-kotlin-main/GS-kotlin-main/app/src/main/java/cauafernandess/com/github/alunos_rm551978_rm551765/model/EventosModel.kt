package cauafernandess.com.github.alunos_rm551978_rm551765.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "eventos")
data class EventosModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val tipoEvento: String,
    val nomeLocal: String  ,
    val grauImpacto: String ,
    val dataEvento: Long ,
    val numeroPessoas: Int
)

