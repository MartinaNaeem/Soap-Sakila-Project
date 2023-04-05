/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gov.iti.jets.filmslibrary.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author dell
 */
@Entity
@Table(name = "actor_info")
@NamedQueries({
    @NamedQuery(name = "ActorInfo.findAll", query = "SELECT a FROM ActorInfo a"),
    @NamedQuery(name = "ActorInfo.findByActorId", query = "SELECT a FROM ActorInfo a WHERE a.actorId = :actorId"),
    @NamedQuery(name = "ActorInfo.findByFirstName", query = "SELECT a FROM ActorInfo a WHERE a.firstName = :firstName"),
    @NamedQuery(name = "ActorInfo.findByLastName", query = "SELECT a FROM ActorInfo a WHERE a.lastName = :lastName")})
public class ActorInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "actor_id")
    private short actorId;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Lob
    @Column(name = "film_info")
    private String filmInfo;

    public ActorInfo() {
    }

    public short getActorId() {
        return actorId;
    }

    public void setActorId(short actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(String filmInfo) {
        this.filmInfo = filmInfo;
    }
    
}
