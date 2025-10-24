package com.example.responsi1mobileh1d021100

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.responsi1mobileh1d021100.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
        initListener()
    }

    private fun initLayout() {
        binding.layoutClubHistory.let {
            it.imgIcon.setImageResource(R.drawable.ball)
            it.tvLayout.setText("Club History")
        }
        binding.layoutHeadCoach.let {
            it.imgIcon.setImageResource(R.drawable.coach)
            it.tvLayout.setText("Head Coach")
        }
        binding.layoutTeamSquad.let {
            it.imgIcon.setImageResource(R.drawable.group)
            it.tvLayout.setText("Team Squad")
        }
    }

    private fun initListener() {
        binding.layoutClubHistory.root.setOnClickListener {
            val intent = Intent(this, ClubHistoryActivity::class.java)
            startActivity(intent)
        }
        binding.layoutHeadCoach.root.setOnClickListener {
            val intent = Intent(this, HeadCoachActivity::class.java)
            startActivity(intent)
        }
        binding.layoutTeamSquad.root.setOnClickListener {
            val intent = Intent(this, SquadActivity::class.java)
            startActivity(intent)
        }
    }
}