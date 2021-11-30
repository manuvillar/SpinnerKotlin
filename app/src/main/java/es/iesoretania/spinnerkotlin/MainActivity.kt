package es.iesoretania.spinnerkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import es.iesoretania.spinnerkotlin.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    val contenido = arrayOf("Primera","Segunda","Tercera")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val adapter = ArrayAdapter (this, android.R.layout.simple_spinner_item, contenido)

        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        binding.textView.textSize = 24F
        binding.textView.text = contenido[position]
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(this, "No pulsado nada",Toast.LENGTH_LONG).show()
    }
}