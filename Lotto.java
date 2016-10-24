import java.util.Random;
import java.util.Scanner;
public class Lotto {

	public static void main(String[] args) {
		
		//1 отримати введення від користувача
		String[] chyslaVidKorystuvacha = OtrymatyVvedennyaVidKorystuvacha();
		
		int iKilkistSpivpadin = 0;
		int iKilkistRozigrashiv=0;
		
		while(iKilkistSpivpadin!=6)
		{
			iKilkistRozigrashiv++;
			
			// krok 2 - провести розіграш (вибрати 6 випадкових чисел)
			int[] tsejRozigrash = ProvestyRozigrash();
			
			// krok 3 - перевірити числа від користувача на співпадіння з виграшними
			iKilkistSpivpadin =PerevirytyRezultat(chyslaVidKorystuvacha, tsejRozigrash);
			
			if (iKilkistSpivpadin>4)
			{
				// 4 вивести результат
				String vsiChyslaRozigrashu = KonvertyvatyMasyvVTekst(tsejRozigrash);			
				System.out.println("У "+iKilkistRozigrashiv+" розіграші співпало ("+ vsiChyslaRozigrashu +"): " + iKilkistSpivpadin);		
			}
		}
			
	}
	/**
	 * цей метод отримує введення чисел від користувача
	 * @return масив чисел типу String
	 */
	public static String[] OtrymatyVvedennyaVidKorystuvacha()
	{
		// krok 1 - отримати введення від користувача
		System.out.println("Введіть 6 чисел через кому (від 1 до 54): ");
		Scanner scan = new Scanner(System.in);
		String chysla = scan.nextLine();
		scan.close(); // закрити Сканер і очистити його з пам'яті
		String[] strMasyvVvedenyhChysel = chysla.split(",");
		
		return strMasyvVvedenyhChysel;
	}
	
	public static int[] ProvestyRozigrash()
	{
		int[] tsejRozigrash = new int[6]; 
		Random r = new Random();		  
		int iChysloRozigrashu = 0;
		while (iChysloRozigrashu!=6)
		{
			boolean chysloVzheIsnuje = false;
			int tseChyslo = r.nextInt(54)+1;			
			for (int isnujucheChyslo: tsejRozigrash)
			{
				if (isnujucheChyslo==tseChyslo)
				{
					chysloVzheIsnuje = true;
					break;
				}
			}
			if (chysloVzheIsnuje!=true)
			{
				tsejRozigrash[iChysloRozigrashu++] = tseChyslo;
			}
		}
		return tsejRozigrash;
	}
	
	public static int PerevirytyRezultat(String[] strMasyvVvedenyhChysel, int[] tsejRozigrash)
	{
		// strMasyvVvedenyhChysel: {"1","24","17","45","11","7"}
		// tsejRozigrash: {5, 35, 27, 11, 7, 1}
		int iKilkistSpivpadin = 0;
		for (int k=0; k<strMasyvVvedenyhChysel.length; k++)
		{
			int chyslo = Integer.parseInt(strMasyvVvedenyhChysel[k]);
			for (int tseVygrashneChyslo: tsejRozigrash)
			{
				if (chyslo==tseVygrashneChyslo)
				{
					iKilkistSpivpadin++;
				}
			}
		}
		return iKilkistSpivpadin;
	}
	
	public static String KonvertyvatyMasyvVTekst(int[] chysla)
	{
		String vsiChyslaRozigrashu = "";
		for (int Chyslo: chysla)
		{
			vsiChyslaRozigrashu = vsiChyslaRozigrashu+ Chyslo + " ";
		}
		return vsiChyslaRozigrashu;
	}
}