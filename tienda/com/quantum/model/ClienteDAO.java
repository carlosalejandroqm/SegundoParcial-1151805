package com.quantum.model;

import com.quantum.util.GenericDAO;
import com.quantum.util.Conexion;
import com.quantum.entities.Cliente;

public class ClienteDAO extends Conexion<Cliente> implements GenericDAO<Cliente> {

	public ClienteDAO() {
		super(Cliente.class);
	}

	public static void main(String[] args) {
		ClienteDAO c = new ClienteDAO();
		System.out.println(c.list());
	}
}
