package Exercise;

import java.util.ArrayList;
import java.util.Objects;

public class TestArrangeAndCombination
{
    public static void main(String[] args)
    {
        Integer[] arr = {1, 2, 3, 4, 5};

        ArrangeAndCombination<Integer> arrangeAndCombination = new ArrangeAndCombination<>(arr, 5);
        arrangeAndCombination.selectFromArray();
        showArray(arrangeAndCombination.arrList);
    }

    public static void showArray(ArrayList<Integer[]> arr)
    {
        for (Object[] arr1 : arr)
        {
            for (Object num : arr1)
                System.out.print(num + " ");
            System.out.print(",");
        }
    }
}
