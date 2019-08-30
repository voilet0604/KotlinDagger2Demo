package com.example.kotlindagger2demo.dagger2

import com.example.kotlindagger2demo.ContentFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun injectContentFragment(): ContentFragment
}