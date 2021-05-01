import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BruteForce {

	public static void main(String[] args) throws FileNotFoundException {

		StringBuffer bigText = new StringBuffer();
		ArrayList<String> plagiarizedText = new ArrayList<String>();
		
		int value = 2;  //select bigText file: (1)SHERLOCK (2)WarAndPeace
		
		//SHERLOCK text
		if(value == 1) {
			Scanner fin = new Scanner(new File("src/SHERLOCK"));
			//SENTENCE 1 -> sentence in 1st Quarter of text file
			plagiarizedText.add(new String("#Sapraemia#, or septic intoxication, is the name applied to a form of"
					+ "poisoning resulting from the absorption into the blood of the toxic"
					+ "products of pyogenic bacteria.").toLowerCase());
			//SENTENCE 2 -> sentence in 2nd Quarter of text file
			plagiarizedText.add(new String("\"Well, it seems that no one has noticed,\" thought Rostov. And this"
					+ "was true. No one had taken any notice,").toLowerCase());
			//SENTENCE 3 -> sentence in 3rd Quarter of text file
			plagiarizedText.add(new String("The sun shone somewhat to the left"
					+ "and behind him and brightly lit up the enormous panorama which, rising"
					+ "like an amphitheater").toLowerCase());
			//SENTENCE 4 -> short sentence in middle of text file
			plagiarizedText.add(new String("Officers are"
					+ "nothing when they have no powers").toLowerCase());
			//SENTENCE 5 -> long sentence in middle of text file
			plagiarizedText.add(new String("Bonaparte himself, not trusting to his generals, moved with all"
							+ "the Guards to the field of battle, afraid of letting a ready victim"
							+ "escape, and Bagration's four thousand men merrily lighted campfires,"
							+ "dried and warmed themselves, cooked their porridge for the first"
							+ "time for three days, and not one of them knew or imagined what was"
							+ "in store for him").toLowerCase());
			//SENTENCE 6 -> short sentence NOT in text file
			plagiarizedText.add(new String("Second line... have you written it?\" he continued dictating to the clerk. \"The Kiev Grenadiers, Podolian...").toLowerCase());
			//SENTENCE 7 -> long sentence NOT in text file
			plagiarizedText.add(new String("On offering to help the blind man, the man who then stole his car, had not, at that precise moment, "
					+ "had any evil intention, quite the contrary, what he did was nothing more than obey those feelings of generosity "
					+ "and altruism which, as everyone knows, are the two best traits of human nature and to be found in much more hardened"
					+ " criminals than this one, a simple car-thief without any hope of advancing in his profession, exploited by the real owners of this enterprise, "
					+ "for it is they who take advantage of the needs of the poor.").toLowerCase());
			//SENTENCE 8 -> one-word sentence NOT in text file
			plagiarizedText.add(new String("algorithm").toLowerCase());
			//SENTENCE 9 -> first sentence in text file
			plagiarizedText.add(new String("The Project Gutenberg EBook of The Adventures of Sherlock Holmes").toLowerCase());
			//SENTENCE 10 -> last sentence in text file
			plagiarizedText.add(new String("print [ord(c) for c in s]").toLowerCase());
			
			//store text file in bigText (all lower case)
			while(fin.hasNextLine()) {
				bigText.append(fin.nextLine().toLowerCase());
			}
			fin.close();
		}
		
		//WarAndPeace text
		if(value == 2) {
			Scanner fin = new Scanner(new File("src/WarAndPeace"));
			//SENTENCE 1 -> sentence in 1st Quarter of text file
			plagiarizedText.add(new String("Her husband looked at her as if surprised to notice that someone besides"
					+ "Pierre and himself was in the room, and addressed her in a tone of"
					+ "frigid politeness.").toLowerCase());
			//SENTENCE 2 -> sentence in 2nd Quarter of text file
			plagiarizedText.add(new String("“My dear!” exclaimed his mother imploringly, again laying her hand"
					+ "on his arm as if that touch might soothe or rouse him.").toLowerCase());
			//SENTENCE 3 -> sentence in 3rd Quarter of text file
			plagiarizedText.add(new String("“Just look at the master! A regular eagle he is!” loudly remarked"
					+ "the nurse, as she stood in one of the doorways.").toLowerCase());
			//SENTENCE 4 -> short sentence in middle of text file
			plagiarizedText.add(new String("Boris followed her, smiling.").toLowerCase());
			//SENTENCE 5 -> long sentence in middle of text file
			plagiarizedText.add(new String("There she paused and stood listening to the conversation"
					+ "in the drawing room, waiting for Boris to come out. She was already"
					+ "growing impatient, and stamped her foot, ready to cry at his not coming"
					+ "at once, when she heard the young man’s discreet steps approaching"
					+ "neither quickly nor slowly. ").toLowerCase());
			//SENTENCE 6 -> short sentence NOT in text file
			plagiarizedText.add(new String("Second line... have you written it?\" he continued dictating to the clerk. \"The Kiev Grenadiers, Podolian...").toLowerCase());
			//SENTENCE 7 -> long sentence NOT in text file
			plagiarizedText.add(new String("On offering to help the blind man, the man who then stole his car, had not, at that precise moment, "
					+ "had any evil intention, quite the contrary, what he did was nothing more than obey those feelings of generosity "
					+ "and altruism which, as everyone knows, are the two best traits of human nature and to be found in much more hardened"
					+ " criminals than this one, a simple car-thief without any hope of advancing in his profession, exploited by the real owners of this enterprise, "
					+ "for it is they who take advantage of the needs of the poor.").toLowerCase());
			//SENTENCE 8 -> one-word sentence NOT in text file
			plagiarizedText.add(new String("algorithm").toLowerCase());
			//SENTENCE 9 -> first sentence in text file
			plagiarizedText.add(new String("The Project Gutenberg EBook of War and Peace, by Leo Tolstoy").toLowerCase());
			//SENTENCE 10 -> last sentence in text file
			plagiarizedText.add(new String("He looked at Prince Vasili"
					+ "in perplexity, and only later grasped that a stroke was an attack of"
					+ "illness.").toLowerCase());
			
			//store text file in bigText (all lower case)
			while(fin.hasNextLine()) {
				bigText.append(fin.nextLine().toLowerCase());
			}
			fin.close();
		}
		
		/*------------------------ begin application of brute force algorithm for string matching ------------------------*/
		
		int comparisonCounter = 0; //total basic operation counter

		//k -> sentences in plagiarizedText
		for(int k=0;k<plagiarizedText.size();k++) {
			int individualCounter = 0; //basic operation counter for each sentence
			boolean flag = false; //true when match found (i.e. sentence is plagiarized)
			
			//loop through bigText
			for(int i = 0; i < bigText.length() - plagiarizedText.get(k).length() ; i++) {
				comparisonCounter++;
				individualCounter++;
				//check for char at current index in bigText matches first char in sentence
				if(bigText.charAt(i) == plagiarizedText.get(k).charAt(0)) {
					int counter = i+1; //index in bigText
					int j = 1; //second char in sentence

					//loop until end of sentence (i.e. match) or a mismatch
					while(j<plagiarizedText.get(k).length() && bigText.charAt(counter) == plagiarizedText.get(k).charAt(j)) {
						comparisonCounter++;
						individualCounter++;
						//increment index on every character match
						counter++;
						j++;
					}
					comparisonCounter++;
					individualCounter++;

					//reached end of sentence with no mismatch (i.e. match)
					if(j == plagiarizedText.get(k).length()) {
						comparisonCounter--; //if full sentence matches, counter is incremented one extra time
						individualCounter--; //if full sentence matches, counter is incremented one extra time
						flag=true; //match found indicates sentence is plagiarized
						System.out.println("Sentence "+(k+1)+" Plagiarized!");
						System.out.println("Counter = "+ individualCounter+"\n");
						break;
					}
				}
			}//end of search for current sentence
			
			if(!flag) { //no match found in bigText (i.e. sentence not plagiarized)
				System.out.println("Sentence "+(k+1)+" Not Plagiarized!");
				System.out.println("Counter = "+ individualCounter+"\n");
			}
		
		}//end of search for all sentences (i.e. whole plagiarizedText)
		
		System.out.println("\nn = "+bigText.length());
		//Total number of comparisons done for the 10 plagiarizedText sentences
		System.out.println("Counter = "+comparisonCounter);  
	}
}
