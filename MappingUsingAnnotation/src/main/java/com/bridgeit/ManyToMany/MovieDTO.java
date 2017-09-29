package com.bridgeit.ManyToMany;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table (name="movie_table")
public class MovieDTO implements Serializable {
	
	@Id
	@GenericGenerator (name="gen",strategy="increment")
	@GeneratedValue (generator="gen")
	private int seNo;
	
	@Column (name="movie_Name")
	private String movieName;
	
	@Column (name="movie_Director")
	private String movieDirector;
	
	@Column (name="movie_Rating")
	private int movieRating;
	
	@ManyToMany (cascade=CascadeType.ALL)
	@JoinColumn (name="movie_actor")
	private Collection<ActorDTO> actor;
	
	public MovieDTO() {
		
	}
	

	public int getSeNo() {
		return seNo;
	}


	public void setSeNo(int seNo) {
		this.seNo = seNo;
	}


	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public int getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(int movieRating) {
		this.movieRating = movieRating;
	}

	public Collection<ActorDTO> getActor() {
		return actor;
	}

	public void setActor(Collection<ActorDTO> actor) {
		this.actor = actor;
	}
	

}
