package com.example.nessie_client_tester

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.reimaginebanking.api.nessieandroidsdk.NessieError
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener
import com.reimaginebanking.api.nessieandroidsdk.models.Customer
import com.reimaginebanking.api.nessieandroidsdk.requestclients.NessieClient


private const val API_KEY = ""

// MainActivity serves as a simple test harness to verify SDK functionality and API integration during the migration process.
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val client = NessieClient.getInstance(API_KEY)

        client.CUSTOMER.getCustomers(object : NessieResultsListener {
            override fun onSuccess(result: Any) {
                val customers = result as List<Customer>
                println("success: customers: $customers")
            }

            override fun onFailure(error: NessieError) {
            }
        })
    }
}