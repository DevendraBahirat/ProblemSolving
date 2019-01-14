public class GCDofNumbers {
	public static void main(String[] args) {
		int num = 5;
		int[] numbers = new int[] {2,3,4,5,6};
		System.out.println(generalizedGCD(num, numbers));
	}

	static int gcd(int a, int b)
	{
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	// Function to find gcd of array of
	// numbers
	static int generalizedGCD(int num, int arr[])
	{
		int result = arr[0];
		for (int i = 1; i < num; i++)
			result = gcd(arr[i], result);

		return result;
	}
}
