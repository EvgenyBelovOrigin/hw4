package ru.netology

data class Post(
    val text: String,
    val id: Int = 0,
    val likes: Likes? = null,
    val ownerId: Int? = 0,
    val fromId: Int? = 0,
    val createdBy: Int? = 0,
    val date: Int = 1710410475,
    val friendOnly: Boolean = false,
    val canDelete: Boolean = false,
    val attachments: Array<Attachment>? = null
)


data class Likes(
    val count: Int,
    val userLikes: Boolean = true,
    val canLike: Boolean = true,
    val canPublish: Boolean = true


)


object WallService {
    private var id = 11357

    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post.copy(id = id, likes = post.likes?.copy())
        id++
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index) in posts.withIndex()) {
            if (posts[index].id == post.id) {
                posts[index] = post.copy()
                return true
            }
        }
        return false
    }


    fun clear() {
        posts = emptyArray()
        id = 11357
    }

    //todo delete
    fun printPosts() {
        for (post in posts) {
            print(post)
            println()
        }
        println()
    }

}

fun main() {
//    val post = Post(
//        "qqw",
//        15,
//        attachments = arrayOf(
//            PhotoAttachment(Photo(15, "photo", arrayOf(Photo.PhotoSizesArray(" ", " ", 15, 25)))),
//            NoteAttachment(Note(15, 25))
//        )
//    )
//    WallService.add(
//        Post(
//            "qqw",
//            15,
//            attachments = arrayOf(
//                PhotoAttachment(Photo(15, "photo", arrayOf(Photo.PhotoSizesArray(" ", " ", 15, 25)))),
//                NoteAttachment(Note(15, 25))
//            )
//        )
//    )
    val post = Post(
        "qqw",
        15,
        attachments = arrayOf(
            PhotoAttachment(Photo(15, "photo", arrayOf(Photo.PhotoSizesArray(" ", " ", 15, 25)))),
            NoteAttachment(Note(15, 25))
        )
    )
    println(post.attachments?.get(1))
    val attachment = post.attachments?.get(0)
    println(
        when (attachment) {
            is PhotoAttachment -> "photo ${attachment.photo} "
            is NoteAttachment -> "note ${attachment.note}"
            else -> "nothing"
        }
    )


}