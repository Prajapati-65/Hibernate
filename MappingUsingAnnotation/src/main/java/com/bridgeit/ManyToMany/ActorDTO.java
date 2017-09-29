package com.bridgeit.ManyToMany;

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
@Table (name="actor_table")
public class ActorDTO {

	@Id
	@GenericGenerator (name="gen",strategy="increment")
	@GeneratedValue (generator="gen")
	private int seNum;
	
	@Column (name="actor_name")
	private String actorName;
	@Column (name="actor_age")
	private String actorAge;
	@Column (name="noof_movies")
	private int noofMovies;
	
	@ManyToMany (cascade=CascadeType.ALL)
	@JoinColumn (name="actor_movie")
	private Collection<MovieDTO> movie;
	
	public ActorDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getSeNum() {
		return seNum;
	}

	public void setSeNum(int seNum) {
		this.seNum = seNum;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getActorAge() {
		return actorAge;
	}

	public void setActorAge(String actorAge) {
		this.actorAge = actorAge;
	}

	public int getNoofMovies() {
		return noofMovies;
	}

	public void setNoofMovies(int noofMovies) {
		this.noofMovies = noofMovies;
	}

	public Collection<MovieDTO> getMovie() {
		return movie;
	}

	public void setMovie(Collection<MovieDTO> movie) {
		this.movie = movie;
	}
	
	
	
}
