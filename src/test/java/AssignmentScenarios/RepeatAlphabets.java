package AssignmentScenarios;

public class RepeatAlphabets {

	public static void main(String[] args) {
		String sh="a1b2c3";  //o/p: abbccc
		char[] s=sh.toCharArray();
		char temp;
		char alphatemp;

		for(char i=0;i<=s.length;i++){
		alphatemp=0;
		temp=(Character) null;
		  if(s[i]%2==0){
		     alphatemp=s[i];}
		    if(s[i]%2==1){
		      temp=s[i];

		for(int j=0;j<temp;j++){
		 System.out.print(alphatemp); }
		}
		}

	}

}
