import java.util.HashSet;
import java.util.Set;

public class GenerateParants {

    public static void main(String[] args) {
        Set<String> parantSet = generateParans(1);

        for (String item : parantSet)
            System.out.println(item);
    }

    private static Set<String> generateParans(int remaining)
    {
        Set<String> set=new HashSet<>();

        if(remaining==0)
        {
            set.add("");
            return set;
        }

        Set<String> prevs=generateParans(remaining-1);

        for(String str: prevs)
        {
            for(int i=0;i<str.length();i++)
            {
                if(str.charAt(i)=='(')
                    set.add(insertParantAt(str,i));
            }
            set.add("()"+str);
        }
        return set;
    }

    private static String insertParantAt(String str, int i)
    {
        return str.substring(0,i+1)+"()"+ str.substring(i+1);
    }
}
