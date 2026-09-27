package org.example.ecommerce.features.image.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.ecommerce.common.BaseAuditEntity;
import org.example.ecommerce.features.product.model.Product;

import java.time.Instant;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_images")
public class ProductImage extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_url",unique = true, nullable = false)
    private String url;

    @Column(name = "is_primary", nullable = false)
    private boolean isPrimary = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnore
    private Product product;

    @Column(name = "sort_order", nullable = false)
    private Integer sortOrder;

}
