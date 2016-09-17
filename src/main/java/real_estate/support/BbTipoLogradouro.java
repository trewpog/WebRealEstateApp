package real_estate.support;

import real_estate.model.dao.HibernateDAO;
import real_estate.model.dao.InterfaceDAO;
import real_estate.model.entities.TypeRegion;
import real_estate.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;

@ManagedBean(name="bbTipoLogradouro")
@RequestScoped
public class BbTipoLogradouro  implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public List<TypeRegion> getTipoLogradouros() {
        Session session = FacesContextUtil.getRequestSession();
        InterfaceDAO<TypeRegion> tipoLogradouroDAO = new HibernateDAO<TypeRegion>(TypeRegion.class, session);
        return tipoLogradouroDAO.getEntities();
    }
}