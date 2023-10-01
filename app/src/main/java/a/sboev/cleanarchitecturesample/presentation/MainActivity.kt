package a.sboev.cleanarchitecturesample.presentation

import a.sboev.cleanarchitecturesample.R
import a.sboev.cleanarchitecturesample.data.repository.UserRepositoryImpl
import a.sboev.cleanarchitecturesample.data.storage.SharedPrefUserStorage
import a.sboev.cleanarchitecturesample.domain.models.SaveUserNameParam
import a.sboev.cleanarchitecturesample.domain.usecase.GetUserNameUseCase
import a.sboev.cleanarchitecturesample.domain.usecase.SaveUserNameUseCase
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val sharedPrefUserStorage by lazy { SharedPrefUserStorage(context = applicationContext) }
    private val userRepository by lazy { UserRepositoryImpl(sharedPrefUserStorage) }
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository) }
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            val params = SaveUserNameParam(name = text)
            val result = saveUserNameUseCase.execute(param = params)
            dataTextView.text = "Save result = $result"
        }
        receiveButton.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}