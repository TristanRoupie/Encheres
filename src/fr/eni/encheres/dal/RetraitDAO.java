package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;


public interface RetraitDAO {
	
	public void addRetrait(Retrait retrait);
	public void updateRetrait(Retrait retrait);
	public void deleteRetrait(Retrait retrait);
	public List<Retrait> selectAllRetrait();
	public Retrait selectRetraitByIdArticle(int noArticle);

}
