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
@Table(name = "film_list")
@NamedQueries({
    @NamedQuery(name = "FilmList.findAll", query = "SELECT f FROM FilmList f"),
    @NamedQuery(name = "FilmList.findByFid", query = "SELECT f FROM FilmList f WHERE f.fid = :fid"),
    @NamedQuery(name = "FilmList.findByTitle", query = "SELECT f FROM FilmList f WHERE f.title = :title"),
    @NamedQuery(name = "FilmList.findByCategory", query = "SELECT f FROM FilmList f WHERE f.category = :category"),
    @NamedQuery(name = "FilmList.findByPrice", query = "SELECT f FROM FilmList f WHERE f.price = :price"),
    @NamedQuery(name = "FilmList.findByLength", query = "SELECT f FROM FilmList f WHERE f.length = :length"),
    @NamedQuery(name = "FilmList.findByRating", query = "SELECT f FROM FilmList f WHERE f.rating = :rating")})
public class FilmList implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Long id;

    @Basic(optional = false)
    @Column(name = "FID")
    private short fid;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "category")
    private String category;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "length")
    private Short length;
    @Column(name = "rating")
    private String rating;
    @Lob
    @Column(name = "actors")
    private String actors;

    public FilmList() {
    }

    public short getFid() {
        return fid;
    }

    public void setFid(short fid) {
        this.fid = fid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Short getLength() {
        return length;
    }

    public void setLength(Short length) {
        this.length = length;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }
    
}
