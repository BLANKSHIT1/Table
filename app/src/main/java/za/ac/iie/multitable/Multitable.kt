package za.ac.iie.multitable

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Multitable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_multitable)
            //get the table number from the bundle
        val bundle = intent.extras
        val tableString: String? = bundle?.getString("tableNumber")

        //convert the table number to integer
        val tableNumber = tableString?.toIntOrNull() ?: 1  // default to 1 if invalid

        // Display the heading
       val multitable= findViewById<TextView>(R.id.multiView)
        var tableDisplay : String =  "$tableNumber x table\n\n"
        // Loop 10 times and keep adding
        // set the string onto display

        // declare the control variable
        var counter = 1
        while (counter <= 20 ) {
            if (counter == 3 ) {
                counter++
                continue
            }
            val answer = tableNumber * counter
            tableDisplay+="$tableNumber x $counter = ${answer}\n"
            counter ++
        }
        multitable.text = tableDisplay

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        insets
        }
    }
}