package com.tudai.practico2ejemplo.entidades;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
 
@Entity
public class Revision {
	@Id
	@GeneratedValue
	int id;
	@ManyToOne
	Usuario evaluador;
	@ManyToOne
	Trabajo trabajo;
	@Column(nullable = false)
	Calendar fechaRevision;
}
