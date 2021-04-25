package com.xenrath.fruitman_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.xenrath.fruitman_v2.data.ResponseLogin
import com.xenrath.fruitman_v2.network.ApiService
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar!!.hide()
        ll_register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        btn_login.setOnClickListener{
            doLogin(et_name.text.toString(), et_password.text.toString())
            startActivity(Intent(this, CreateProductActivity::class.java))
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    fun doLogin(name: String, password: String) {
        onLoading(true)
        ApiService.endpoint.login(name, password).enqueue(object: Callback<ResponseLogin>{
            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                onLoading(false)
                if(response.isSuccessful) {
                    val responseLogin: ResponseLogin? = response.body()
                    showMessage(responseLogin!!.message)
                }
            }

            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                onLoading(false)
            }

        })
    }

    fun onLoading(loading: Boolean) {
        when(loading) {
            true -> {
                progress.visibility = View.VISIBLE
            }
            false -> {
                progress.visibility = View.GONE
            }
        }
    }

    fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}