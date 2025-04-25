package com.jhonny.inventario.dao;


import com.jhonny.inventario.model.Usuario;
import com.jhonny.inventario.util.HibernateUtil;
import org.hibernate.Session;

public class UsuarioDAO {
    /**
     * Busca un usuario por su campo 'usuario'
     */
    public Usuario findByUsername(String username) {
        // 1) Abrimos sesión y arrancamos transacción
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            // 2) Ejecutamos la consulta
            Usuario u = session.createQuery(
                            "FROM Usuario WHERE usuario = :user", Usuario.class)
                    .setParameter("user", username)
                    .uniqueResult();

            // 3) Confirmamos transacción y cerramos
            session.getTransaction().commit();
            return u;
        }
    }
}