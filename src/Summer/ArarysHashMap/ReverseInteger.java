package Summer.ArarysHashMap;

public class ReverseInteger
{
    public int reverse(int x)
    {
        if (x==0)
            return 0;
        String s ="";
        int sign=1;
        if (x<0)
        {
            sign=-1;
            x *=-1;
        }
       while (x>0)
       {
            int val = x%10;
            s +=val;
            x = x/10;
       }
       int newVal;
       try{
           newVal = sign*Integer.parseInt(s);
           return newVal;
       }
       catch(Exception ex){
           return 0;
        }

    }
}
