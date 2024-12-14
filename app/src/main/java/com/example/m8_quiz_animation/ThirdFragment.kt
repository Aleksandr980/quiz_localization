package com.example.M9_quiz_localization

import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Bundle
import android.transition.Explode
import android.transition.Fade
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.navigation.fragment.findNavController
import com.example.M9_quiz_localization.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        enterTransition = Fade()
        exitTransition = Explode()
        ObjectAnimator.ofFloat(
            binding.buttonThird, View.ROTATION, 0f, 720f
        ).apply {
            duration = 6000
            interpolator = AccelerateDecelerateInterpolator()
            repeatCount = 2
            repeatMode = ObjectAnimator.REVERSE
            start()
        }
        ObjectAnimator.ofArgb(
            binding.buttonThird, "textColor",
            Color.parseColor("#FFFFFFFF"),
            Color.parseColor("#FF03DAC5"),
        ).apply {
            duration = 6000
            interpolator = AccelerateDecelerateInterpolator()
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
            start()
        }
        ObjectAnimator.ofArgb(
            binding.textviewThird, "textColor",
            Color.parseColor("#FF3700B3"),
            Color.parseColor("#FF03DAC5"),
        ).apply {
            duration = 6000
            interpolator = AccelerateDecelerateInterpolator()
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
            start()
        }
        binding.buttonThird.setOnClickListener {
            findNavController().navigate(R.id.action_ThirdFragment_to_SecondFragment)
        }

        binding.textviewThird.text = "${arguments?.getString("MyArg")}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}