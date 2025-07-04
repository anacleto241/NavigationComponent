package br.edu.ifsuldeminas.mch.navigationcomponent.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsuldeminas.mch.navigationcomponent.R;
import br.edu.ifsuldeminas.mch.navigationcomponent.adapter.ProductAdapter;
import br.edu.ifsuldeminas.mch.navigationcomponent.model.Product;

public class ProductGridFragment extends Fragment implements ProductAdapter.OnProductClickListener {

    private RecyclerView productRecyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product_grid, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        productRecyclerView = view.findViewById(R.id.product_recycler_view);
        productRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2)); // 2 colunas no grid
        productList = createSampleProducts();
        productAdapter = new ProductAdapter(productList, this);
        productRecyclerView.setAdapter(productAdapter);
    }

    private List<Product> createSampleProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Smartphone X", "Smartphone de última geração com câmera de 108MP.", 1500.00, R.drawable.ic_launcher_background));
        products.add(new Product(2, "Fone de Ouvido Bluetooth", "Qualidade de som incrível e bateria de longa duração.", 250.00, R.drawable.ic_launcher_background));
        products.add(new Product(3, "Smartwatch Lite", "Monitore sua saúde e receba notificações no pulso.", 350.00, R.drawable.ic_launcher_background));
        products.add(new Product(4, "Laptop Ultra", "Desempenho máximo para trabalho e jogos.", 4500.00, R.drawable.ic_launcher_background));
        products.add(new Product(5, "Câmera Digital Pro", "Capture momentos com qualidade profissional.", 1200.00, R.drawable.ic_launcher_background));

        return products;
    }

    @Override
    public void onProductClick(Product product) {
        NavController navController = Navigation.findNavController(requireView());
        Bundle bundle = new Bundle();
        bundle.putInt("productId", product.getId());
        navController.navigate(R.id.action_productGridFragment_to_productDetailsFragment, bundle);
    }
}