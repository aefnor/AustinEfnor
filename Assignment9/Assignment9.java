import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment9 {

	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader (System.in);
		BufferedReader stdin = new BufferedReader (isr);
		try{
		int[] list = new int[100];
		int startIndex = 0;
		boolean zero = false;
		String input;
		int i = 0;
		int value = 0;
		
		while(i<list.length && !zero){
			input = stdin.readLine();
			value = Integer.parseInt(input.toString());
			if(value == 0){
				zero = true;
			}
			else{
					list[i] = value;	
			}
			i++;
		}
		int endIndex = list.length-1;
		System.out.println("The minimum number is " + findMin(list, startIndex, endIndex));
		System.out.println("The total count of even numbers is " + countEven(list, startIndex, i-1));
		System.out.println("The sum of negative numbers is " + computeSumOfNegative(list, startIndex, endIndex));
		System.out.println("The total count of numbers that are greater than the first is " + countGreaterThanFirst(list, startIndex-1, i-1, list[0]));
	}
		catch(IOException e){
			System.out.println("What u doing bro");
		}
	}
	public static int findMin(int[] numbers, int startIndex, int endIndex){
		int min = 0;
		if(startIndex == endIndex){
			return numbers[endIndex];
		}
		else{
			min = findMin(numbers , startIndex+1, endIndex);
			if(numbers[startIndex]<= min){
				return numbers[startIndex];
			}
			else{
				return min;
			}
		}
		
	}
	public static int countEven(int[] numbers, int startIndex, int endIndex)
	{
		int result;
		if(startIndex == endIndex){
			if(numbers[startIndex]%2 == 0){
				result = 1;
			}
			else{
				result = 0;
			}
		}
		else{
			int count = countEven(numbers, startIndex, endIndex -1);
			if(numbers[endIndex] % 2 == 0){
				count++;
				result = count;
			}
			else{
				result = count;
			}
		}
		return result;
	}
	
	//computes some of all negative numbers
	public static int computeSumOfNegative(int[] numbers, int startIndex, int endIndex)
	{
		int result;
		if(startIndex == endIndex){
			if(numbers[startIndex] < 0){
				result = numbers[startIndex];
			}
			else{
				result = 0;
			}
		}
		else
		{
			int temp = computeSumOfNegative(numbers, startIndex, endIndex -1);
			if(numbers[endIndex] < 0)
			{
				result = numbers[endIndex] + temp;
			}
			else
			{
				result = temp;
			}
		}
		return result;
	}
	
	//counts all numbers that are greater than the first number
	public static int countGreaterThanFirst(int[] numbers, int startIndex, int endIndex, int firstNumber)
	{
		int result;
		if(startIndex == endIndex){
			result = 0;
		}
		else
		{
			int greater = countGreaterThanFirst(numbers, startIndex, endIndex - 1, firstNumber);
			if(numbers[endIndex] > firstNumber){
				greater++;
				result = greater;
			}
			else{
				result = greater;
			}
		}
		return result;
	}

}
