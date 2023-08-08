package com.example.netclantask

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class refine : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.refine)
            supportActionBar?.hide()
        val spinner = findViewById<Spinner>(R.id.spinner)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val editText = findViewById<EditText>(R.id.editText)
        val wordCountTextView = findViewById<TextView>(R.id.wordCountTextView)
        val progressTextView = findViewById<TextView>(R.id.progressTextView)
        val other_icon = findViewById<ImageView>(R.id.imageView)

        val options = arrayOf("Available | Hey Let Us Connect", "Away | Stay Discrete And Watch", "Busy | Do Not Disturb | Will Catch Up Later", "SOS | Emergency! Need Assistance! HELP")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter


        other_icon.setOnClickListener {
            onBackPressed()
        }
        // Set the progress change listener to update the progressTextView position
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Update the progress of the ProgressBar
                // You can use the progress value as needed
                // For example, updating the progress of the ProgressBar
                // progressBar.progress = progress

                // Update the TextView text to show the progress value
                progressTextView.text = progress.toString()

                // Calculate the position of the thumb based on the progress value
                val thumb = seekBar?.thumb
                val thumbWidth = thumb?.intrinsicWidth ?: 0
                val thumbOffset = (seekBar?.width ?: 0) * progress / (seekBar?.max ?: 1)
                val thumbX = thumbOffset - thumbWidth / 2

                // Update the position of the TextView to be on top of the SeekBar thumb
                progressTextView.x = thumbX.toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // No action needed
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // No action needed
            }
        })

        // Set a TextWatcher to update word count
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val wordCount = s?.trim()?.split("\\s+".toRegex())?.size ?: 0
                wordCountTextView.text = "$wordCount / 100"
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}

