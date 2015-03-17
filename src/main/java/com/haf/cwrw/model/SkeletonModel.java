package com.haf.cwrw.model;


import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
 
@Entity
@Table (name="SkeletonModel")
@XmlRootElement(name = "Product")
@XmlAccessorType(XmlAccessType.NONE)
@JsonSerialize(include = Inclusion.NON_NULL)
public class SkeletonModel {
    
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column
    private long id;
    
    @Column(length = 50, nullable = false, unique = true)
    private String name;
    
    @Column(length = 200, nullable = true)
    private String description;
    
    SkeletonModel() {
        // for hibernate.
    }
    
    public SkeletonModel(String name) {
        this.name = name;
    }
    
    public long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
 
    public String getDescription() {
        return description;
    }
 
    @XmlElement(name = "description")
    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name = "id")
	public void setId(long id) {
		this.id = id;
	}

    @XmlElement(name = "name")
	public void setName(String name) {
		this.name = name;
	}
}