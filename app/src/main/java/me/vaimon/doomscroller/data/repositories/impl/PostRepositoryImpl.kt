package me.vaimon.doomscroller.data.repositories.impl

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.vaimon.doomscroller.data.models.Post
import me.vaimon.doomscroller.data.repositories.PostRepository

class PostRepositoryImpl: PostRepository {
    override suspend fun getPosts(): List<Post> {
        delay(2000)
        return listOf(Post(1, "Ara crepusculum vespillo suggero alveus atrox.", "Enim similique ventosus. Sponte damnatio auctor. Ipsam vilitas synagoga. Color illum unde. Collum creo et. Uter eos cunabula. Volup tum desolo. Sint veritatis eos. Vinculum adamo articulus. Vix subnecto bis. Quae bos cervus. Clam arbor torqueo. Acsi vel amicitia. Cum virtus vel. Adsidue claro vado."),
            Post(1, "Ara crepusculum vespillo suggero alveus atrox.", "Enim similique ventosus. Sponte damnatio auctor. Ipsam vilitas synagoga. Color illum unde. Collum creo et. Uter eos cunabula. Volup tum desolo. Sint veritatis eos. Vinculum adamo articulus. Vix subnecto bis. Quae bos cervus. Clam arbor torqueo. Acsi vel amicitia. Cum virtus vel. Adsidue claro vado."),
            Post(1, "Ara crepusculum vespillo suggero alveus atrox.", "Enim similique ventosus. Sponte damnatio auctor. Ipsam vilitas synagoga. Color illum unde. Collum creo et. Uter eos cunabula. Volup tum desolo. Sint veritatis eos. Vinculum adamo articulus. Vix subnecto bis. Quae bos cervus. Clam arbor torqueo. Acsi vel amicitia. Cum virtus vel. Adsidue claro vado."),
            Post(1, "Ara crepusculum vespillo suggero alveus atrox.", "Enim similique ventosus. Sponte damnatio auctor. Ipsam vilitas synagoga. Color illum unde. Collum creo et. Uter eos cunabula. Volup tum desolo. Sint veritatis eos. Vinculum adamo articulus. Vix subnecto bis. Quae bos cervus. Clam arbor torqueo. Acsi vel amicitia. Cum virtus vel. Adsidue claro vado."),
            Post(1, "Ara crepusculum vespillo suggero alveus atrox.", "Enim similique ventosus. Sponte damnatio auctor. Ipsam vilitas synagoga. Color illum unde. Collum creo et. Uter eos cunabula. Volup tum desolo. Sint veritatis eos. Vinculum adamo articulus. Vix subnecto bis. Quae bos cervus. Clam arbor torqueo. Acsi vel amicitia. Cum virtus vel. Adsidue claro vado."),
            Post(1, "Ara crepusculum vespillo suggero alveus atrox.", "Enim similique ventosus. Sponte damnatio auctor. Ipsam vilitas synagoga. Color illum unde. Collum creo et. Uter eos cunabula. Volup tum desolo. Sint veritatis eos. Vinculum adamo articulus. Vix subnecto bis. Quae bos cervus. Clam arbor torqueo. Acsi vel amicitia. Cum virtus vel. Adsidue claro vado."))

    }
}