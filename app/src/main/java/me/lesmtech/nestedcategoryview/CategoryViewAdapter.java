package me.lesmtech.nestedcategoryview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import me.lesmtech.nestedcategoryview.lib.NestedCategoryViewAdapter;

/**
 * @Author te.lin
 * @Since 9/5/16
 */
public class CategoryViewAdapter extends NestedCategoryViewAdapter {

  private Response mResponse;

  public CategoryViewAdapter(Response mResponse) {
    super(mResponse);
    this.mResponse = mResponse;
  }

  /** Category View **/
  @Override
  public RecyclerView.ViewHolder onCreateCategoryViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.view_category, parent, false);
    CategoryViewHolder vh = new CategoryViewHolder(view);
    return vh;
  }

  @Override
  public void onBindCategoryViewHolder(RecyclerView.ViewHolder holder, int position) {
    ((CategoryViewHolder) holder).update(mResponse.getCategory(position));
  }

  /*** Sub Category View ***/
  @Override
  public RecyclerView.ViewHolder onCreateNestedItemViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.view_sub_category, parent, false);
    SubCategoryViewHolder vh = new SubCategoryViewHolder(view);
    return vh;
  }

  @Override
  public void onBindNestedItemViewHolder(RecyclerView.ViewHolder holder, int parentPosition,
      int position) {
    ((SubCategoryViewHolder) holder).update(mResponse.getNestedCategory(parentPosition, position));
  }

  @Override public int getNestedItemCount(int parentPosition) {
    return mResponse.getNestedCategorySize(parentPosition);
  }

  @Override public int getItemCount() {
    return mResponse.getCategorySize();
  }
}
