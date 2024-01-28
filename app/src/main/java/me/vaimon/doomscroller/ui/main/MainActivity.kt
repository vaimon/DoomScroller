package me.vaimon.doomscroller.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import dagger.hilt.android.AndroidEntryPoint
import me.vaimon.doomscroller.R
import me.vaimon.doomscroller.databinding.ActivityMainBinding
import me.vaimon.doomscroller.ui.main.adapters.PostsRvAdapter

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var postsAdapter: PostsRvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setupToolbar()
        setupRecyclerView()
        setupObservers()
        viewModel.fetchPosts()
        toggleProgressBar(true)
        setContentView(binding.root)
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
    }

    private fun setupObservers() {
        viewModel.posts.observe(this){
            toggleProgressBar(false)
            postsAdapter.setItems(it)
        }
    }

    private fun toggleProgressBar(shouldShow: Boolean){
        binding.progressBar.visibility = if(shouldShow) View.VISIBLE else View.GONE
    }

    private fun setupRecyclerView(){
        binding.rvPostsList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PostsRvAdapter().also {
                postsAdapter = it
            }
        }
    }
}