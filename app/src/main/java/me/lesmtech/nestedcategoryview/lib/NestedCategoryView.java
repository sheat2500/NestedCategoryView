package me.lesmtech.nestedcategoryview.lib;

import android.content.Context;
import android.support.percent.PercentFrameLayout;
import android.support.percent.PercentLayoutHelper;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.lesmtech.nestedcategoryview.R;

/**
 * @Author te.lin
 * @Since 9/5/16
 */
public class NestedCategoryView extends PercentFrameLayout {

  private float alpha = 0.3f;
  private float beta = 0.7f;

  @BindView(R.id.category_recycler_view) RecyclerView mCategoryRecyclerView;
  @BindView(R.id.nested_category_recycler_view) RecyclerView mNestedCategoryRecyclerView;

  public NestedCategoryView(Context context) {
    this(context, null);
  }

  public NestedCategoryView(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public NestedCategoryView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context);
  }

  private void init(Context context) {
    LayoutInflater.from(context).inflate(R.layout.view_nested_category, this, true);
    ButterKnife.bind(this);
  }

  public void setAdapter(NestedCategoryViewAdapter adapter) {
    adapter.setNestedRecyclerView(mNestedCategoryRecyclerView);
    mCategoryRecyclerView.setAdapter(adapter);
  }

  /**
   * By default 3 : 7
   *
   * @param alpha left or top percent (LLM)
   * @param beta right or bottom percent (GLM)
   */
  public void setViewPercent(float alpha, float beta) {
    this.alpha = alpha;
    this.beta = beta;
  }

  public void setOrientation(Orientation o) {
    boolean ott = o == Orientation.Horizontal;
    LayoutParams lp = (PercentFrameLayout.LayoutParams) mCategoryRecyclerView.getLayoutParams();
    PercentLayoutHelper.PercentLayoutInfo info = lp.getPercentLayoutInfo();
    info.widthPercent = ott ? alpha : 1;
    info.heightPercent = ott ? 1 : alpha;
    mCategoryRecyclerView.requestLayout();

    lp = (PercentFrameLayout.LayoutParams) mNestedCategoryRecyclerView.getLayoutParams();
    info = lp.getPercentLayoutInfo();
    info.widthPercent = ott ? beta : 1;
    info.heightPercent = ott ? 1 : beta;
    info.topMarginPercent = ott ? 0 : alpha;
    info.leftMarginPercent = ott ? alpha : 0;
    mNestedCategoryRecyclerView.requestLayout();
  }

  /**
   * By default, both rv are managed by LLM
   * Customized LLM is allowed.
   */
  public void setLayoutManager(RecyclerView.LayoutManager mAlphaManager,
      RecyclerView.LayoutManager mBetaManager) {
    mCategoryRecyclerView.setLayoutManager(mAlphaManager);
    mNestedCategoryRecyclerView.setLayoutManager(mBetaManager);
  }

  public enum Orientation {
    Horizontal,
    Vertical
  }

  public RecyclerView getCategoryRecyclerView() {
    return mCategoryRecyclerView;
  }

  public RecyclerView getNestedCategoryRecyclerView() {
    return mNestedCategoryRecyclerView;
  }
}
