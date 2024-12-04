package com.example.testingtesting123

import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }


    // TODO 1: Write a test to ensure items can be added to the collection
    @Test
    fun addAnItem() {
        val testItem = Item("test")
        collection.addItem(testItem)
        assert(collection.size() == 1) {"One item added"}
    }

    // TODO 2: Write a test to ensure that only unique items can be added to the collection
    // Uniqueness is determined by the Item.name property, which is set via the constructor
    @Test
    fun addUniqueItem() {
        val testItem1 = Item("testItem1")
        val testItem2 = Item("testItem1")
        val testItem3 = Item("testItem2")

        collection.addItem(testItem1)
        collection.addItem(testItem2)
        collection.addItem(testItem3)

        assertEquals("The collection should contain just unique items", 2, collection.size())
        assertEquals("First item should be 'testItem1'", "testItem1", collection.get(0).name)
        assertEquals("Second item should be 'testItem2'", "testItem2", collection.get(1).name)
    }

    // Test Driven Development (TDD) test - complete specified function so that this test passes
    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }
}