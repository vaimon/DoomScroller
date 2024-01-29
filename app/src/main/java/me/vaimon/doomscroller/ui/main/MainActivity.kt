package me.vaimon.doomscroller.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadState
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
        setupPaging()
        setContentView(binding.root)
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
    }

    private fun setupPaging() {
        lifecycleScope.launch {
            viewModel.postPagingFlow.collectLatest {
                postsAdapter.submitData(it)
            }
        }
        lifecycleScope.launch {
            postsAdapter.loadStateFlow.collectLatest {
                binding.progressBar.isVisible = it.refresh is LoadState.Loading
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