package Exercise;

public class JudgePrimer
{
    public static boolean isPrimer(int n)
    {
        if (n < 2)
            return false;

        for (int i = 2; i < Math.sqrt(n); i++)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
