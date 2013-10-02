package personnr;

import java.util.ArrayList;
import java.util.Arrays;

public class PersonNr {
	private final int[] kontrollsiffra = {2,1,2,1,2,1,2,1,2};
	
	public PersonNr(String pnr){
		//inmatningskontroller
		if(pnr == null){
			throw new IllegalArgumentException();
		}

		if(pnr.length() != 11) //rätt längd?
			throw new IllegalArgumentException();
		char[] pnrArray = pnr.toCharArray();
		
		if(pnr.charAt(6) != '-' && pnrArray[6] != '+') //mellantecknet rätt?
			throw new IllegalArgumentException();
		
		//Kastar NumberFormatException istället för IllegalArgumentException.
		// Löjligt att ändra från ett exception till ett annat, för det vi gör just nu.
		int year = Integer.parseInt(pnrArray[0]+""+pnrArray[1]);
		int month = Integer.parseInt(pnrArray[2]+""+pnrArray[3]);
		int day = Integer.parseInt(pnrArray[4]+""+pnrArray[5]);
		
		if(year < 0 || year > 99)
			throw new IllegalArgumentException();
		if(month < 0 || month > 12){
			throw new IllegalArgumentException();
		}
		switch(month){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: 
			if(day < 0 || day > 31){
				throw new IllegalArgumentException();
			}
			else{
				break;
			}
		case 4:
		case 6:
		case 9:
		case 11: 
			if(day < 0 || day > 30){
				throw new IllegalArgumentException();
			}
			else{
				break;
			}
		case 2:
			if(year%4==0){ //Vi vet inte om 00 = 1900 eller 2000, men i de flesta fall idag så lär det vara 2000 = skottår = mod4
				if(day < 0 || day > 29){
					throw new IllegalArgumentException();
				}
				else{
					break;
				}
			}
			else if(day < 0 || day > 28){
				throw new IllegalArgumentException();
			}
			else{
				break;
			}
		}
		
		int[] pnrInt = new int[10]; // Stoppa in allt i en int-array
		for(int i=0; i<11;i++){
			if(i==6){}
			else{
				if(i<6){
					pnrInt[i] = pnrArray[i]-48; //char is really int, -48 gives "real" value
				}
				else if(i>6){
					pnrInt[i-1] = pnrArray[i]-48;
				}
			}
		}
		System.out.println(Arrays.toString(pnrInt));
		
		// Det kan som max finnas 12 siffror som kontrollsiffran räknas ut från.
		int[] checkNR = new int[9]; 
		for(int i=0; i<pnrInt.length-1;i++){
			checkNR[i] = pnrInt[i]*kontrollsiffra[i];
		}
		// Måste splitta alla tal som innehåller 2 siffror
		// Addera sedan alla tal, ta bort tio-talet
		// Ta resterande siffra, subtrahera det från 10, kolla som siffran stämmer med kontrollsiffran
		//int[] numbers = new int[12]; // Det här borde vara en LinkedList 
		ArrayList<Integer> digits  = new ArrayList<Integer>();
		
		for(int i=0; i<checkNR.length; i++){
			int num = checkNR[i]; //ctrl+shift+o = import all needed stuff :D Latmask. :P Okej, kör på...
			while(num>0){
				digits.add(0, num%10);
				num=num/10; // Så är det i orginalutförandet.
			}
		}
		// Digits borde nu hålla i alla siffror som vi behöver för att räkna ut resten.
		int sum = 0;
		for(int i=0; i<digits.size(); i++){
			sum += digits.get(i);
		}		
		sum = sum%10;
		sum = 10-sum;
		if(sum==10) //om restsiffran blir 10 så blir kontrollsiffran 0
			sum = 0;
		System.out.println(sum);
		if(sum != pnrInt[9]) {
			throw new IllegalArgumentException();
		}
		
		
		System.out.println(Arrays.toString(checkNR));

	}
	
}
