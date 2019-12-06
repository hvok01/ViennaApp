package com.example.viennaapp.ui.verEventos;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.viennaapp.R;
import com.example.viennaapp.models.Evento;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;


import java.util.ArrayList;
import java.util.List;

import static com.example.viennaapp.R.style.AppTheme;

public class VerEventosFragment extends Fragment implements EventosTab.OnFragmentInteractionListener {

    private VerEventosViewModel verEventosViewModel;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private Evento miEventos;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_ver_eventos, container, false);

        verEventosViewModel = ViewModelProviders.of(this).get(VerEventosViewModel.class);

        verEventosViewModel.traerEventosByDuenio();

        viewPager = root.findViewById(R.id.vpEventos);
        appBarLayout = root.findViewById(R.id.appBar);

        tabLayout = new TabLayout(getContext());
        tabLayout.setTabTextColors(Color.WHITE,Color.WHITE);

        appBarLayout.addView(tabLayout);

        final ViewPageAdapter vp = new ViewPageAdapter(getChildFragmentManager());

        verEventosViewModel.getLista().observe(this, new Observer<List<Evento>>() {
            @Override
            public void onChanged(List<Evento> eventos) {

                if(eventos != null){

                    for(Evento it: eventos){
                        vp.addFragment(new EventosTab(it),it.getNombre()+"");
                    }

                    viewPager.setAdapter(vp);

                    tabLayout.setupWithViewPager(viewPager);
                }

            }
        });



        return root;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public class ViewPageAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragmentList = new ArrayList<>();
        private List<String> titulosFragment = new ArrayList<>();

        public ViewPageAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            return titulosFragment.get(position);

        }

        public void addFragment(Fragment fragment, String titulo) {
            fragmentList.add(fragment);
            titulosFragment.add(titulo);
        }


    }

}