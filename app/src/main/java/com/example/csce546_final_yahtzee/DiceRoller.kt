package com.example.csce546_final_yahtzee

// import android.hardware.Sensor
// import android.hardware.SensorEvent
// import android.hardware.SensorEventListener
// import android.hardware.SensorManager
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity allows users to roll five dice for a Yahtzee style game
 */
class DiceRoller : AppCompatActivity()/*, SensorEventListener */{
//    private lateinit var sensorManager: SensorManager
//    private var shake: Sensor? = null
//    private var accel1: Float? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roller)
//        setUpSensor()
        val roll: Button = findViewById(R.id.roll_button)
        roll.setOnClickListener{rollDice()}
    }

    /**
     * TextViews and ImageViews
     */
    // TextViews are created
    private val resultText1: TextView = findViewById(R.id.res_window1)
    private val resultText2: TextView = findViewById(R.id.res_window2)
    private val resultText3: TextView = findViewById(R.id.res_window3)
    private val resultText4: TextView = findViewById(R.id.res_window4)
    private val resultText5: TextView = findViewById(R.id.res_window5)

    // ImageViews are created
    private val resultImg1: ImageView = findViewById(R.id.die_1)
    private val resultImg2: ImageView = findViewById(R.id.die_2)
    private val resultImg3: ImageView = findViewById(R.id.die_3)
    private val resultImg4: ImageView = findViewById(R.id.die_4)
    private val resultImg5: ImageView = findViewById(R.id.die_5)

//    /**
//     * Sets up the accelerometer
//     */
//    private fun setUpSensor() {
//        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
//        shake = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
//    }
//    /**onSensorChanged()
//            rollDice()
//     * Listens for changes in sensor value
//     */
//    override fun onSensorChanged(event: SensorEvent?) {
//        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
//            accel1 = event.values[0]
//            rollDice()
//        }
//    }
//
//    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
//        return
//    }

    /**
     * Rolls each of five dice,
     * then updates TextViews with the rolled numbers
     * and updates ImageViews to match
     */
    private fun rollDice() {
        // die declarations
        val die1 = Dice()
        val die2 = Dice()
        val die3 = Dice()
        val die4 = Dice()
        val die5 = Dice()

        // dice are rolled
        val diceRoll1 = die1.roll()
        val diceRoll2 = die2.roll()
        val diceRoll3 = die3.roll()
        val diceRoll4 = die4.roll()
        val diceRoll5 = die5.roll()

        // TextViews are populated with data
        resultText1.text = diceRoll1.toString()
        resultText2.text = diceRoll2.toString()
        resultText3.text = diceRoll3.toString()
        resultText4.text = diceRoll4.toString()
        resultText5.text = diceRoll5.toString()

        // ImageViews are modified to match
        resultImageSetter(resultImg1, diceRoll1)
        resultImageSetter(resultImg4, diceRoll2)
        resultImageSetter(resultImg2, diceRoll3)
        resultImageSetter(resultImg3, diceRoll4)
        resultImageSetter(resultImg5, diceRoll5)
    }
}

/**
 * Sets each ImageView to match the text-based result of each result's TextView
 */
fun resultImageSetter(img: ImageView, dieRes: Int) {
    when (dieRes) {
        1 -> img.setImageResource(R.drawable.d6_1)
        2 -> img.setImageResource(R.drawable.d6_2)
        3 -> img.setImageResource(R.drawable.d6_3)
        4 -> img.setImageResource(R.drawable.d6_4)
        5 -> img.setImageResource(R.drawable.d6_5)
        6 -> img.setImageResource(R.drawable.d6_6)
    }
}

/**
 * A die with a fixed number of sides
 */
class Dice {
    /**
     * Rolls a random number from 1 to the number of sides
     * then returns the result
     */
    fun roll(): Int {
        return(1..6).random()
    }
}
