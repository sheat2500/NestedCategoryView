package me.lesmtech.nestedcategoryview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.lesmtech.nestedcategoryview.lib.NestedCategoryView;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.category_view) NestedCategoryView mNestedCategoryView;

  @BindView(R.id.btn_toggle) ToggleButton mToggleButton;

  private CategoryViewAdapter mAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    mAdapter = new CategoryViewAdapter(new Response());
    mNestedCategoryView.setAdapter(mAdapter);
    mToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        //if (b) {
        //  mNestedCategoryView.setOrientation(NestedCategoryView.Orientation.Vertical);
        //  mNestedCategoryView.setLayoutManager(
        //      getLLMWithOrientation(LinearLayoutManager.HORIZONTAL),
        //      getLLMWithOrientation(LinearLayoutManager.HORIZONTAL));
        //} else {
        //  mNestedCategoryView.setOrientation(NestedCategoryView.Orientation.Horizontal);
        //  mNestedCategoryView.setLayoutManager(getLLMWithOrientation(LinearLayoutManager.VERTICAL),
        //      getLLMWithOrientation(LinearLayoutManager.VERTICAL));
        //}
        TBottomSheetDialog.newInstance(MainActivity.this).show();
      }
    });
  }

  private LinearLayoutManager getLLMWithOrientation(int orientation) {
    LinearLayoutManager llm = new LinearLayoutManager(this);
    llm.setOrientation(orientation);
    return llm;
  }
}
