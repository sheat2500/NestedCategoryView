package me.lesmtech.nestedcategoryview;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.lesmtech.nestedcategoryview.lib.SimpleViewHolder;

/**
 * @Author te.lin
 * @Since 9/5/16
 */
public class SubCategoryViewHolder extends SimpleViewHolder<Response.Category.SubCategory> {

  @BindView(R.id.title) TextView categoryView;

  public SubCategoryViewHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }

  @Override public boolean invalidate(boolean isSelected) {
    itemView.setBackgroundColor(
        categoryView.getContext()
            .getResources()
            .getColor(isSelected ? R.color.colorAccent : android.R.color.white));
    return true;
  }

  @Override public boolean onClick() {
    return false;
  }

  @Override
  public void update(Response.Category.SubCategory subCategory) {
    categoryView.setText(subCategory.getName());
  }
}
