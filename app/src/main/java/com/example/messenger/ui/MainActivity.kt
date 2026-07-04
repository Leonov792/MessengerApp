package com.example.messenger.ui
import android.os.Bundle; import android.view.LayoutInflater; import android.view.ViewGroup; import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity; import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager; import androidx.recyclerview.widget.RecyclerView
import com.example.messenger.databinding.ActivityMainBinding; import com.example.messenger.databinding.ItemMessageBinding
import com.example.messenger.model.Message; import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding; private lateinit var vm: ChatViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState); b = ActivityMainBinding.inflate(layoutInflater); setContentView(b.root)
        vm = ViewModelProvider(this)[ChatViewModel::class.java]
        b.rvMessages.layoutManager = LinearLayoutManager(this)
        vm.messages.observe(this) { b.rvMessages.adapter = Adapter(it) }
        b.fabSend.setOnClickListener { showDialog() }
    }
    private fun showDialog() {
        val input = EditText(this).apply { hint = "Сообщение" }
        MaterialAlertDialogBuilder(this).setTitle("Новое сообщение").setView(input)
            .setPositiveButton("Отправить") { _, _ -> val t = input.text.toString().trim(); if (t.isNotEmpty()) vm.send(t) }
            .setNegativeButton("Отмена", null).show()
    }
    inner class Adapter(private val items: List<Message>) : RecyclerView.Adapter<Adapter.VH>() {
        inner class VH(val b: ItemMessageBinding) : RecyclerView.ViewHolder(b.root)
        override fun onCreateViewHolder(p: ViewGroup, t: Int) = VH(ItemMessageBinding.inflate(LayoutInflater.from(p.context), p, false))
        override fun onBindViewHolder(h: VH, i: Int) { h.b.tvText.text = items[i].text; h.b.tvSender.text = items[i].sender }
        override fun getItemCount() = items.size
    }
}
