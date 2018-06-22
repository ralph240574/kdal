package com.weather.sample.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.weather.android.kdal.app.R
import com.weather.sample.ui.view.SlidingTabLayout
import java.util.*


class SlidingTabsFragment : Fragment() {


    private val mTabs = ArrayList<SamplePagerItem>()

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
    }

    internal class SamplePagerItem(val pos: Int, val title: CharSequence) {

        fun createFragment(pos: Int): Fragment {
            return ContentFragment.newInstance(pos)
        }
    }

    internal inner class SampleFragmentPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(i: Int): Fragment {
            return mTabs[i].createFragment(i)
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

    companion object {

        private val TAG = "Adapter"
    }
}