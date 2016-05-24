
public class CustomerParser {
	
	
	public static Customer parseStringToCustomer(String lineToParse){
		
		String[] tokens = new String[8];
		tokens = lineToParse.split("/");
		Customer custurd = null;

		if(tokens[0].equalsIgnoreCase("NonMember")){
			custurd = new NonMemberCustomer(tokens[1],tokens[2],Double.parseDouble(tokens[3]),Integer.parseInt(tokens[4]),Integer.parseInt(tokens[5]),Integer.parseInt(tokens[6]),Double.parseDouble(tokens[7]));
		}
		else if(tokens[0].equalsIgnoreCase("Member")){
			custurd = new MemberCustomer(tokens[1],tokens[2],Double.parseDouble(tokens[3]),Integer.parseInt(tokens[4]),Integer.parseInt(tokens[5]),Integer.parseInt(tokens[6]),Integer.parseInt(tokens[7]));
		}
		return custurd;
	}
}
