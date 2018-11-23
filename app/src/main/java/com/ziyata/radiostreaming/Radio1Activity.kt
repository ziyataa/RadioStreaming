package com.ziyata.radiostreaming

import android.content.Intent
import android.media.AsyncPlayer
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ziyata.radiostreaming.R.id.progressBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_radio1.*

class Radio1Activity : AppCompatActivity() {

    lateinit var player: MediaPlayer
    var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio1)

        url = intent.getStringExtra("urlRadio1")

        progressBar.isIndeterminate = false
        progressBar.visibility = View.INVISIBLE
        progressBar.max = 100

        setPlaying()

        btnPlay.isEnabled = true
        btnStop.isEnabled = false

        btnPlay.setOnClickListener {
            progressBar.isIndeterminate = true
            progressBar.visibility = View.VISIBLE
            player.prepareAsync()
            player.setOnPreparedListener { player ->
                player.start()
                progressBar.isIndeterminate = false
            }

            btnPlay.isEnabled = false
            btnStop.isEnabled = true

        }
    }

    private fun setPlaying() {
        player = MediaPlayer()
        player.setDataSource(url)
        player.setOnBufferingUpdateListener { MediaPlayer, i ->
            progressBar.isIndeterminate = true
            progressBar.secondaryProgress = 100
        }
    }
}

