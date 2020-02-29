package ru.romananchugov.filmsmvvm.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.romananchugov.filmsmvvm.R
import ru.romananchugov.filmsmvvm.ui.fragments.FilmsListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, FilmsListFragment())
            .commitNow()
    }
}
