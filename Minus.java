import java.util.*;
public class Minus {
	private static char newN1[];
	private static char newN2[];
	private static char newN3[];
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Please input a number.");
		String n1=input.next();
		int x=n1.length();
		while(x!=0) {
			newN1 = new char[n1.length()];
			for(int i=0;i<n1.length();i++)newN1[i] = n1.charAt(i);
			x=n1.length();
			for(int i=0;i<n1.length();i++) {
				if(Character.isDigit(newN1[i])) {
					x--;
				}
			}
			if(x!=0) {
				System.out.println("Please change another one,there must be something not belong to numbers.");
				n1=input.next();
			}
		}
		System.out.println("Please input another number.");
		String n2=input.next();
		x=n2.length();
		while(x!=0) {
			newN2 = new char[n2.length()];
			for(int i=0;i<n2.length();i++)newN2[i] = n2.charAt(i);
			x=n2.length();
			for(int i=0;i<n2.length();i++) {
				if(Character.isDigit(newN2[i])) {
					x--;
				}
			}
			if(x!=0) {
				System.out.println("Please change another one,there must be something not belong to numbers.");
				n2=input.next();
			}
		}//Only Integer
		if(n1.length()<n2.length()) {
			String n3=n1;
			n1=n2;
			n2=n3;
		}
		if(n1.length()==n2.length()) {
			for(int i=0;i<n1.length();i++) {
				if(Integer.parseInt(String.valueOf(newN1[i]))>Integer.parseInt(String.valueOf(newN2[i]))) {
					break;
				}
				if(Integer.parseInt(String.valueOf(newN1[i]))<Integer.parseInt(String.valueOf(newN2[i]))) {
					String n3=n1;
					n1=n2;
					n2=n3;
					break;
				}
			}
		}//只有大對小
		newN1 = new char[n1.length()];
		for(int i=0;i<n1.length();i++)newN1[i] = n1.charAt(i);
		newN2 = new char[n2.length()];
		for(int i=0;i<n2.length();i++)newN2[i] = n2.charAt(i);
		x=newN1.length;
		int y=newN2.length;
		newN3=new char[x];
		for(int i=0;i<x;i++) {
			newN3[i]=Integer.toString(Integer.parseInt(String.valueOf(newN1[i]))).charAt(0);
			if(x-i==y) {
				for(int a=0;a<y;a++) {
					if(Integer.parseInt(String.valueOf(newN1[i]))-Integer.parseInt(String.valueOf(newN2[a]))<0) {
						for(int c=i;c>=0;c--) {
							if(Integer.parseInt(String.valueOf(newN3[c-1]))>0) {
								newN3[c-1]=Integer.toString(Integer.parseInt(String.valueOf(newN3[c-1]))-1).charAt(0);
								break;
							}
							else {
								newN3[c-1]="9".charAt(0);
							}
						}
						newN3[i]=Integer.toString(Integer.parseInt(String.valueOf(newN1[i]))-Integer.parseInt(String.valueOf(newN2[a]))+10).charAt(0);
					}//如果減掉之後小於零就向前借
					else {
						newN3[i]=Integer.toString(Integer.parseInt(String.valueOf(newN1[i]))-Integer.parseInt(String.valueOf(newN2[a]))).charAt(0);
					}
					i++;
				}
			}
		}
		for(int i=0;i<x;i++) {
			if(newN3[i]=="-".charAt(0)) {
				newN3[i]="0".charAt(0);
			}
		}//若互減後等於零，它會顯示-，此for只為將此矯正
		for(int i=0;i<x;i++) {
			if(newN3[i]=="0".charAt(0)) {
				newN3[i]=" ".charAt(0);
			}
			else {
				break;
			}
		}//不寫這個會出現00000000123之類的玩意兒
		System.out.println(String.valueOf(newN3));
	}
}
