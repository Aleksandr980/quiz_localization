package com.example.M9_quiz_localization

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.provider.CalendarContract.Calendars
import android.provider.CalendarContract.Instances
import android.transition.Explode
import android.transition.Fade
import android.transition.Visibility
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import androidx.navigation.fragment.findNavController
import com.example.M9_quiz_localization.databinding.FragmentFirstBinding
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.snackbar.Snackbar
import java.lang.reflect.Array.get
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Objects

val dataFormat = SimpleDateFormat("dd-MM-yy")
val calendar = Calendar.getInstance()
val data = calendar.time

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        enterTransition = Fade()
        exitTransition = Explode()

        binding.buttonFirst.animate().apply {
            duration = 2000
            rotation(360f)
            scaleX(3f)
            scaleY(3f)
            translationY(-360f)

            ObjectAnimator.ofArgb(
                binding.buttonFirst, "textColor",
                Color.parseColor("#9B8300D4"),
                Color.parseColor("#E1D615A6"),
            ).apply {
                duration = 6000
                start()
            }
        }

        binding.buttonFirst.setOnClickListener {

            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.buttonDataBirth.setOnClickListener {
            val constraints = CalendarConstraints.Builder()
                .setOpenAt(calendar.timeInMillis)
                .build()
            val dataDialog = MaterialDatePicker.Builder.datePicker()
                .setCalendarConstraints(constraints)
                .setTitleText(resources.getString(R.string.choose_the_data))
                .build()
            dataDialog.addOnPositiveButtonClickListener { timeInMillis ->
                calendar.timeInMillis = timeInMillis
                Snackbar.make(binding.buttonDataBirth,
                    dataFormat.format(calendar.time),
                    Snackbar.LENGTH_LONG).show()
            }

            dataDialog.show(parentFragmentManager, "DataPicker")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}