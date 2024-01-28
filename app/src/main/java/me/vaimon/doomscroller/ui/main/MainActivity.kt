package me.vaimon.doomscroller.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
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
        setContentView(binding.root)
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            viewModel.postPagingFlow.collectLatest {
                postsAdapter.submitData(it)
            }
        }
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