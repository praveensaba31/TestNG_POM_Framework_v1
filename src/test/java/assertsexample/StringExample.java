package assertsexample;

public class StringExample {

	
	public static void main(String[] args) {
		
		String aString = "Bala";
		
		System.out.println(aString+"murugan");
		
		System.out.println(aString);
		
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("Bala");
		
		System.out.println(sBuilder.toString());
		
		sBuilder.append("murugan");
		
		System.out.println(sBuilder.toString());
	}
	
	
}
