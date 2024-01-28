package me.vaimon.doomscroller.ui.main

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.vaimon.doomscroller.data.models.Post
import me.vaimon.doomscroller.data.repositories.PostRepository
import javax.inject.Inject

class MainViewModel constructor(
): ViewModel() {

    private val _posts: MutableLiveData<List<Post>> = MutableLiveData()
    val posts: LiveData<List<Post>>
        get() = _posts
    fun fetchPosts(){
        viewModelScope.launch {
            delay(1000)
            _posts.value = listOf(Post(1, "Ara crepusculum vespillo suggero alveus atrox.", "Enim similique ventosus. Sponte damnatio auctor. Ipsam vilitas synagoga. Color illum unde. Collum creo et. Uter eos cunabula. Volup tum desolo. Sint veritatis eos. Vinculum adamo articulus. Vix subnecto bis. Quae bos cervus. Clam arbor torqueo. Acsi vel amicitia. Cum virtus vel. Adsidue claro vado."),
                Post(1, "Ara crepusculum vespillo suggero alveus atrox.", "Enim similique ventosus. Sponte damnatio auctor. Ipsam vilitas synagoga. Color illum unde. Collum creo et. Uter eos cunabula. Volup tum desolo. Sint veritatis eos. Vinculum adamo articulus. Vix subnecto bis. Quae bos cervus. Clam arbor torqueo. Acsi vel amicitia. Cum virtus vel. Adsidue claro vado."),
                Post(1, "Ara crepusculum vespillo suggero alveus atrox.", "Enim similique ventosus. Sponte damnatio auctor. Ipsam vilitas synagoga. Color illum unde. Collum creo et. Uter eos cunabula. Volup tum desolo. Sint veritatis eos. Vinculum adamo articulus. Vix subnecto bis. Quae bos cervus. Clam arbor torqueo. Acsi vel amicitia. Cum virtus vel. Adsidue claro vado."),
                Post(1, "Ara crepusculum vespillo suggero alveus atrox.", "Enim similique ventosus. Sponte damnatio auctor. Ipsam vilitas synagoga. Color illum unde. Collum creo et. Uter eos cunabula. Volup tum desolo. Sint veritatis eos. Vinculum adamo articulus. Vix subnecto bis. Quae bos cervus. Clam arbor torqueo. Acsi vel amicitia. Cum virtus vel. Adsidue claro vado."),
                Post(1, "Ara crepusculum vespillo suggero alveus atrox.", "Enim similique ventosus. Sponte damnatio auctor. Ipsam vilitas synagoga. Color illum unde. Collum creo et. Uter eos cunabula. Volup tum desolo. Sint veritatis eos. Vinculum adamo articulus. Vix subnecto bis. Quae bos cervus. Clam arbor torqueo. Acsi vel amicitia. Cum virtus vel. Adsidue claro vado."),
                Post(1, "Ara crepusculum vespillo suggero alveus atrox.", "Enim similique ventosus. Sponte damnatio auctor. Ipsam vilitas synagoga. Color illum unde. Collum creo et. Uter eos cunabula. Volup tum desolo. Sint veritatis eos. Vinculum adamo articulus. Vix subnecto bis. Quae bos cervus. Clam arbor torqueo. Acsi vel amicitia. Cum virtus vel. Adsidue claro vado."))
        }
    }
}