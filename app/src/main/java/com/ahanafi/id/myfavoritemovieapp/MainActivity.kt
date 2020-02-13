package com.ahanafi.id.myfavoritemovieapp

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ahanafi.id.myfavoritemovieapp.adapters.SectionsPagerAdapter
import com.ahanafi.id.myfavoritemovieapp.fragments.MovieFragment
import com.ahanafi.id.myfavoritemovieapp.fragments.MyFavoriteFragment
import com.ahanafi.id.myfavoritemovieapp.fragments.TvShowFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val sectionsPagerAdapter =
            SectionsPagerAdapter(
                this,
                supportFragmentManager
            )
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val tabs: TabLayout = findViewById(R.id.tabs)

        //Fragment
        val movieFragment: Fragment = MovieFragment()
        val tvShowFragment: Fragment = TvShowFragment()
        val myFavoriteFragment: Fragment = MyFavoriteFragment()

        sectionsPagerAdapter.addFragment(movieFragment)
        sectionsPagerAdapter.addFragment(tvShowFragment)
        sectionsPagerAdapter.addFragment(myFavoriteFragment)

        viewPager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(viewPager)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_change_language) {
            val changeLanguageIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(changeLanguageIntent)
        }

        return super.onOptionsItemSelected(item)
    }
}