package org.example.ecommerce.views;


import jakarta.persistence.Id;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import java.math.BigDecimal;

@Immutable
@Subselect(value = "SELECT i FROM ")
@Synchronize({"Products", "Category"})
public class ProductSummary {

    @Id
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String category;

    //getters methods
    /*
    * To use in jpa define the JPA repo with data as ProductSummary and type of id
    * This class is application level view
    * */
}
