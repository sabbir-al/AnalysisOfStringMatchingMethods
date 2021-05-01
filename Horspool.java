import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Horspool {
	
	//ShiftCell is a class defined at the bottom (includes character and integer shift value)
	public static void makeShiftTable(ArrayList<ShiftCell> ShiftTable,StringBuffer bigText, String plagiarizedText) {
		ShiftTable.clear();
		char letter = ' '; //first character of ASCII table
		int counter; 
		boolean check = false; //true when character added to shift table
		
		//shift table includes 94 ASCII characters
		for(int i=0;i<94;i++) {
			check = false;
			counter = 1;  //initial shift value for each character
			//compute shift value for each character by comparing to plagiarizedText (from end)
			for(int j=plagiarizedText.length() - 2; j>=0; j--) {
				if((char)(letter+i) != plagiarizedText.charAt(j))
					counter++;
				else
				{
					ShiftTable.add(new ShiftCell((char)(letter+i), counter));
					check=true; //character which is present in the pattern added to shift table
					break;
				}
			}
			if(!check) { //character which is not present in the pattern added to shift table
				ShiftTable.add(new ShiftCell((char)(letter+i), counter));
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		StringBuffer bigText = new StringBuffer();
		ArrayList<ShiftCell> ShiftTable = new ArrayList<ShiftCell>();
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
		
		/*------------------------- begin application of Horspool algorithm for string matching -------------------------*/

		int comparisonCounter = 0; //total basic operation counter
		int counter = 0;

		//m -> sentences in plagiarizedText
		for(int m=0;m<plagiarizedText.size();m++) {
			//create shift table for given pattern (a sentence in plagiarizedText)
			makeShiftTable(ShiftTable,bigText,plagiarizedText.get(m));
			
			int individualCounter=0; //basic operation counter for each sentence
			boolean foundFlag=false; //true when match found (i.e. sentence is plagiarized)
			
			//start string matching from last character in sentence
			int i = plagiarizedText.get(m).length()-1; //current index in bigText (start at index of last char in sentence)
			while(i < bigText.length()) {
				comparisonCounter++;
				individualCounter++;
				//check for mismatch between char at current index in bigText and last char in sentence
				if(bigText.charAt(i) != plagiarizedText.get(m).charAt(plagiarizedText.get(m).length()-1)) {					
					boolean flag = false;
					//obtain shift value from shift table
					for(int j = 0; j<ShiftTable.size(); j++) {
						if(bigText.charAt(i) == ShiftTable.get(j).c) {
							i+=ShiftTable.get(j).a; //shift/realign pattern
							flag = true;
							break;
						}	
					}
					if(!flag) { //if char not found in shift table, shift by pattern size
						i+=plagiarizedText.get(m).length();
					}
				}
				
				//char at current index in bigText matches last char in sentence
				else { //check rest of sentence for match
					counter = i-1; //index in bigText
					int j = plagiarizedText.get(m).length()-2; //second last char in sentence (first char already compared in first if stmnt)
					//loop until first char of sentence (i.e. match) or a mismatch
					while(j>=0 && bigText.charAt(counter) == plagiarizedText.get(m).charAt(j)) {
						comparisonCounter++;
						individualCounter++;
						//move index from right to left on every character match
						counter--; 
						j--;
					}
					comparisonCounter++;
					individualCounter++;
					
					if(j < 0) {  //reached first char of sentence with no mismatch (i.e. match)
						comparisonCounter--; //if full sentence matches, counter is incremented one extra time
						individualCounter--; //if full sentence matches, counter is incremented one extra time
						foundFlag = true; //match found indicates sentence is plagiarized
						System.out.println("Sentence "+(m+1)+" Plagiarized!");
						System.out.println("Counter = "+ individualCounter+"\n");
						break;
					}
					
					else { //mismatch occurred 
						boolean flag = false;
						//obtain shift value from shift table
						for(int k = 0; k<ShiftTable.size(); k++)
							if(bigText.charAt(i) == ShiftTable.get(k).c) {
								i+=ShiftTable.get(k).a; //shift/realign pattern
								flag = true;
								break;
							}				
						//if char not found in shift table, shift by pattern size
						if(!flag) { i+=plagiarizedText.get(m).length(); }
					}
				}
			}//end of search for current sentence
			
			if(!foundFlag) { //no match found in bigText (i.e. sentence not plagiarized)
				System.out.println("Sentence "+(m+1)+" Not Plagiarized!");
				System.out.println("Counter = "+ individualCounter+"\n");
			}
			
		}//end of search for all sentences (i.e. whole plagiarizedText)
		
		System.out.println("\nn = "+bigText.length());
		//Total number of comparisons done for the 10 plagiarizedText sentences
		System.out.println("Counter = "+comparisonCounter);
	}
}

//shift table is an array of ShiftCells
class ShiftCell {
	char c;
	int a;
	
	public ShiftCell(char c, int a) {
		this.c = c;
		this.a = a;
	}
}