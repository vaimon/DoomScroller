package me.vaimon.doomscroller.ui.splash

import android.annotation.SuppressLint
import android.graphics.drawable.Animatable2
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import me.vaimon.doomscroller.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    private val viewModel: SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)

        setupAnimation()
        setupObservers()
        viewModel.emulateLoadingProcess()

        setContentView(binding.root)
    }

    private fun setupObservers() {
        viewModel.uiState.observe(this){
            if(it.isLoading){
                (binding.animLoading.drawable as AnimatedVectorDrawable).start()
            }else{
                Toast.makeText(this,"End!",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupAnimation() {
        (binding.animLoading.drawable as AnimatedVectorDrawable).let {
            it.registerAnimationCallback(object: Animatable2.AnimationCallback() {
                override fun onAnimationEnd(drawable: Drawable?) {
                    it.start()
                }
            })
        }
    }
}