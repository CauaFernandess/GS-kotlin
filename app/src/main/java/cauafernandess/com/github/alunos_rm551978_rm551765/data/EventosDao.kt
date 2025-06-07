package cauafernandess.com.github.alunos_rm551978_rm551765.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import cauafernandess.com.github.alunos_rm551978_rm551765.model.EventosModel

@Dao
interface EventosDao {

    /**
     * Este método busca todos os itens do banco de dados.
     * Ele usa uma consulta SQL definida com a anotação @Query para buscar os dados.
     * O método retorna um objeto LiveData contendo uma lista de ItemModel.
     * LiveData é parte da biblioteca Android Architecture Components, que nos permite construir objetos de dados que notificam as views quando o banco de dados subjacente muda.
     *
     * @return objeto LiveData contendo uma lista de ItemModel.
     */
    @Query("SELECT * FROM EventosModel")
    fun getAll(): LiveData<List<EventosModel>>

    /**
     * Este método insere um item no banco de dados.
     * A anotação @Insert é parte da biblioteca Room Persistence, que fornece uma camada de abstração sobre o SQLite.
     * O método recebe um objeto ItemModel como parâmetro, que é inserido no banco de dados.
     *
     * @param item O objeto ItemModel a ser inserido no banco de dados.
     */
    @Insert
    fun insert(item: EventosModel)

    /**
     * Este método deleta um item do banco de dados.
     * A anotação @Delete é parte da biblioteca Room Persistence, que fornece uma camada de abstração sobre o SQLite.
     * O método recebe um objeto ItemModel como parâmetro, que é deletado do banco de dados.
     *
     * @param item O objeto ItemModel a ser deletado do banco de dados.
     */
    @Delete
    fun delete(item: EventosModel)
}