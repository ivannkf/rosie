package com.rosie.view.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import com.rosie.view.activity.BaseActivity;
import com.rosie.view.presenter.Presenter;
import java.util.ArrayList;
import java.util.List;

/**
 * Base fragment which performs injection using the activity object graph of its parent.
 */
public abstract class BaseFragment extends Fragment {

  List<Presenter> presenters = new ArrayList<Presenter>();

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    ((BaseActivity) this.getActivity()).inject(this);
  }

  @Override public void onAttach(Activity activity) {
    super.onAttach(activity);
    injectDependencies();
  }

  protected void injectDependencies(){
    ((BaseActivity)getActivity()).inject(this);
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    //ButterKnife.inject(this, view);
  }

  @Override public void onResume() {
    super.onResume();
    for (Presenter presenter : presenters) {
      presenter.enableBus();
    }
  }

  @Override public void onPause() {
    super.onPause();

    for (Presenter presenter : presenters) {
      presenter.disableBus();
    }
  }

  public void registerPresenter(Presenter presenter) {
    if (!presenters.contains(presenter)) {
      presenters.add(presenter);
    }
    presenter.enableBus();
  }
}
