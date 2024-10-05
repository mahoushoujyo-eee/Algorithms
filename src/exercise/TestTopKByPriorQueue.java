package exercise;

import java.util.Random;

public class TestTopKByPriorQueue
{
    public static void main(String[] args)
    {
        Integer[] nums = new Integer[11];
        Random random = new Random();

        for (int i = 1; i < nums.length; i++)
        {
            nums[i] = random.nextInt(100);
        }

        showNums(nums);

        TopKByPriorQueue<Integer> topKByPriorQueue = new TopKByPriorQueue<>(nums);

        System.out.println(topKByPriorQueue.topK(2));

    }

    public static void showNums(Integer[] nums)
    {
        for (Integer num: nums)
        {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
