package com.weather.sample.ui

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import com.weather.android.kdal.V3Repo
import com.weather.android.kdal.app.R
import com.weather.sample.DemoApplication
import com.weather.sample.ui.view.SlidingTabLayout
import kotlinx.android.synthetic.main.fragment_sample.*
import java.util.*
import javax.inject.Inject


class SlidingTabsFragment : Fragment(), RadioGroup.OnCheckedChangeListener {


    private val mTabs = ArrayList<SamplePagerItem>()

    val contentFragments: MutableSet<ContentFragment> = mutableSetOf()

    @Inject
    lateinit var v3Repo: V3Repo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mTabs.add(SamplePagerItem(0,
                getString(R.string.tab_current)
        ))
        mTabs.add(SamplePagerItem(1,
                getString(R.string.tab_hourly)
        ))
        mTabs.add(SamplePagerItem(2,
                getString(R.string.tab_daily)))
        ((context as Activity).application as DemoApplication).component.inject(this)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sample, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val mViewPager = view.findViewById<View>(R.id.viewpager) as ViewPager
        mViewPager.adapter = SampleFragmentPagerAdapter(childFragmentManager)
        val mSlidingTabLayout = view.findViewById<View>(R.id.sliding_tabs) as SlidingTabLayout
        mSlidingTabLayout.setViewPager(mViewPager)
        radio_group.setOnCheckedChangeListener(this)
        button.setOnClickListener({ loadData() })
    }

    private fun loadData() {
        contentFragments.forEach({ it.loadWeather() })
    }

    internal class SamplePagerItem(val pos: Int, val title: CharSequence) {

        fun createFragment(pos: Int): Fragment {
            return ContentFragment.newInstance(pos)
        }
    }

    internal inner class SampleFragmentPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(i: Int): Fragment {
            val fragment = mTabs[i].createFragment(i)
            contentFragments.add(fragment as ContentFragment)
            return fragment
        }

        override fun getCount(): Int {
            return mTabs.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mTabs[position].title
        }

        override fun getItemPosition(`object`: Any): Int {
            return super.getItemPosition(`object`)
        }


    }


    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {

        when (checkedId) {
            R.id.offline -> v3Repo.mode = V3Repo.Mode.OFFLINE
            R.id.cache_first -> v3Repo.mode = V3Repo.Mode.CACHE_FIRST
            R.id.cache_and_network -> v3Repo.mode = V3Repo.Mode.CACHE_AND_NETWORK
            R.id.network_first -> v3Repo.mode = V3Repo.Mode.NETWORK_FIRST
            R.id.network_only -> v3Repo.mode = V3Repo.Mode.NETWORK_ONLY
        }
    }

}