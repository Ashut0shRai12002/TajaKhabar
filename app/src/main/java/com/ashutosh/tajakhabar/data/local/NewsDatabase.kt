package com.ashutosh.tajakhabar.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ashutosh.tajakhabar.domain.model.Article

@Database(entities = [Article::class] , version = 3 )
@TypeConverters(NewsTypeConverter::class)
abstract class NewsDatabase : RoomDatabase() {
    abstract val newsDao : NewsDao
}