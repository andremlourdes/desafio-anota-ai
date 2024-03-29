package com.andrelourdes.desafioanotaai.domain.product;

import com.andrelourdes.desafioanotaai.domain.category.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.function.Consumer;

@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product implements Consumer<Category> {
    @Id
    private String id;
    private String title;
    private String description;
    private String ownerId;
    private Integer price;
    private Category category;

public Product(ProductDTO data){
    this.title = data.title();
    this.description = data.description();
    this.ownerId = data.ownerId();;
}

    @Override
    public void accept(Category category) {

    }
}
