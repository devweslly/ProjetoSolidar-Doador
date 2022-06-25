package com.solidar.doador.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Usuario::class], version = 1, exportSchema = false)

abstract class UsuarioDatabase : RoomDatabase() {


    abstract fun usuarioDao(): UsuarioDao


    companion object {

        @Volatile

        private var INSTANCE: UsuarioDatabase? = null


        fun getDatabase(context: Context): UsuarioDatabase {
            val tempInstance = INSTANCE


            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UsuarioDatabase::class.java,
                    "solidar_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
