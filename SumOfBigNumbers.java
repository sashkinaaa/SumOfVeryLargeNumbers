import java.util.Scanner;

public class SumOfBigNumbers {

	static int carry = 0;
	public static void main(String[] args) {
		System.out.println("Enter number 1:");
        Scanner s = new Scanner(System.in);
        String numberOne = s.nextLine();
        String reverseNumberOne = "";
        
        System.out.println("Enter number 2:");
        String numberTwo = s.nextLine();
        String reverseNumberTwo = "";
        String reverseResult = "";
        int smallerNumberLength, biggerNumberLength, sum;
        //int carry=0;
        
        reverseNumberOne = reverseString(numberOne);
        reverseNumberTwo = reverseString(numberTwo);
        if(numberOne.length()>numberTwo.length()) {
        	smallerNumberLength = numberTwo.length();
        	biggerNumberLength = numberOne.length();
        } else {
        	smallerNumberLength = numberOne.length();
        	biggerNumberLength = numberTwo.length();
        }
        
        for(int i = 0; i<smallerNumberLength; i++) {
        	sum = ((int)(reverseNumberOne.charAt(i) - '0') +  
                    (int)(reverseNumberTwo.charAt(i) - '0') + carry);
        	reverseResult  += (char)(sum % 10 + '0');
        	carry = sum / 10;  
        }
        
        if(smallerNumberLength != biggerNumberLength) {
        	if(numberOne.length()>numberTwo.length()) {
        		reverseResult += addRemainingDigits(numberOne,smallerNumberLength,biggerNumberLength);
        	} else {
        		reverseResult += addRemainingDigits(numberTwo,smallerNumberLength,biggerNumberLength);
        	}  
        }
        if (carry > 0)  
    	    reverseResult += (char)(carry + '0');
        
        System.out.println("Result: " + reverseString(reverseResult));
        s.close();
	}
	
	public static String reverseString(String str) {
		String reverseStr = "";
		for(int i = str.length() - 1; i >= 0; i--) {
			reverseStr = reverseStr + str.charAt(i);
        }
		return reverseStr;
	}
	
	public static String addRemainingDigits(String reverseNumber, int smallerNumberLength, int biggerNumberLength) {
		String reverseResult = "";
		for (int i = smallerNumberLength; i < biggerNumberLength; i++) {  
	        int sum = ((int)(reverseNumber.charAt(i) - '0') + carry);  
	        reverseResult += (char)(sum % 10 + '0');  
	        carry = sum / 10;  
	    }  
		return reverseResult;
	}

}
