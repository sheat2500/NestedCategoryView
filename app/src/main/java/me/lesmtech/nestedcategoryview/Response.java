package me.lesmtech.nestedcategoryview;

import java.util.ArrayList;
import java.util.List;
import me.lesmtech.nestedcategoryview.lib.IDataSet;

/**
 * @Author te.lin
 * @Since 9/5/16
 */
public class Response implements IDataSet<Response.Category, Response.Category.SubCategory> {

  List<Category> mCategories;

  public Response() {
    // test
    mCategories = new ArrayList<>();
    for (int i = 0; i < 30; i++) {
      Category shop = new Category();
      mCategories.add(shop);
    }
  }

  @Override public int getCategorySize() {
    return mCategories.size();
  }

  @Override public int getNestedCategorySize(int parentPosition) {
    return mCategories.get(parentPosition).getSubCategories().size();
  }

  public class Category {

    private String name;

    private List<SubCategory> mSubCategories;

    public Category() {

      // test
      mSubCategories = new ArrayList<>();
      name = "category" + Math.random();
      for (int i = 0; i < 30; i++) {
        SubCategory subCategory = new SubCategory();
        mSubCategories.add(subCategory);
      }
    }

    public String getName() {
      return name;
    }

    public List<SubCategory> getSubCategories() {
      return mSubCategories;
    }

    public class SubCategory {

      private String name;

      public SubCategory() {
        name = "subCategory" + Math.random();
      }

      public String getName() {
        return name;
      }
    }
  }

  @Override
  public Category getCategory(int position) {
    return mCategories.get(position);
  }

  @Override
  public Category.SubCategory getNestedCategory(int parentPosition, int childPosition) {
    return mCategories.get(parentPosition).getSubCategories().get(childPosition);
  }

  public List<Category> getCategories() {
    return mCategories;
  }
}
