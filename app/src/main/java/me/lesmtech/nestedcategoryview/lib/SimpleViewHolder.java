package me.lesmtech.nestedcategoryview.lib;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @Author te.lin
 * @Since 9/8/16
 */
public abstract class SimpleViewHolder<T> extends RecyclerView.ViewHolder {

  private boolean isSelected = false;

  public SimpleViewHolder(final View itemView) {
    super(itemView);

    Dispatcher.put(this.getClass().getCanonicalName(), this);

    System.out.println(this.getClass().getCanonicalName() + this.toString());

    itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        if (isSelected()) return;
        isSelected = true;
        SimpleViewHolder.this.onClick();
        invalidate(isSelected());
        Dispatcher.dispatch(SimpleViewHolder.this);
      }
    });
  }

  public boolean isSelected() {
    return isSelected;
  }

  public void setSelected(boolean isSelected) {
    this.isSelected = isSelected;
  }

  public abstract boolean invalidate(boolean isSelected);

  public abstract boolean onClick();

  public abstract void update(T obj);

  public void invalidate(){
    invalidate(isSelected());
  }
}
