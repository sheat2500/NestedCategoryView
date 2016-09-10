package me.lesmtech.nestedcategoryview.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author te.lin
 * @Since 9/8/16
 */
public class Dispatcher {

  private static HashMap<String, List<SimpleViewHolder>> sources = new HashMap<>();

  public static void put(String key, SimpleViewHolder target) {
    List<SimpleViewHolder> targets;
    if (sources.get(key) == null) {
      targets = new ArrayList<>();
    } else {
      targets = sources.get(key);
    }
    if (targets.contains(target)) return;
    targets.add(target);
    sources.put(key, targets);
  }

  public static void dispatch(SimpleViewHolder target) {
    for (SimpleViewHolder vh : sources.get(target.getClass().getCanonicalName())) {
      if (vh != target) {
        vh.setSelected(false);
        vh.invalidate();
      }
    }
  }

  public static void clear() {
    sources.clear();
  }

  public static int size() {
    return sources.size();
  }
}
