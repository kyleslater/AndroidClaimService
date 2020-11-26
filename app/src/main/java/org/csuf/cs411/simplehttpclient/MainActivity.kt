package org.csuf.cs411.simplehttpclient

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    fun refreshScreen(success: Boolean) {
        val titleView: EditText = findViewById(R.id.cTitle)
        val dateView: EditText = findViewById(R.id.date)
        val statusView: EditText = findViewById(R.id.status)

        Log.d("Person Service", "Refreshing the Screen. ")
        if (success) {
            statusView.setText("Claim ${titleView.getText().toString()} was successfully created.")
        } else {
            statusView.setText("Claim ${titleView.getText().toString()} failed to be created.")
        }
        titleView.getText().clear()
        dateView.getText().clear()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fldRowGenerator = ObjDetailSectionGenerator(this)
        val colView = fldRowGenerator.generate()
        setContentView(colView)


        val button = findViewById<Button>(R.id.btn)
        button?.setOnClickListener()
        {
            var title = findViewById<EditText>(R.id.cTitle).getText().toString()
            var date = findViewById<EditText>(R.id.date).getText().toString()
            var cObj: Claim = Claim(title, date)
            ClaimService(this).addClaim(cObj)
        }
    }
}
