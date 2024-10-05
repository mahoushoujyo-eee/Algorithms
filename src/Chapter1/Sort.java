package Chapter1;

import java.util.Scanner;

public class Sort{
	public static void main(String[] args)
	{
		int[] nums = new int[3];

		Scanner input = new Scanner(System.in);
        nums[0] = input.nextInt();
		nums[1] = input.nextInt();
		nums[2] = input.nextInt();

		for(int i = 0; i < 2; i++)
		{
			int maxIndex = i;
			for(int j = i + 1; j < 3; j++)
			{
				if(nums[maxIndex] < nums[j])
					maxIndex = j;
			}
			int temp = nums[i];
			nums[i] = nums[maxIndex];
			nums[maxIndex] = temp;
		}

		System.out.println(nums[0] + " " + nums[1] + " " + nums[2]);
	}
}