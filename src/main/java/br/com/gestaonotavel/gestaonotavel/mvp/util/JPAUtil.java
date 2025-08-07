package br.com.udemyjava.gestao.notavel.mvp.util;

import jakarta.persistence.*;

/**
 *
 * CLASSE DE USO UTILITARIO PARA ABRIR SESSÃO FACOTRY MANAGER
 *
 * @author carol
 */
public class JPAUtil {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("br.com.udemyjava_gestao-notavel-mvp_jar_1.0-SNAPSHOTPU");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }

    public static void close() {
        if (FACTORY != null) {
            FACTORY.close();
        }
    }
}
