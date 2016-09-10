package me.lesmtech.nestedcategoryview.lib;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Author te.lin
 * @Since 9/5/16
 */
public abstract class NestedCategoryViewAdapter extends RecyclerView.Adapter {

  private RecyclerView.Adapter mNestedAdapter;

  private RecyclerView mNestedRecyclerView;

  private IDataSet mDataSet;

  private int mSelectedCategoryPosition = 0;

  public NestedCategoryViewAdapter(IDataSet mDataSet) {
    this.mDataSet = mDataSet;
    this.mNestedAdapter = geneNestedAdapter();
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return onCreateCategoryViewHolder(parent, viewType);
  }

  @Override public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
    onBindCategoryViewHolder(holder, position);
    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        int position = holder.getAdapterPosition();
        if (mSelectedCategoryPosition == position) return;
        mSelectedCategoryPosition = position;
        // view update?
        mNestedAdapter.notifyDataSetChanged();
      }
    });
  }

  public abstract RecyclerView.ViewHolder onCreateCategoryViewHolder(ViewGroup parent,
      int viewType);

  public abstract void onBindCategoryViewHolder(final RecyclerView.ViewHolder holder,
      final int position);

  public abstract RecyclerView.ViewHolder onCreateNestedItemViewHolder(ViewGroup parent,
      int viewType);

  public abstract void onBindNestedItemViewHolder(RecyclerView.ViewHolder holder,
      final int parentPosition, int position);

  private RecyclerView.Adapter geneNestedAdapter() {
    return new RecyclerView.Adapter() {

      @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateNestedItemViewHolder(parent, viewType);
      }

      @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindNestedItemViewHolder(holder, mSelectedCategoryPosition, position);
        ((SimpleViewHolder) holder).invalidate();
      }

      @Override public int getItemCount() {
        return getNestedItemCount(mSelectedCategoryPosition);
      }
    };
  }

  public abstract int getNestedItemCount(int parentPosition);

  public void setNestedRecyclerView(RecyclerView mNestedRecyclerView) {
    this.mNestedRecyclerView = mNestedRecyclerView;
    mNestedRecyclerView.setAdapter(mNestedAdapter);
  }
}
