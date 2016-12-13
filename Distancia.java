import java.util.Scanner;

public class Distancia {
	
	
	
	public static int calcular(String str1,String str2){
		int distancia;
		str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        int [] custo = new int [str2.length() + 1];
        for (int i = 0; i < custo.length; i++)
            custo[i] = i;
        for (int j = 1; j <= str1.length(); j++) {
            custo[0] = j;
            int distanciaLinha = j - 1;
            for (int i = 1; i <= str2.length(); i++) {
                int custoEmI = Math.min(Math.min(custo[i] + 1, custo[i - 1]), str1.charAt(j - 1) == str2.charAt(i - 1) ? distanciaLinha : distanciaLinha + 1);
                distanciaLinha = custo[i];
                custo[i] = custoEmI;
            }
        }
        distancia =  custo[str2.length()];
		
		return distancia;
	}
	
	 public static void main(String [] args) {
		 
		 String palavra1;
		 String palavra2;
		 Scanner leitor = new Scanner(System.in);  
		 System.out.println("Insira uma palavra: ");
		 palavra1 = leitor.next();
		 System.out.println("Insira otra palavra: ");
		 palavra2 = leitor.next();


	        
		 System.out.println("distancia entre "  + palavra1 +" e "+ palavra2 + " = " + calcular(palavra1,palavra2));
	    }
}

