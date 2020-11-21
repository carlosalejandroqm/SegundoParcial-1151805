package com.quantum.model;

import com.quantum.util.GenericDAO;
import com.quantum.util.Conexion;
import com.quantum.entities.Servicio;

public class ServicioDAO extends Conexion<Servicio> implements GenericDAO<Servicio> {

	public ServicioDAO() {
		super(Servicio.class);
	}

	public static void main(String[] args) {
		ServicioDAO t = new ServicioDAO();
		System.out.println(t.list());
	}
}
