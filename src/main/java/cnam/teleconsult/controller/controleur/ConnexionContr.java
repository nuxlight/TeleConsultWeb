package cnam.teleconsult.controller.controleur;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cnam.teleconsult.modele.bean.Dmpcpersonnelsante;
import cnam.teleconsult.modele.bean.Dmpcstructuresante;
import cnam.teleconsult.modele.dao.DmpcpersonnelsanteDAO;
import cnam.teleconsult.modele.dao.DmpcstructuresanteDAO;

@Controller
@Scope("session")
public class ConnexionContr {
	

	@Autowired
    private DmpcstructuresanteDAO dmpcstructuresanteDAO;
	@Autowired
    private DmpcpersonnelsanteDAO dmpcpersonnelsanteDAO;
	
	
	/**
	 * 
	 * Chargement de l'interface de connexion
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/connexion")
	public ModelAndView identification(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Map<String, Object> param = new HashMap<>();
		param.put("title", "Connexion");
		param.put("titrePage", "Connexion");
		ModelAndView mv = new ModelAndView("connexion", param);
		return mv;
	}
	

	/**
	 * 
	 * Servlet d'identification
	 * Le processus essaye de connect� un hopital avec les identifiants/motdepasse
	 * s'il �choue il teste avec un r�f�rent.
	 * 
	 * @param request
	 * @param response
	 * @param nom
	 * @param motDePasse
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/controle_identification")
	public ModelAndView controleIdentification(HttpServletRequest request,
			HttpServletResponse response, @RequestParam String nom, @RequestParam String motDePasse) throws Exception {
		
		System.out.println("login    = " + nom);	
		System.out.println("password = " + motDePasse);	

		Map<String, Object> param = new HashMap<>();
		
		//
		Dmpcstructuresante hopital 	= null;
		Dmpcpersonnelsante referent = null;
		
		// On contr�le l'int�grit� du formulaire
		if(nom == null || motDePasse == null
				|| "".equals(nom) || "".equals(motDePasse)){

			param.put("erreurIdent", "Les identifiant/mot de passe sont obligatoires.");
			
		}else{
			
			hopital = dmpcstructuresanteDAO.getByPassword(nom, motDePasse);
			
			/* Si l'hopital est null c'est peut-�tre un r�f�rent */
			if(hopital == null){
				
				referent = dmpcpersonnelsanteDAO.getByPassword(nom, motDePasse);
				

				/* L� c'est une erreur de connexion */
				if(referent == null){

					param.put("erreurIdent", "Les identifiant/mot de passe ne correspondent � aucun utilisateur.");

					/* On a trouv� un r�f�rent, on l'ajoute en session */
				}else{

					param.put("referent", referent);
				}
				
				
			/* On a trouv� un h�pital, on l'ajoute en session */
			}else{

				param.put("hopital", hopital);
			}
			
			
		}
		
	
		param.put("title", "Accueil");
		param.put("titrePage", "TeleConsult");

		ModelAndView mv = new ModelAndView("accueil");
		
		if(param.containsKey("erreurIdent")){

			mv = new ModelAndView("connexion");
		}
		
		mv.addAllObjects(param);
		return mv;
	}
	
}
