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
@Table(name = "sales_by_store")
@NamedQueries({
    @NamedQuery(name = "SalesByStore.findAll", query = "SELECT s FROM SalesByStore s"),
    @NamedQuery(name = "SalesByStore.findByStore", query = "SELECT s FROM SalesByStore s WHERE s.store = :store"),
    @NamedQuery(name = "SalesByStore.findByManager", query = "SELECT s FROM SalesByStore s WHERE s.manager = :manager"),
    @NamedQuery(name = "SalesByStore.findByTotalSales", query = "SELECT s FROM SalesByStore s WHERE s.totalSales = :totalSales")})
public class SalesByStore implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Long id;

    @Column(name = "store")
    private String store;
    @Column(name = "manager")
    private String manager;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_sales")
    private BigDecimal totalSales;

    public SalesByStore() {
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }
    
}
