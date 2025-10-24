// File: app/src/main/java/com/example/responsi1mobileh1d023065/HeadCoachActivity.kt
package com.example.responsi1mobileh1d021100

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.responsi1mobileh1d021100.databinding.ActivityHeadCoachBinding
import com.example.responsi1mobileh1d021100.viewmodel.MainViewModel

class HeadCoachActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHeadCoachBinding
    private val viewModel: MainViewModel by viewModels()

    private val CLUB_ID = 102

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeadCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeViewModel()
        // Auto-fetch data saat activity dibuka
        viewModel.fetchCoach(CLUB_ID)
    }

    private fun observeViewModel() {
        viewModel.isLoading.observe(this) { isLoading ->
            binding.cardProfile.visibility = if (isLoading) View.GONE else View.VISIBLE
        }

        viewModel.coach.observe(this) { coach ->
            coach?.let {
                binding.tvHeadCoachName.text = it.name
                binding.tvHeadCoachDateOfBirth.text = "${it.dateOfBirth}"
                binding.tvHeadCoachNationality.text = "${it.nationality}"
            }
        }

        viewModel.error.observe(this) { error ->
            error?.let {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        }
    }
}