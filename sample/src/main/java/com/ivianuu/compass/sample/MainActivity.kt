package com.ivianuu.compass.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ivianuu.compass.CompassFragmentAppNavigator
import com.ivianuu.compass.Destination
import com.ivianuu.traveler.Traveler
import com.ivianuu.traveler.newRootScreen
import com.ivianuu.traveler.setNavigator

@Destination(MainActivity::class)
data class MainDestination(val something: String)

class MainActivity : AppCompatActivity() {

    private val traveler = Traveler()
    val router get() = traveler.router

    private val navigator by lazy(LazyThreadSafetyMode.NONE) {
        CompassFragmentAppNavigator(this, supportFragmentManager, android.R.id.content)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        traveler.navigatorHolder.setNavigator(this, navigator)

        if (savedInstanceState == null) {
            router.newRootScreen(CounterDestination(1, ColorGenerator.generate()))
        }
    }

}