package br.com.fittipvldi.lmsapp

import android.app.Application
import java.lang.IllegalStateException

class GAPApplication: Application(){

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: GAPApplication? = null
        fun getInstance(): GAPApplication {

            if(appInstance == null) {
                throw IllegalStateException("Configurar aplication no Android Manifest")
            }

            return appInstance!!
        }
    }

}