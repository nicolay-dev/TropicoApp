package com.examples.dmozo.cardview.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.examples.dmozo.cardview.fragments.FragmentPrint;
import com.examples.dmozo.cardview.fragments.FragmentProducts;


public class ViewpagerAdapter extends FragmentPagerAdapter {


    public ViewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return PlaceholderFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 2;
    }

    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragment newInstance(int sectionNumber) {
            Fragment fragment = null;
            switch (sectionNumber) {
                case 0:
                    fragment = new FragmentProducts();
                    break;
                case 1:
                    fragment = new FragmentPrint();
                    break;
            }
            return fragment;
        }

    }

}


