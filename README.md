# 📝 NoteTakingAppCompose - Modern Note Taking App

> **A clean, reactive note-taking application built with Jetpack Compose, MVVM architecture, Room Database, and Hilt for Dependency Injection. It provides a seamless user experience for managing daily thoughts and tasks.**

---

## 🚀 Features

- 💾 **Local Persistence:** Uses Room Database to store notes locally for instant access.
- 🎨 **Modern UI:** Fully built with Jetpack Compose for a declarative and fluid user interface.
- 🧠 **Clean Architecture:** Implements MVVM pattern with a dedicated Repository layer.
- 💉 **Dependency Injection:** Powered by Hilt (Dagger) for scalable and maintainable code.
- 🔄 **Reactive State Management:** Utilizes Kotlin Flow and StateFlow for real-time UI updates.
- 🕒 **Timestamped Notes:** Automatically tracks when notes are created or modified.

---

## 🎨 Tech Stack

- **Language:** [Kotlin](https://kotlinlang.org/)
- **UI Framework:** [Jetpack Compose](https://developer.android.com/compose)
- **Architecture:** MVVM (Model-View-ViewModel)
- **Dependency Injection:** [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- **Local Storage:** [Room Database](https://developer.android.com/training/data-storage/room)
- **Asynchronous:** Kotlin Coroutines & Flow

---

## 🏗️ Project Structure

```
com.surajvanshsv.notetakingapp/
├── di/
│   └── AppModule.kt             # Hilt Module for providing dependencies
├── repo/
│   └── NoteRepository.kt        # Abstraction layer between UI and Data
├── room/
│   ├── Note.kt                  # Entity class for Room
│   ├── NoteDao.kt               # Data Access Object for Room
│   └── NoteDatabase.kt          # Room Database configuration
├── screens/
│   ├── NoteItem.kt              # Composable for individual note items
│   └── NoteScreen.kt            # Main screen for displaying and adding notes
├── viewmodel/
│   └── NoteViewModel.kt         # Holds UI state and business logic
├── MyApp.kt                     # Hilt Application class
└── MainActivity.kt              # Entry point of the application
```

---

## ⚙️ Installation & Run

1. **Clone this repo:**

```bash
git clone https://github.com/surajpsk12/NoteTakingAppComposeUsingHilt.git
cd NoteTakingAppComposeUsingHilt
```

2. **Open in Android Studio (Ladybug or newer recommended).**

3. **Build and run the app on an emulator or physical device.**

---

## 🧪 Future Enhancements

* ✅ Search functionality to find notes quickly.
* ✅ Categories/Tags for better note organization.
* ✅ Dark Mode support.
* ✅ Archive and Trash features.

---

## 🤝 Contribution

Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to change or improve.

---

## 📜 License

MIT © 2025 [Suraj Kumar](https://github.com/surajpsk12)

📬 **Connect with Me**

*   **Suraj Kumar**
*   **Email**: [sk658139@gmail.com](mailto:sk658139@gmail.com)
*   **LinkedIn**: [linkedin.com/in/surajvansh12](https://www.linkedin.com/in/surajvansh12/)
*   **GitHub**: [github.com/surajpsk12](https://github.com/surajpsk12)
