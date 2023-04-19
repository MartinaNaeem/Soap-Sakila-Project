/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gov.iti.jets.filmslibrary.model;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 *
 * @author dell
 */
@Entity
@Table(name = "sales_by_film_category")
@NamedQueries({
    @NamedQuery(name = "SalesByFilmCategory.findAll", query = "SELECT s FROM SalesByFilmCategory s"),
    @NamedQuery(name = "SalesByFilmCategory.findByCategory", query = "SELECT s FROM SalesByFilmCategory s WHERE s.category = :category"),
    @NamedQuery(name = "SalesByFilmCategory.findByTotalSales", query = "SELECT s FROM SalesByFilmCategory s WHERE s.totalSales = :totalSales")})
public class SalesByFilmCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Long id;

    @Basic(optional = false)
    @Column(name = "category")
    private String category;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_sales")
    private BigDecimal totalSales;

    public SalesByFilmCategory() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }
    
}
