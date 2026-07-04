# 💬 MessengerApp — Чат на Android

Простое приложение для обмена сообщениями с локальным хранением в Room.

## 📱 Screenshots
*(Скриншоты будут добавлены — запусти эмулятор в Android Studio)*

## 🛠 Tech Stack
- **Kotlin** + Coroutines
- **MVVM** Architecture
- **Room** Database (локальное хранение сообщений)
- **LiveData** для реактивного UI
- **RecyclerView** + **CardView**
- **Material Design 3**
- **ViewBinding**

## 📁 Project Structure
```
app/src/main/java/com/example/messenger/
├── data/   — MessageDao, AppDatabase, MessageRepository
├── model/  — Message entity
└── ui/     — MainActivity, ChatViewModel
```

## 🚀 How to Build
1. Open in **Android Studio** (Hedgehog 2023.1+)
2. Sync Gradle → **Build → Build APK**
3. Or via CLI: `gradlew assembleDebug`

## 📦 Download APK
[⬇️ v1.0 Release](https://github.com/Leonov792/MessengerApp/releases/tag/v1.0)
