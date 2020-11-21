package com.quantum.model;

import com.quantum.util.GenericDAO;
import com.quantum.util.Conexion;
import com.quantum.entities.Tienda;

public class TiendaDAO extends Conexion<Tienda> implements GenericDAO<Tienda> {

	public TiendaDAO() {
		super(Tienda.class);
	}

	public static void main(String[] args) {
		TiendaDAO t = new TiendaDAO();
		System.out.println(t.list());
	}
}
