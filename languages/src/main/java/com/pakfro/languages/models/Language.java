package com.pakfro.languages.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
@Table (name="languages")
public class Language {

	@Id //  this represents that primary key be auto generated for each Book created.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
    @Size(min = 3, max = 20)
    private String name;
    
    
	@NotNull
    @Size(min = 3, max = 20)
    private String creator;
    
    
    @NotNull
    @Min(0)
    private Float Currentversion;
    
	
    @Column(updatable=false)  // This annotation means that when you create a thing (Book, Pet, Student), you can't update the created/updated at time stamps after creation. 
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;


	// Bean (aka empty constructor)
	public Language () {
		// empty
		// empty
	}
	
	public Language (String name, String creator, Float version) {
		this.name = name;
		this.creator = creator;
		this.Currentversion = version;
	}


	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date(); // right before object is created, save the date
	}

	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date(); // right before object is updated, save the date.
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Float getCurrentversion() {
		return Currentversion;
	}

	public void setCurrentversion(Float currentversion) {
		Currentversion = currentversion;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	

}

