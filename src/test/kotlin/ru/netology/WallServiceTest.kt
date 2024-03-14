package ru.netology

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class WallServiceTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun wallServise_addCheckIdIncrease() {
        val like1 = Likes(15)
        val post1 = Post("Hello and welcome", like1)
        val result = WallService.add(post1).id
        assertEquals(result, 11357)
        val post2 = Post("Good Buy", like1)
        val result2 = WallService.add(post2).id
        assertEquals(result2, 11358)
    }


    @Test
    fun wallServise_updateCheckTrue() {
        val like1 = Likes(15)
        val post1 = Post("Hello and welcome", like1)
        val post4 = Post("Yes!!", like1, 11357)
        WallService.add(post1)
        val result = WallService.update(post4)
        assertTrue(result)

    }

    @Test
    fun wallServise_updateCheckFalse() {
        val like1 = Likes(15)
        val post1 = Post("Hello and welcome", like1)
        val post4 = Post("Yes!!", like1, 11358)
        WallService.add(post1)
        val result = WallService.update(post4)
        assertFalse(result)

    }


}