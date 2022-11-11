package es.deusto.ingenieria.sd.auctions.server.test;

import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.dto.ArticleDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.CategoryDTO;
import es.deusto.ingenieria.sd.auctions.server.remote.RemoteFacade;

public class LocalTest {

	public static void main(String[] args) {		
		RemoteFacade facade = null;
		long token = 0l;
		
		try {
			facade = new RemoteFacade();
			
			//Get Categories
			
					
						
			//Get Articles of a Category
		
			
			//Check currency conversion
			float rateGBP = facade.getGBPRate();
			float rateUSD = facade.getUSDRate();
			
			System.out.println("\t- USD rate = " + rateGBP);
			System.out.println("\t- USD rate = " + rateUSD);
			
			//Make a bid (fails because no login has been done)
			facade.makeBid(0);						
		} catch (Exception e) {			
			System.out.println("\t# Error: " + e.getMessage());
		} 
		
		try {
			//Login
			String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");
			token = facade.login("thomas.e2001@gmail.com", sha1);			
			//Make a bid
			facade.makeBid(token, article.getNumber(), article.getActualPrice()+1);
			//Logout
			facade.logout(token);
			//Get articles again to check if the bid has been registered
			articles = facade.getArticles(category.getName());
			article = articles.get(0); 			
			System.out.println("\t- " + article);
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}

		//Force exit to stop RMI Server
		System.exit(0);
	}
}