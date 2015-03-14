package es.upm.miw.controllers;

import java.util.List;

import es.upm.miw.models.utils.TemaValoracionMedia;

public interface IVerVotacionesController {

    public List<TemaValoracionMedia> obtenerValoracionesMediaPorTema();

}
