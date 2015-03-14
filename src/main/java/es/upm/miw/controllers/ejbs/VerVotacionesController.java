package es.upm.miw.controllers.ejbs;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.controllers.IVerVotacionesController;
import es.upm.miw.models.daos.DaoFactory;
import es.upm.miw.models.daos.ITemaDao;
import es.upm.miw.models.daos.IVotacionDao;
import es.upm.miw.models.entities.Tema;
import es.upm.miw.models.utils.TemaValoracionMedia;
import es.upm.miw.models.utils.ValoracionMedia;

public class VerVotacionesController extends ControllerEjb implements IVerVotacionesController {

    @Override
    public List<TemaValoracionMedia> obtenerValoracionesMediaPorTema() {
        IVotacionDao votacionDao = DaoFactory.getFactory().getVotacionDao();
        ITemaDao temaDao = DaoFactory.getFactory().getTemaDao();
        List<Tema> listTemas = temaDao.findAll();
        List<TemaValoracionMedia> listTemaValoracionMedias = new ArrayList<TemaValoracionMedia>();
        for (Tema tmpTema : listTemas) {
            List<ValoracionMedia> valoracionMedia = votacionDao
                    .valoracionMediaByNivelEstudio(tmpTema);
            int numeroVotos = votacionDao.numeroVotos(tmpTema);
            TemaValoracionMedia tmp = new TemaValoracionMedia();
            tmp.setTema(tmpTema);
            tmp.setValoracionMedia(valoracionMedia);
            tmp.setNumeroVotos(numeroVotos);
            listTemaValoracionMedias.add(tmp);
        }
        return listTemaValoracionMedias;
    }
}
