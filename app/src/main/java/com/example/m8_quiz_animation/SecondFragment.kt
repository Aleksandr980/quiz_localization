package com.example.M9_quiz_localization

import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.os.Bundle
import android.transition.Explode
import android.transition.Fade
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.M9_quiz_localization.databinding.FragmentSecondBinding
import java.util.Locale
import java.util.Locale.ENGLISH
import java.util.Locale.getDefault


private const val ARG_PARAM1 = "Вы отлично справились!!!"
private const val ARG_PARAM2 = "Попробуйте пройти опрос ещё раз. "

class SecondFragment : Fragment() {

    private var param: String? = null

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = Bundle()

        (AnimatorInflater.loadAnimator(this.activity, R.animator.custom_animator) as ObjectAnimator)
            .apply {
                target = binding.textviewSecond2
                start()
            }
        (AnimatorInflater.loadAnimator(this.activity, R.animator.custom_animator) as ObjectAnimator)
            .apply {
                target = binding.textviewSecond7
                start()
            }
        (AnimatorInflater.loadAnimator(this.activity, R.animator.custom_animator) as ObjectAnimator)
            .apply {
                target = binding.textviewSecond12
                start()
            }
        binding.buttonSecond.animate().apply {
            duration = 35000
            rotation(-720f)
            scaleX(1f)
            scaleY(1f)
            alpha(0f)

        }

        binding.buttonSecond2.animate().apply {
            duration = 35000
            rotation(720f)
            scaleX(1f)
            scaleY(1f)
            alpha(0f)

        }

        enterTransition = Fade()
        exitTransition = Explode()
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.FirstFragment)
        }
        binding.buttonSecond2.setOnClickListener {

            val arg = answer()
            bundle.putString("MyArg", arg)
            findNavController().navigate(R.id.ThirdFragment, bundle)

        }
        binding.checkbox3.setOnClickListener {
            onCheckboxClicked(R.id.SecondFragment)
        }
        binding.checkbox4.setOnClickListener {
            onCheckboxClicked(R.id.SecondFragment)
        }
        binding.checkbox5.setOnClickListener {
            onCheckboxClicked(R.id.SecondFragment)
        }
        binding.checkbox8.setOnClickListener {
            onCheckboxClicked(R.id.SecondFragment)
        }
        binding.checkbox9.setOnClickListener {
            onCheckboxClicked(R.id.SecondFragment)
        }
        binding.checkbox10.setOnClickListener {
            onCheckboxClicked(R.id.SecondFragment)
        }
        binding.checkbox13.setOnClickListener {
            onCheckboxClicked(R.id.SecondFragment)
        }
        binding.checkbox14.setOnClickListener {
            onCheckboxClicked(R.id.SecondFragment)
        }
        binding.checkbox15.setOnClickListener {
            onCheckboxClicked(R.id.SecondFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }

    fun onCheckboxClicked(view: Int) {
        val checkBox: Boolean = false
        val checked = { onCheckboxClicked(view) }
        when (checkBox) {
            true -> checked()
            else -> {}
        }
    }

    fun answer(): String? {
        if (binding.checkbox3.isChecked == false &&
            binding.checkbox4.isChecked == false &&
            binding.checkbox5.isChecked == true &&
            binding.checkbox8.isChecked == true &&
            binding.checkbox9.isChecked == false &&
            binding.checkbox10.isChecked == false &&
            binding.checkbox13.isChecked == false &&
            binding.checkbox14.isChecked == true &&
            binding.checkbox15.isChecked == false
        ) {
            param = ARG_PARAM1
        } else param = ARG_PARAM2

        return param
    }
}