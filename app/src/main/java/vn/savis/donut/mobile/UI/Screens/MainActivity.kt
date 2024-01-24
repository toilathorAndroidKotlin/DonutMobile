package vn.savis.donut.mobile.UI.Screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import vn.savis.donut.mobile.R
import vn.savis.donut.mobile.UI.Screens.ui.AccountFragment
import vn.savis.donut.mobile.UI.Screens.ui.HomeFragment
import vn.savis.donut.mobile.UI.Screens.ui.OrdersFragment
import vn.savis.donut.mobile.UI.Screens.ui.RewardsFragment
import vn.savis.donut.mobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Remove color default bottom navigation bar
        binding.bottomNavigation.itemIconTintList = null
        replaceFragment(HomeFragment())
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.page_home -> replaceFragment(HomeFragment())
                R.id.page_orders -> replaceFragment(OrdersFragment())
                R.id.page_rewards -> replaceFragment(RewardsFragment())
                R.id.page_account -> replaceFragment(AccountFragment())
                else -> {

                }
            }

            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_container,fragment)
        fragmentTransaction.commit()
    }
}