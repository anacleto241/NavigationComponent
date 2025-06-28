package br.edu.ifsuldeminas.mch.navigationcomponent.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsuldeminas.mch.navigationcomponent.R; // Corrected import for R
import br.edu.ifsuldeminas.mch.navigationcomponent.model.Product; // Updated package

public class ProductDetailsFragment extends Fragment {

    private ImageView detailsProductImage;
    private TextView detailsProductName;
    private TextView detailsProductDescription;
    private TextView detailsProductPrice;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_product_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        detailsProductImage = view.findViewById(R.id.details_product_image);
        detailsProductName = view.findViewById(R.id.details_product_name);
        detailsProductDescription = view.findViewById(R.id.details_product_description);
        detailsProductPrice = view.findViewById(R.id.details_product_price);

        if (getArguments() != null) {
            int productId = getArguments().getInt("productId", -1);
            if (productId != -1) {
               Product product = findProductById(productId);
                if (product != null) {
                    detailsProductImage.setImageResource(product.getImageResId());
                    detailsProductName.setText(product.getName());
                    detailsProductDescription.setText(product.getDescription());
                    detailsProductPrice.setText(String.format("Preço: R$ %.2f", product.getPrice()));
                }
            }
        }
    }

    private Product findProductById(int id) {
        List<Product> products = createSampleProducts();
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }


    private List<Product> createSampleProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Smartphone X", "Smartphone de última geração com câmera de 108MP e processador ultrarrápido. Perfeito para jogos e multitarefas.", 1500.00, R.drawable.ic_launcher_background));
        products.add(new Product(2, "Fone de Ouvido Bluetooth", "Fone de ouvido sem fio com cancelamento de ruído ativo e 24 horas de bateria.", 250.00, R.drawable.ic_launcher_background));
        products.add(new Product(3, "Smartwatch Lite", "Relógio inteligente com monitor de frequência cardíaca, contador de passos e notificações de smartphone.", 350.00, R.drawable.ic_launcher_background));
        products.add(new Product(4, "Laptop Ultra", "Laptop fino e leve com tela 4K, ideal para produtividade e entretenimento. Processador i7.", 4500.00, R.drawable.ic_launcher_background));
        products.add(new Product(5, "Câmera Digital Pro", "Câmera mirrorless com sensor full-frame e gravação de vídeo em 4K. Ideal para fotógrafos profissionais.", 1200.00, R.drawable.ic_launcher_background));
        return products;
    }
}