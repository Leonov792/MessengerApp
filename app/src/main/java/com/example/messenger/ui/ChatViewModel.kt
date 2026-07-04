package com.example.messenger.ui
import android.app.Application; import androidx.lifecycle.AndroidViewModel; import androidx.lifecycle.LiveData; import androidx.lifecycle.viewModelScope
import com.example.messenger.data.AppDatabase; import com.example.messenger.data.MessageRepository; import com.example.messenger.model.Message; import kotlinx.coroutines.launch
class ChatViewModel(application: Application) : AndroidViewModel(application) {
    private val repo = MessageRepository(AppDatabase.getDatabase(application).messageDao())
    val messages: LiveData<List<Message>> = repo.allMessages
    fun send(text: String) = viewModelScope.launch { repo.send(Message(text = text, sender = "You")) }
}
