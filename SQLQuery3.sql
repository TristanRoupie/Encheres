select * from ARTICLES_VENDUS where nom_article like'%seche%' and utilisateur_no_utilisateur != 1 AND  GETDATE() < date_fin_encheres AND  GETDATE() < date_debut_encheres

