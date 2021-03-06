package gr.aueb.dmst.StopSpread;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
/*
 * authors: Evangelia, Viki, Chrysoula
 */
public class GlobalStatsNew {
	/*
	 * Class about General Information for Covid-19
	 */
	public static void main(String [] args ) {
		boolean contloop = true;
		do {
			/*
			 * Menu is printed till the user chooses option 11 and prints 
			 * a message if the user puts an invalid option
			 */
				System.out.println("Παγκόσμια στατιστικά σύμφωνα με τον Παγκόσμιο Οργανισμό Υγείας.");
				Menus.GlobalStatsMenu();
				int option = Inputs.rangeInt(1, 11);
				boolean ok = true;
				while (ok) {
					/*
					 * Variable ok checks if choice is 11 and exits the global info in this case
					 */
					switch (option) {
					case 1:
						opt("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/question-and-answers-hub/q-a-detail/coronavirus-disease-covid-19");
						Menus.GlobalStatsMenu();
						option = Inputs.rangeInt(1, 11);
						break;
					case 2:
						opt("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/question-and-answers-hub/q-a-detail/coronavirus-disease-covid-19-how-is-it-transmitted");
						Menus.GlobalStatsMenu();
						option = Inputs.rangeInt(1, 11);
						break;
					case 3:
						opt("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/advice-for-public");
						Menus.GlobalStatsMenu();
						option = Inputs.rangeInt(1, 11);
						break;
					case 4:
						opt("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/question-and-answers-hub/q-a-detail/coronavirus-disease-covid-19-risks-and-safety-for-older-people");
						Menus.GlobalStatsMenu();
						option = Inputs.rangeInt(1, 11);
						break;
					case 5:
						opt("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/question-and-answers-hub/q-a-detail/coronavirus-disease-covid-19-adolescents-and-youth");
						Menus.GlobalStatsMenu();
						option = Inputs.rangeInt(1, 11);
						break;
					case 6:
						opt("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/advice-for-public/when-and-how-to-use-masks");
						Menus.GlobalStatsMenu();
						option = Inputs.rangeInt(1, 11);
						break;
					case 7:
						opt("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/question-and-answers-hub/q-a-detail/q-a-children-and-masks-related-to-covid-19");
						Menus.GlobalStatsMenu();
						option = Inputs.rangeInt(1, 11);
						break;
					case 8:
						opt("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/question-and-answers-hub/q-a-detail/coronavirus-disease-covid-19-health-and-safety-in-the-workplace");
						Menus.GlobalStatsMenu();
						option = Inputs.rangeInt(1, 11);
						break;
					case 9:
						opt("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/global-research-on-novel-coronavirus-2019-ncov");
						Menus.GlobalStatsMenu();
						option = Inputs.rangeInt(1, 11);
						break;
					case 10:
						opt("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/covid-19-vaccines");
						Menus.GlobalStatsMenu();
						option = Inputs.rangeInt(1, 11);
						break;
					case 11:
						ok = false;
						break;			
					}
				contloop = false;
				}
		} while (contloop);
		/*
		 * Breaks the loop
		 */
	}
	/*
	 * URL method which opens website
	 */
	public static void opt(String url) {
		try {
			java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
		} catch (IOException ex) {
			Logger.getLogger(Url.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
