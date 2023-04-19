/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gov.iti.jets.filmslibrary.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author dell
 */

@Entity
@Table(name = "film_list")
@NamedQueries({
        @NamedQuery(name = "FilmList.findAll", query = "SELECT f FROM FilmList f"),
        @NamedQuery(name = "FilmList.findByFid", query = "SELECT f FROM FilmList f WHERE f.fid = :fid"),
        @NamedQuery(name = "FilmList.findByTitle", query = "SELECT f FROM FilmList f WHERE f.title = :title"),
        @NamedQuery(name = "FilmList.findByCategory", query = "SELECT f FROM FilmList f WHERE f.category = :category"),
        @NamedQuery(name = "FilmList.findByLength", query = "SELECT f FROM FilmList f WHERE f.length = :length"),
        @NamedQuery(name = "FilmList.findByRating", query = "SELECT f FROM FilmList f WHERE f.rating = :rating")})
public class FilmList implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
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

    @Column(name = "length")
    private Short length;
    @Column(name = "rating")
    private String rating;
    @Lob
    @Column(name = "actors")
    private String actors;
    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "language")
    private String language;
    @Column(name = "rental_rate")
    private BigDecimal rentalRate;

    @Column(name = "rental_duration")
    private Byte rentalDuration;

    @Column(name = "inventories_list")
    private String inventories;

    public FilmList(short fid, String title, String description, String category, Short length, String rating, String actors, Integer releaseYear, String language, BigDecimal rentalRate, Byte rentalDuration, String inventories, BigDecimal replacementCost, String specialFeatures, Date lastUpdate) {
        this.fid = fid;
        this.title = title;
        this.description = description;
        this.category = category;
        this.length = length;
        this.rating = rating;
        this.actors = actors;
        this.releaseYear = releaseYear;
        this.language = language;
        this.rentalRate = rentalRate;
        this.rentalDuration = rentalDuration;
        this.inventories = inventories;
        this.replacementCost = replacementCost;
        this.specialFeatures = specialFeatures;
        this.lastUpdate = lastUpdate;
    }

    public String getInventories() {
        return inventories;
    }

    public void setInventories(String inventories) {
        this.inventories = inventories;
    }

    @Basic(optional = false)
    @Column(name = "replacement_cost")
    private BigDecimal replacementCost;
    @Column(name = "special_features")
    private String specialFeatures;
    @Basic(optional = false)
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    public  FilmList() {

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

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Byte getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Byte rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
