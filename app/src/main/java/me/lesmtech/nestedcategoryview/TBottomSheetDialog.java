package me.lesmtech.nestedcategoryview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Author te.lin
 * @Since 9/7/16
 */
public class TBottomSheetDialog extends BottomSheetDialog {

  @BindView(R.id.alpha_rv) protected RecyclerView alphaRv;
  @BindView(R.id.beta_rv) protected RecyclerView betaRv;

  private RecyclerView.Adapter mAlphaAdapter;
  private RecyclerView.Adapter mBetaAdapter;

  public static TBottomSheetDialog newInstance(Context context) {
    return new TBottomSheetDialog(context);
  }

  public TBottomSheetDialog(@NonNull Context context) {
    super(context);
    init();
  }

  private void init() {
    setContentView(R.layout.dialog_view_overlay);
    ButterKnife.bind(this);
    mAlphaAdapter = new TAdapter();
    mBetaAdapter = new TAdapter();
    alphaRv.setAdapter(mAlphaAdapter);
    alphaRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
      @Override public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
      }

      @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        System.out.println("Alpha OnScroll");
      }
    });
    betaRv.setAdapter(mBetaAdapter);
    betaRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
      @Override public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
      }

      @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        System.out.println("Beta OnScroll");
      }
    });
  }

  public class TAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public class TViewHolder extends RecyclerView.ViewHolder {
      public TViewHolder(View itemView) {
        super(itemView);
      }
    }

    @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view =
          LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item, parent, false);
      return new TViewHolder(view);
    }

    @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override public int getItemCount() {
      return 100;
    }
  }
}