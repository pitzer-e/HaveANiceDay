package com.example.pitzerhaveanice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class MainActivity : AppCompatActivity() {

    private var calendar = Calendar.getInstance(TimeZone.getDefault())
    private var dayOfWeek: Int = calendar.get(Calendar.DAY_OF_WEEK)

    //  onCreate method for MainActivity
    override fun onCreate(savedInstanceState: Bundle?) {


        val today = Date().toString()
        Log.i("Info", today)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        //  navigate to the current day of the week
        when (dayOfWeek) {
            Calendar.MONDAY -> {
                navController.navigate(R.id.navigation_monday)
            }
            Calendar.TUESDAY -> {
                navController.navigate(R.id.navigation_tuesday)
            }
            Calendar.WEDNESDAY -> {
                navController.navigate(R.id.navigation_wednesday)
            }
            Calendar.THURSDAY -> {
                navController.navigate(R.id.navigation_thursday)
            }
            Calendar.FRIDAY -> {
                navController.navigate(R.id.navigation_friday)
            }
        }

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_dashboard,
                R.id.navigation_monday,
                R.id.navigation_tuesday,
                R.id.navigation_wednesday,
                R.id.navigation_thursday,
                R.id.navigation_friday
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //  Log calendar tab press to logcat when day is selected
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_monday -> Log.i("UserInput", "User selected Monday")
                R.id.navigation_tuesday -> Log.i("UserInput", "User selected Tuesday")
                R.id.navigation_wednesday -> Log.i("UserInput", "User selected Wednesday")
                R.id.navigation_thursday -> Log.i("UserInput", "User selected Thursday")
                R.id.navigation_friday -> Log.i("UserInput", "User selected Friday")
            }

        }
    }

}