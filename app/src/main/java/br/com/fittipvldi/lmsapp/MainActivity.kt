package br.com.fittipvldi.lmsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.login.botao_login
import kotlinx.android.synthetic.main.login.campo_usario
import kotlinx.android.synthetic.main.login.imagem_login
import kotlinx.android.synthetic.main.login_constraint.*

class MainActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_constraint)
        this.supportActionBar?.hide()

        imagem_login.setImageResource(R.drawable.logo_bullest_blue)

        campo_usuario.setText(Prefs.getString("nome_usuario"))
        campo_password.setText(Prefs.getString("senha"))
        checkLogin.isChecked = Prefs.getBoolean("check_login")

        botao_login.setOnClickListener {
            progress_login.visibility = View.VISIBLE

            val user = "aluno"
            val password = "impacta"

            val nomeUsuario = campo_usuario.text.toString()
            val passwordUsuario = campo_password.text.toString()
            val checkLogin = checkLogin.isChecked

            if(checkLogin){
                Prefs.setString("nome_usuario", nomeUsuario)
                Prefs.setString("senha", passwordUsuario)
                Prefs.setBoolean("check_login", checkLogin)
            } else {
                Prefs.setString("nome_usuario", "")
                Prefs.setString("senha", "")
            }
            Prefs.setBoolean("check_login", checkLogin)


            if(nomeUsuario == user && passwordUsuario == password) {
                Toast.makeText(this, "Login efetuado", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, TelaInicialActivity::class.java)
                val params = Bundle()
                params.putString("nome", nomeUsuario)
                intent.putExtras(params)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show()
            }
        }

        val showHidePassword: ToggleButton = findViewById(R.id.toggleButton)
        showHidePassword.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                campo_password.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else {
                campo_password.transformationMethod = PasswordTransformationMethod.getInstance()

            }
        }
    }

    override fun onResume() {
        super.onResume()
        progress_login.visibility = View.GONE
    }


}