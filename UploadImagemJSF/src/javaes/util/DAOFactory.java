package javaes.util;

import javaes.dados.ImagemDAO;
import javaes.dados.ImagemDAOHibernate;

/**
 *
 * @author javaES
 */
public class DAOFactory 
{
     public static ImagemDAO criarImagemDAO()
    {
        ImagemDAOHibernate imagemDAO                              = new  ImagemDAOHibernate();
        imagemDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return imagemDAO;
    }
      
}
