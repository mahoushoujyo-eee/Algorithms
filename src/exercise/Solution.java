package exercise;

public class Solution
{
    public boolean isMatch(String s, String p)
    {
        int pIndex = 0;
        int sIndex = 0;
        while(pIndex < p.length())
        {
            if(p.charAt(pIndex) == '.')
            {
                if(p.charAt(pIndex+1) == '*') return true;
                pIndex++;
                sIndex++;
            }
            else
            {
                boolean isDone = false;
                if(pIndex < p.length()-1)
                {
                    if(p.charAt(pIndex+1) == '*')
                    {
                        isDone = true;
                        while(sIndex < s.length() && s.charAt(sIndex) == p.charAt(pIndex)) sIndex++;
                        pIndex += 2;
                    }
                }
                if(!isDone && p.charAt(pIndex) == s.charAt(sIndex))
                {
                    pIndex++;
                    sIndex++;
                }
                else if (!isDone)
                    return false;
            }
        }
        if(s.length() == sIndex) return true;
        else return false;
    }
}
