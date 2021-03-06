package pt.rfsfernandes.custom.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import pt.rfsfernandes.R;
import pt.rfsfernandes.custom.callbacks.ItemListClicked;
import pt.rfsfernandes.custom.utils.UtilsClass;
import pt.rfsfernandes.model.service_responses.PokemonResult;


public class PokemonResultAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  private final int VIEW_TYPE_ITEM = 0;
  private final int VIEW_TYPE_LOADING = 1;
  private final ItemListClicked<PokemonResult> callback;
  private final Context mContext;
  private List<PokemonResult> mPokemonResultList = new ArrayList<>();

  public PokemonResultAdapter(Context context,
                              ItemListClicked<PokemonResult> pokemonResultItemListClicked) {
    this.callback = pokemonResultItemListClicked;
    this.mContext = context;
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    if (viewType == VIEW_TYPE_ITEM) {
      View view = LayoutInflater.from(parent.getContext())
          .inflate(R.layout.pokemon_result_row, parent, false);
      return new PokemonResultViewHolder(view);
    } else {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.loading_row, parent, false);
      return new LoadingViewHolder(view);
    }


  }

  @Override
  public int getItemViewType(int position) {
    return mPokemonResultList.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
  }

  @Override
  public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
    if (holder instanceof PokemonResultViewHolder) {
      populateItemRows((PokemonResultViewHolder) holder, position);
    }

  }

  /**
   * Populates each row with the content of the current item
   *
   * @param holder   Holder used to populate
   * @param position Position of the item
   */
  private void populateItemRows(PokemonResultViewHolder holder, int position) {

    PokemonResult item = mPokemonResultList.get(position);
    holder.mItem = item;
    holder.textViewPokemonName.setText(UtilsClass.toCamelCase(item.getName()));
    holder.mSimpleDraweeView.setImageURI(item.getPokemonImage());
    holder.textViewPokemonNumber.setText(String.valueOf(item.getListPosition()));
    holder.mView.setOnClickListener(e -> {
      callback.onClick(item);
    });

    holder.selectedView.setVisibility(item.isSelected() ? View.VISIBLE : View.GONE);
    holder.imageViewIconPokeball.setImageDrawable(item.isSelected() ?
        ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.open, null) :
        ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.close, null));
  }

  @Override
  public int getItemCount() {
    return mPokemonResultList.size();
  }

  /**
   * Assigns a value to the global List of PokemonResult and notifies the adapter of that change
   *
   * @param pokemonResults New list
   */
  public void refreshList(List<PokemonResult> pokemonResults) {
    this.mPokemonResultList = pokemonResults;
    notifyDataSetChanged();
  }

  public class PokemonResultViewHolder extends RecyclerView.ViewHolder {
    public final View mView;
    public final TextView textViewPokemonName;
    public final SimpleDraweeView mSimpleDraweeView;
    public final TextView textViewPokemonNumber;
    public final View selectedView;
    public final ImageView imageViewIconPokeball;
    public PokemonResult mItem;

    public PokemonResultViewHolder(View view) {
      super(view);
      mView = view;
      textViewPokemonName = view.findViewById(R.id.textViewPokemonName);
      textViewPokemonNumber = view.findViewById(R.id.textViewPokemonNumber);
      selectedView = view.findViewById(R.id.viewSelect);
      mSimpleDraweeView = view.findViewById(R.id.imageViewPokemonList);
      mSimpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(mContext.getResources())
          .setProgressBarImage(new ProgressBarDrawable())
          .build());

      imageViewIconPokeball = view.findViewById(R.id.imageViewIconPokeball);
    }

  }

  private class LoadingViewHolder extends RecyclerView.ViewHolder {

    public final ProgressBar progressBar;

    public LoadingViewHolder(@NonNull View itemView) {
      super(itemView);
      progressBar = itemView.findViewById(R.id.progressBar);

    }
  }

}