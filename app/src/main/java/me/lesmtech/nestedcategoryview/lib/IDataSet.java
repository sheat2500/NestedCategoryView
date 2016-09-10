package me.lesmtech.nestedcategoryview.lib;

/**
 * @Author te.lin
 * @Since 9/5/16
 */
public interface IDataSet<T, H> {

  int getCategorySize();

  int getNestedCategorySize(int position);

  T getCategory(int position);

  H getNestedCategory(int parentPosition, int childPosition);
}
