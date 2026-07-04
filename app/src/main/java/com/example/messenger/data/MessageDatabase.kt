package com.example.messenger.data
import androidx.lifecycle.LiveData; import androidx.room.*; import com.example.messenger.model.Message
@Dao interface MessageDao {
    @Query("SELECT * FROM messages ORDER BY timestamp ASC") fun getAll(): LiveData<List<Message>>
    @Insert suspend fun insert(m: Message)
}
@Database(entities = [Message::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao
    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null
        fun getDatabase(c: android.content.Context) = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(c, AppDatabase::class.java, "messenger_db").build().also { INSTANCE = it }
        }
    }
}
class MessageRepository(private val dao: MessageDao) {
    val allMessages: LiveData<List<Message>> = dao.getAll()
    suspend fun send(m: Message) = dao.insert(m)
}
